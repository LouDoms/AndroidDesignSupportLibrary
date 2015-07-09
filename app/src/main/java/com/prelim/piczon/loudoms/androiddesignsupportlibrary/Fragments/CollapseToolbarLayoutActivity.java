package com.prelim.piczon.loudoms.androiddesignsupportlibrary.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prelim.piczon.loudoms.androiddesignsupportlibrary.R;

/**
 * Created by LouDoms on 7/8/2015.
 */
public class CollapseToolbarLayoutActivity extends Fragment {

    View root;
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       collapsingToolbar = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapsing_toolbar);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.activity_collapse, container, false);
        return root;
    }
}
