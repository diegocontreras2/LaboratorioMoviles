package com.example.desarrollo.primeraevaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaEstudiantesActivity extends AppCompatActivity {

    private ArrayList<Estudiante> estudianteArrayList;
    private AdaptadorEstudiante adaptadorEstudiante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

        if(getIntent().getExtras().getSerializable("listadoEstudiantes") != null){
            this.estudianteArrayList = (ArrayList<Estudiante>) getIntent().getExtras().getSerializable("listadoEstudiantes");
            this.adaptadorEstudiante = new AdaptadorEstudiante(this,this.estudianteArrayList);
            ListView listView = findViewById(R.id.lyListaEstudiantes);

            listView.setAdapter(adaptadorEstudiante);
        }


    }
}
