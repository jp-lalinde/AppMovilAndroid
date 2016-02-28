package com.example.peter.appandroid_n1.PageAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.peter.appandroid_n1.Fragments.CategoriaDiversionFragment;
import com.example.peter.appandroid_n1.Fragments.CategoriaElectrodomesticosFragment;
import com.example.peter.appandroid_n1.Fragments.CategoriaMercadoFragment;
import com.example.peter.appandroid_n1.Fragments.CategoriaRestaurantesFragment;
import com.example.peter.appandroid_n1.Fragments.CategoriaSaludFragment;

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
        if(position==0)
        {
            return new CategoriaSaludFragment();
        }
        else if(position==1)
        {
            return new CategoriaRestaurantesFragment();
        }
        else if(position==2)
        {
            return new CategoriaDiversionFragment();
        }
        else if(position==3)
        {
            return new CategoriaMercadoFragment();
        }
        else
        {
            return new CategoriaElectrodomesticosFragment();
        }
    }

    @Override
    public int getCount()
    {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Salud";
            case 1:
                return "Restaurantes";
            case 2:
                return "Diversión";
            case 3:
                return "Mercado";
            case 4:
                return "Electrodomésticos";
        }
        return null;
    }
}
