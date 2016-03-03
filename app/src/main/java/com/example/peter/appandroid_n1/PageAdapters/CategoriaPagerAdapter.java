package com.example.peter.appandroid_n1.PageAdapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.peter.appandroid_n1.Activities.IndexActivity;
import com.example.peter.appandroid_n1.Fragments.CategoriaSaludFragment;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;

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
        CategoriaSaludFragment fragment = new CategoriaSaludFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount()
    {
        CategoriaPersistence persistencia = new CategoriaPersistence(IndexActivity.appContext);
        List<CategoriaModel>categorias = persistencia.getCategorias();
        return categorias.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        CategoriaPersistence categoriaPersistence=new CategoriaPersistence(IndexActivity.appContext);
        return categoriaPersistence.getNombreCategoria(new Long(position));
    }
}
