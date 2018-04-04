package com.suozhang.rentaluser.feature.life.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContractedFragment extends ContractingFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isCurrentContract=false;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
