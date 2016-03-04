package com.example.peter.appandroid_n1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.example.peter.appandroid_n1.Persistence.PersistenceManager;
import com.example.peter.appandroid_n1.R;
import com.example.peter.appandroid_n1.Servicios.OfertaService;

public class MostrarOfertaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_oferta);
        OfertaService ofertaService = new OfertaService();
        Intent i = getIntent();
        String oferta = i.getStringExtra("oferta");
        //TODO Buscar la oferta
        //OfertaModel ofertaModel = new OfertaModel(123, 70000,"2016/03/02 06:00:00", "2016/04/02 23:00:00",null);
        OfertaPersistence persistence = PersistenceManager.getInstance().getOfertaPersistence();
        OfertaModel ofertaModel = persistence.getOfertaPorId( Long.getLong(oferta) );

        if(ofertaModel!=null)
        {
            TextView txtPrecio = (TextView)findViewById(R.id.txtPrecio);
            txtPrecio.setText(String.valueOf(ofertaModel.getPrecio()));

            TextView txtFechaInicio = (TextView)findViewById(R.id.txtFechaInicio);
            txtFechaInicio.setText(ofertaModel.getFechaInicio());

            TextView txtFechaFin = (TextView)findViewById(R.id.txtFechaFin);
            txtFechaFin.setText(ofertaModel.getFechaFin());
        }

    }
}
