package com.example.sqlite;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {


    //UI Object
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_add;
    private RadioButton rb_delete;
    private RadioButton rb_update;
    private RadioButton rb_query;
    private ViewPager viewPager;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;


    //几个表表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportFragmentManager（）方法只能在FragmentActivity和AppcompatActivity 使用
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        binViews();
        txt_topbar.setText(rb_add.getText());
        rb_add.setChecked(true);

    }

    private void binViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_add = (RadioButton) findViewById(R.id.rb_add);
        rb_delete = (RadioButton) findViewById(R.id.rb_delete);
        rb_update = (RadioButton) findViewById(R.id.rb_update);
        rb_query = (RadioButton) findViewById(R.id.query);
        rg_tab_bar.setOnCheckedChangeListener(this);


        viewPager = (ViewPager) findViewById(R.id.vpager);


        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);

    }
    @Override
    public void onCheckedChanged(RadioGroup group,  int checkedId) {
        switch (checkedId){
            case R.id.rb_add :
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_delete :
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_update :
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.query :
                viewPager.setCurrentItem(PAGE_FOUR);
                break;

        }

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state有三个状态， 0 表示什么都没做  1表示正在滑动 2表示滑动完毕
        if (state == 2){
            switch (viewPager.getCurrentItem()){
                case PAGE_ONE:
                    rb_add.setChecked(true);
                    txt_topbar.setText(rb_add.getText());
                    break;
                case PAGE_TWO:
                    rb_delete.setChecked(true);
                    txt_topbar.setText(rb_delete.getText());
                    break;
                case PAGE_THREE:
                    rb_update.setChecked(true);
                    txt_topbar.setText(rb_update.getText());
                    break;
                case PAGE_FOUR:
                    rb_query.setChecked(true);
                    txt_topbar.setText(rb_query.getText());
                    break;
            }
        }
    }


}
