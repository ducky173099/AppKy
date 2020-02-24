package com.example.app_ky.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.app_ky.R;
import com.example.app_ky.activity.MainActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    TextView textClose;
    Toolbar toolbar;
    MainActivity mainActivity;
    public LinearLayout linearLayout;

    public BottomSheetFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sheet_bottom, container, false);
        mainActivity = (MainActivity) getActivity();
        textClose = view.findViewById(R.id.text_close);
        linearLayout = view.findViewById(R.id.linear_layout);
//        toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setFitsSystemWindows(true);

//        if (toolbar.isScrollbarFadingEnabled()){
//            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//        }

        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
}
