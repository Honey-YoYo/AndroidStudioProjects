package com.example.sqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.dao.DaoMaster;
import com.example.sqlite.dao.DaoSession;
import com.example.sqlite.dao.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;

/**
 * Created by Xue on 2017/9/5.
 */

public class AddFragment extends android.support.v4.app.Fragment {
    public AddFragment() {
    }

    private Button btn_commit;
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private StudentDao mstudentDao;

    private EditText edt_id;
    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_email;
    private EditText edt_address;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add, container, false);

        edt_id = (EditText) view.findViewById(R.id.edt_id);
        edt_name = (EditText) view.findViewById(R.id.edt_name);
        edt_age = (EditText) view.findViewById(R.id.edt_age);
        edt_email = (EditText) view.findViewById(R.id.edt_email);
        edt_address = (EditText) view.findViewById(R.id.edt_address);


        mDevOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "person.db", null);
        mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
        mstudentDao = mDaoSession.getStudentDao();

        edt_id.setSelected(true);

        btn_commit = (Button) view.findViewById(R.id.btn_commit);
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edt_id.getText().toString();
                String name = edt_name.getText().toString();
                String age = edt_age.getText().toString();
                String email = edt_email.getText().toString();
                String address = edt_address.getText().toString();

                if (isNotEmpty(name) && isNotEmpty(age)) {
                    QueryBuilder qb = mstudentDao.queryBuilder();
                    ArrayList<Student> list = (ArrayList<Student>) qb.where(StudentDao.Properties.Id.eq(id)).list();
                        if (list.size() > 0) {
                        Toast.makeText(getActivity(), "已经有该id的学生", Toast.LENGTH_SHORT).show();
                    } else {
                        mstudentDao.insert(new Student(Long.valueOf(id), name,age,email,address));
                        Toast.makeText(getActivity(), "插入学生信息成功", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (isEmpty(id) && isNotEmpty(name)) {
                        Toast.makeText(getActivity(), "id为空", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(name) && isNotEmpty(id)) {
                        Toast.makeText(getActivity(), "姓名为空", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(id) && isEmpty(name)) {
                        Toast.makeText(getActivity(), "请填写学生信息", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(address) && isEmpty(email)) {
                        Toast.makeText(getActivity(), "请补全学生信息", Toast.LENGTH_SHORT).show();
                    }


                }
                edt_id.setText("");
                edt_name.setText("");
                edt_age.setText("");
                edt_email.setText("");
                edt_address.setText("");
            }

        });

        return view;


    }

    public void insert() {
        Student student = new Student();
        mstudentDao.insert(student);

        edt_name.setText("");
        edt_age.setText("");
    }

    private boolean isNotEmpty(String s) {
        if (s != null && !s.equals("") || s.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty(String s) {
        if (isNotEmpty(s)) {
            return false;
        } else {
            return true;
        }
    }
}
