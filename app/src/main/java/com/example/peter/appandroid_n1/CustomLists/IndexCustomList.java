package com.example.peter.appandroid_n1.CustomLists;

/**
 * Created by usuario on 2/28/2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.peter.appandroid_n1.R;

public class IndexCustomList extends ArrayAdapter <String> {

    private final Activity context;
    private final Integer[] imageId;

    public IndexCustomList(Activity context, String[] web, Integer[] imageId)
    {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgOferta);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
