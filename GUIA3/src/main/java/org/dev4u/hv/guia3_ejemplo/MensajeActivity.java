package org.dev4u.hv.guia3_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MensajeActivity extends AppCompatActivity {

    AdaptadorMensage adaptadorMensage;
    ArrayList<Mensage> datos;
    TextView txtEntrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        this.datos = new ArrayList<>();
        this.txtEntrada = findViewById(R.id.txtEntrada);
        this.adaptadorMensage = new AdaptadorMensage(MensajeActivity.this,datos);

        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        listView.setAdapter(adaptadorMensage);
    }


    public void onClickButton(View view){

        if (view.getId() == R.id.btnEnviar){

            Date horaFeha = new Date();
            SimpleDateFormat FormatoFecha = new SimpleDateFormat("EEE., d MMM. yyyy, hh:mm", new Locale("es_ES"));
            String Fecha = FormatoFecha.format(horaFeha);

            Mensage mensaje = new Mensage(Fecha, txtEntrada.getText().toString());
            datos.add(mensaje);
            adaptadorMensage.notifyDataSetChanged();
        }
    }


}
