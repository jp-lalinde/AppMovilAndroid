package com.example.peter.appandroid_n1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 2/28/2016.
 */
public class CategoriaSaludFragment extends Fragment {

    public CategoriaSaludFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        TextView myText = new TextView(getActivity());
        myText.setText("Fragmento de salud");
        myText.setGravity(Gravity.CENTER);
        return myText;
    }
}
