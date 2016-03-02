package com.example.peter.appandroid_n1.CustomLists;

/**
 * Created by usuario on 2/28/2016.
 */

import android.app.Activity;
import android.graphics.Bitmap;
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

    public IndexCustomList(Activity context, String[] web, Bitmap[] imageId)
    {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.imageId = imageId;
        this.web = web;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgOferta);

        imageView.setImageBitmap(imageId[position]);
        return rowView;
    }
}
