package com.prelim.piczon.loudoms.androiddesignsupportlibrary.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prelim.piczon.loudoms.androiddesignsupportlibrary.R;

/**
 * Created by LouDoms on 7/8/2015.
 */
public class TabLayoutActivity extends Fragment {

    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.activity_tab, container, false);
        return root;
    }
}
