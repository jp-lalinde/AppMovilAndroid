package com.example.peter.appandroid_n1.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Base64;
import android.util.Log;
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
import com.example.peter.appandroid_n1.Persistence.PersistenceManager;
import com.example.peter.appandroid_n1.R;
import com.example.peter.appandroid_n1.Servicios.CategoriaService;
import com.example.peter.appandroid_n1.Servicios.OfertaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 2/28/2016.
 */
public class CategoriaFragment extends ListFragment implements OnItemClickListener {


    private String[]web;
    private Bitmap[]imageId;
    private int position;
    String[]precios;

    public CategoriaFragment()
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
        System.out.println("LLEGUE AL FRAGMENTO");
        super.onActivityCreated(savedInstanceState);
        position = getArguments().getInt("position");

        System.out.println("Llego al fragmento");

        OfertaPersistence persistence = new OfertaPersistence(getActivity().getApplicationContext());
        List<OfertaModel> ofertas = new ArrayList<OfertaModel>();
        ofertas = persistence.getOfertaPorCategoria(position+1);

        imageId=new Bitmap[ofertas.size()];
        web = new String[ofertas.size()];
        precios = new String[ofertas.size()];


        for(int i=0;i<ofertas.size();i++)
        {
            byte[] flyer = Base64.decode(ofertas.get(i).getFlyer().getBytes(),Base64.DEFAULT);
            imageId[i]= BitmapFactory.decodeByteArray(flyer, 0, flyer.length);
            web[i]=String.valueOf(ofertas.get(i).getIdOferta());
            precios[i]=String.valueOf(ofertas.get(i).getPrecio());
            Log.d("IDOferta",web[i]);
            System.out.println(web[i]);
        }
        Log.d("TAMAÑO: ",""+imageId.length);

        IndexCustomList adapter = new IndexCustomList(getActivity(),web,imageId,precios);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id)
    {
        String idOferta = web[+ position];
        Log.d("Id oferta click",idOferta);
        Log.d("Id oferta web",web[position]);

        OfertaPersistence persistence = new OfertaPersistence(getActivity().getApplicationContext());
        OfertaModel modelo = persistence.getOfertaPorId(Long.valueOf(idOferta));
        if(modelo==null)
        {

        }


        Intent i = new Intent(getActivity().getApplicationContext(), MostrarOfertaActivity.class);
        i.putExtra("ofertaId", idOferta);
        startActivity(i);

    }


}
