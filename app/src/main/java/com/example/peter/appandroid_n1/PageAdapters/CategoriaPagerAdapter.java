package com.example.peter.appandroid_n1.PageAdapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.peter.appandroid_n1.Activities.IndexActivity;
import com.example.peter.appandroid_n1.Fragments.CategoriaFragment;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;
import com.example.peter.appandroid_n1.Persistence.PersistenceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 2/28/2016.
 */
public class CategoriaPagerAdapter extends FragmentStatePagerAdapter{

    public CategoriaPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Bundle bundle= new Bundle();
        bundle.putInt("position", position);
        CategoriaFragment fragment = new CategoriaFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount()
    {
        CategoriaPersistence persistencia = new CategoriaPersistence(IndexActivity.appContext);
        List<CategoriaModel>categorias = new ArrayList<CategoriaModel>();

            //persistencia.openDBConn();
            categorias = persistencia.getCategorias();
            //persistencia.closeDBConn();



        return categorias.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        CategoriaPersistence persistencia = new CategoriaPersistence(IndexActivity.appContext);
        String nombreCategoria = "";

            //persistence.openDBConn();
            nombreCategoria = persistencia.getNombreCategoria(new Long(position+1));
            //persistence.closeDBConn();

        return nombreCategoria;
    }
}
