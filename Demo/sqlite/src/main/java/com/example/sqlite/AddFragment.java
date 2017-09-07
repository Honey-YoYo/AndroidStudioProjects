package com.example.sqlite;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Xue on 2017/9/5.
 */

public class AddFragment extends android.support.v4.app.Fragment {
    public AddFragment() {
    }

    private SQLiteDatabase db;
    private StringBuilder sb;
    private int i = 1;

    private Context mContext;
    private TextView txt_name;
    private TextView txt_age;
    private TextView txt_email;
    private TextView txt_adress;
    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_email;
    private EditText edt_adress;
    private MyDBOpenHelper myDBHelper;
    private Button btn_commit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add, container, false);
        mContext = getActivity();
        myDBHelper = new MyDBOpenHelper(mContext, "my.db", null, 1);
        txt_name = (TextView) view.findViewById(R.id.txt_name);
        txt_age = (TextView) view.findViewById(R.id.txt_age);
        txt_email = (TextView) view.findViewById(R.id.txt_email);
        txt_adress = (TextView) view.findViewById(R.id.txt_adress);
        edt_name = (EditText) view.findViewById(R.id.edt_name);
        edt_age = (EditText) view.findViewById(R.id.edt_age);
        edt_email = (EditText) view.findViewById(R.id.edt_email);
        edt_adress = (EditText) view.findViewById(R.id.edt_adress);
        btn_commit = (Button) view.findViewById(R.id.btn_commit);
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values1 = new ContentValues();
                values1.put("name", "呵呵~" + i);
                i++;
                //参数依次是：表名，强行插入null值得数据列的列名，一行记录的数据
                db.insert("person", "1", values1);
                Toast.makeText(mContext, "插入完毕~", Toast.LENGTH_SHORT).show();
            }


        });
        return view;
    }


}
