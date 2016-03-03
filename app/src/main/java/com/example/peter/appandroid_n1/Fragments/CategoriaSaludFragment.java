package com.example.peter.appandroid_n1.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.CustomLists.IndexCustomList;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.example.peter.appandroid_n1.R;
import com.example.peter.appandroid_n1.Servicios.CategoriaService;
import com.example.peter.appandroid_n1.Servicios.OfertaService;

import java.util.List;

/**
 * Created by usuario on 2/28/2016.
 */
public class CategoriaSaludFragment extends ListFragment implements OnItemClickListener {


    private String[]web;
    private Bitmap[]imageId;

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
//        super.onActivityCreated(savedInstanceState);
//
//        System.out.println("Llego al fragmento de salud");
//        TODO Desplegar las ofertas en la lista
//        OfertaService serv = new OfertaService();
//        serv.pullAndStoreTopOfertas(super.getActivity());
//        OfertaPersistence persistence = new OfertaPersistence(super.getActivity());
//        List<OfertaModel> ofertas = persistence.getOfertaPorCategoria(ConstantesGlobales.CATEGORIA_SALUD);
//        imageId=new Bitmap[ofertas.size()];
//        web = new String[ofertas.size()];
//
//        for(int i=0;i<ofertas.size();i++)
//        {
//            imageId[i]=ofertas.get(i).getFlyer();
//            web[i]=String.valueOf(ofertas.get(i).getIdOferta());
//            System.out.println(web[i]);
//        }
//        IndexCustomList adapter = new IndexCustomList(getActivity(),web,imageId);
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id)
    {
        String idOferta = web[+ position];
        Intent i = new Intent(getActivity().getApplicationContext(), MostrarOfertaActivity.class);
        i.putExtra("oferta", idOferta);
        startActivity(i);

    }


}
