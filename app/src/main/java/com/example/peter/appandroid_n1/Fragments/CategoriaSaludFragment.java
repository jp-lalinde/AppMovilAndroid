package com.example.peter.appandroid_n1.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peter.appandroid_n1.Activities.MostrarOfertaActivity;
import com.example.peter.appandroid_n1.CustomLists.IndexCustomList;
import com.example.peter.appandroid_n1.R;

/**
 * Created by usuario on 2/28/2016.
 */
public class CategoriaSaludFragment extends ListFragment implements OnItemClickListener {

    String[]web={
            "Promocion Dolex 2x1",
            "Spa para 2",
            "1 año de membresía BodyTech"
    };
    Integer[] imageId ={
            R.drawable.promo1,
            R.drawable.promo2,
            R.drawable.promo3
    };

    public CategoriaSaludFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        //TODO Desplegar las ofertas en la lista
        IndexCustomList adapter = new IndexCustomList(getActivity(),web,imageId);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id)
    {
        String oferta = web[+ position];
        Intent i = new Intent(getActivity().getApplicationContext(), MostrarOfertaActivity.class);

        i.putExtra("oferta", oferta);
        startActivity(i);
    }


}
