package com.example.sqlite;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Xue on 2017/9/5.
 */

public class AddFragment extends android.support.v4.app.Fragment {
    public AddFragment(){}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add,container,false);

        Log.e("HEHE","1日狗");
        return view;


    }
}
