package com.visticsolution.posterbanao.editor.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.visticsolution.posterbanao.R;
import com.visticsolution.posterbanao.editor.interfaces.GetSelectSize;

public class SizeSelection extends BottomSheetDialogFragment implements View.OnClickListener {

    GetSelectSize getSizeOptions;
    View view;

    public SizeSelection(GetSelectSize getSizeOptions) {
        this.getSizeOptions = getSizeOptions;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.size_options_grid, viewGroup, false);
        this.view.findViewById(R.id.back_btn).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn01).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn02).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn03).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn04).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn05).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn06).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn1).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn2).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn3).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn4).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn5).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn6).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn7).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn8).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn9).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn10).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn11).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn12).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn13).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn14).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn15).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn16).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn17).setOnClickListener(this);
        this.view.findViewById(R.id.size_btn18).setOnClickListener(this);
        return this.view;
    }

    public void onClick(View view2) {
        switch (view2.getId()) {
            case R.id.back_btn:
                dismiss();
                break;
            case R.id.size_btn01:
            case R.id.size_btn02:
            case R.id.size_btn03:
            case R.id.size_btn04:
            case R.id.size_btn05:
            case R.id.size_btn06:
                this.getSizeOptions.ratioOptions(view2.getTag().toString());
                dismiss();
                return;
            case R.id.size_btn1:
            case R.id.size_btn10:
            case R.id.size_btn11:
            case R.id.size_btn12:
            case R.id.size_btn13:
            case R.id.size_btn14:
            case R.id.size_btn15:
            case R.id.size_btn16:
            case R.id.size_btn17:
            case R.id.size_btn18:
            case R.id.size_btn2:
            case R.id.size_btn3:
            case R.id.size_btn4:
            case R.id.size_btn5:
            case R.id.size_btn6:
            case R.id.size_btn7:
            case R.id.size_btn8:
            case R.id.size_btn9:
                this.getSizeOptions.sizeOptions(view2.getTag().toString());
                dismiss();
                return;
            default:
                return;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        freeMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        freeMemory();
    }

    public void freeMemory() {
        try {
            new Thread(() -> {
                try {
                    Glide.get(SizeSelection.this.getActivity()).clearDiskCache();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            Glide.get(getActivity()).clearMemory();
        } catch (OutOfMemoryError | Exception e) {
            e.printStackTrace();
        }
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
