package com.example.peter.appandroid_n1.CustomLists;

/**
 * Created by usuario on 2/28/2016.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.peter.appandroid_n1.R;

public class IndexCustomList extends ArrayAdapter <String> {

    private final Activity context;
    private final Bitmap[] imageId;
    private final String[] web;
    private final String[] precios;


    public IndexCustomList(Activity context, String[] web, Bitmap[] imageId, String[]precios)
    {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.imageId = imageId;
        this.web = web;
        this.precios=precios;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgOferta);
        TextView textViewPrecio = (TextView) rowView.findViewById(R.id.txtPrecioIndex);
        TextView textViewId = (TextView) rowView.findViewById(R.id.txtIdIndex);

        //imageView.setImageDrawable(placeholder);
        textViewPrecio.setText("Precio: "+precios[position]);
        textViewId.setText("Id: "+web[position]);
        return rowView;
    }
}
