package com.example.appdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView txt_topbar;
    private RadioGroup rg_group;
    private RadioButton rb_homepage;
    private RadioButton rb_console;
    private RadioButton rb_coludinformation;
    private RadioButton rb_usercenter;
    private FrameLayout ly_content;


    private HomePageFragment fg1;
    private ConsoleFragment fg2;
    private ColudInformationFragment fg3;
    private UserCenterFragment fg4;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        binViews();
        txt_topbar.setText(rb_homepage.getText());
        rb_homepage.setChecked(true);
    }

    private void binViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_group = (RadioGroup) findViewById(R.id.rg_group);
        rb_homepage = (RadioButton) findViewById(R.id.rb_homepage);
        rb_console = (RadioButton) findViewById(R.id.rb_console);
        rb_coludinformation = (RadioButton) findViewById(R.id.rb_coludinformation);
        rb_usercenter = (RadioButton) findViewById(R.id.rb_usercenter);


        rg_group.setOnCheckedChangeListener(this);
    }



    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        hidAllFragment(fTransaction);
        switch (checkedId) {
            case R.id.rb_homepage:
                if(fg1 == null){
                    fg1 = new HomePageFragment();
                    fTransaction.add(R.id.ly_content,fg1);
                    txt_topbar.setText(rb_homepage.getText());

                }else{
                    txt_topbar.setText(rb_homepage.getText());
                    fTransaction.show(fg1);
                }
                break;
            case R.id.rb_console:
                if(fg2 == null){
                    fg2 = new ConsoleFragment();
                    fTransaction.add(R.id.ly_content,fg2);
                    txt_topbar.setText(rb_console.getText());

                }else{
                    txt_topbar.setText(rb_console.getText());
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rb_coludinformation:
                if(fg3 == null){
                    fg3 = new ColudInformationFragment();
                    fTransaction.add(R.id.ly_content,fg3);
                    txt_topbar.setText(rb_coludinformation.getText());

                }else{
                    txt_topbar.setText(rb_coludinformation.getText());
                    fTransaction.show(fg3);
                }
                break;
            case R.id.rb_usercenter:
                if(fg4 == null){

                    fg4 = new UserCenterFragment();
                    fTransaction.add(R.id.ly_content,fg4);
                    txt_topbar.setText(rb_usercenter.getText());

                }else{
                    txt_topbar.setText(rb_usercenter.getText());
                    fTransaction.show(fg4);
                }
                break;

        }
        fTransaction.commit();

    }
    //隐藏所有的Fragment
    private void hidAllFragment(FragmentTransaction fragmentTransaction) {
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }
}

