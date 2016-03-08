package com.example.peter.appandroid_n1.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.example.peter.appandroid_n1.Persistence.PersistenceManager;
import com.example.peter.appandroid_n1.R;

import java.sql.SQLException;

public class MostrarOfertaActivity extends AppCompatActivity {


    OfertaPersistence persistence;
    private Dialog dialogSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_oferta);
        Intent i = getIntent();
        Long oferta = Long.valueOf(i.getStringExtra("ofertaId")).longValue();
        persistence = new OfertaPersistence(this.getApplicationContext());
        OfertaModel ofertaModel = persistence.getOfertaPorId(oferta);


        inicializacionGUI(ofertaModel);



    }

    public void openDialogSMS(View view)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        final EditText editText = new EditText(this.getApplicationContext());
        editText.setTextColor(Color.BLACK);
        builder.setMessage(R.string.dialog_sms);
        builder.setView(editText);

        builder.setPositiveButton(R.string.dialog_aceptar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String mensaje = editText.getText().toString();
                //Enviar SMS
                android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
                smsManager.sendTextMessage("573182393565",null,mensaje,null,null);
                smsManager.sendTextMessage(ConstantesGlobales.TWILIO_PHONE,null,mensaje,null,null);
            }
        });

        builder.setNegativeButton(R.string.dialog_cancelar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onResume()
    {
        try
        {
            persistence.openDBConn();
        }
        catch(SQLException e)
        {

        }
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        //persistenceManager.closeDBConn();
        super.onPause();
    }

    /**
     *
     */
    private void inicializacionGUI(OfertaModel ofertaModel)
    {

        if(ofertaModel!=null)
        {
            TextView txtPrecio = (TextView)findViewById(R.id.txtPrecio);
            txtPrecio.setText(String.valueOf(ofertaModel.getPrecio()));



            TextView txtFechaInicio = (TextView)findViewById(R.id.txtFechaInicio);
            txtFechaInicio.setText(ofertaModel.getFechaInicio());



            TextView txtFechaFin = (TextView)findViewById(R.id.txtFechaFin);
            txtFechaFin.setText(ofertaModel.getFechaFin());

            byte[] flyer = Base64.decode(ofertaModel.getFlyer().getBytes(), Base64.DEFAULT);
            ImageView imgOferta = (ImageView)findViewById(R.id.flyerOferta);
            //imgOferta.setImageBitmap(BitmapFactory.decodeByteArray(flyer, 0, flyer.length));


        }
    }

}
