package com.example.xue.demo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView txt_add;
    private TextView txt_delete;
    private TextView txt_update;
    private TextView txt_query;
    private TextView txt_top_bar;
    private FrameLayout ly_content;


    private MyFragmentActivity fg1, fg2, fg3, fg4;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        bindViews();
        txt_add.performClick();//模拟一次点击，既进去以后选择第一项
    }

    //UI组件初始化于事件绑定
    private void bindViews() {
        txt_add = (TextView) findViewById(R.id.txt_add);
        txt_delete = (TextView) findViewById(R.id.txt_delete);
        txt_update = (TextView) findViewById(R.id.txt_update);
        txt_query = (TextView) findViewById(R.id.txt_query);
        txt_top_bar = (TextView) findViewById(R.id.txt_topbar);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_add.setOnClickListener(this);
        txt_delete.setOnClickListener(this);
        txt_update.setOnClickListener(this);
        txt_query.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected() {
        txt_add.setSelected(false);
        txt_delete.setSelected(false);
        txt_update.setSelected(false);
        txt_query.setSelected(false);
    }

    //隐藏所有的Fragment
    private void hidAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        hidAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.txt_add:

                setSelected();
                txt_top_bar.setText(txt_add.getText());
                txt_add.setSelected(true);
                if (fg1 == null) {
                    fg1 = new MyFragmentActivity("第一个Fragment");
                    fTransaction.add(R.id.ly_content, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.txt_delete:
                txt_top_bar.setText(txt_delete.getText());
                setSelected();
                txt_delete.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MyFragmentActivity("第二个Fragment");
                    fTransaction.add(R.id.ly_content, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.txt_update:
                txt_top_bar.setText(txt_update.getText());
                setSelected();
                txt_update.setSelected(true);
                if (fg3 == null) {
                    fg3 = new MyFragmentActivity("第三个Fragment");
                    fTransaction.add(R.id.ly_content, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.txt_query:

                txt_top_bar.setText(txt_query.getText());
                setSelected();
                txt_query.setSelected(true);
                if (fg4 == null) {
                    fg4 = new MyFragmentActivity("第四个Fragment");
                    fTransaction.add(R.id.ly_content, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                break;

        }
        fTransaction.commit();
    }
}
