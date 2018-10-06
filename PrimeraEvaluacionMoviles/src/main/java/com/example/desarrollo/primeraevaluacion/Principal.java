package com.example.desarrollo.primeraevaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private ArrayList<Estudiante> estudianteArrayList;
    private TextView btnListaEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.estudianteArrayList = new ArrayList<>();
        this.btnListaEstudiantes = findViewById(R.id.btnListaEstudiante);
    }

    public void onClickBotton(View view){
        if (view.getId() == R.id.btnNuevoEstudiante){
            Intent llamarActivityEstudiante = new Intent(Principal.this,EstudianteActivity.class);
            startActivityForResult(llamarActivityEstudiante,1);

        }else{
            Intent llamarActivityListaEstudiante = new Intent(Principal.this,ListaEstudiantesActivity.class);
            llamarActivityListaEstudiante.putExtra("listadoEstudiantes",this.estudianteArrayList);
            startActivity(llamarActivityListaEstudiante);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                this.estudianteArrayList.add((Estudiante) data.getExtras().getSerializable("datosEstudiantes"));
                this.btnListaEstudiantes.setText("Lista Estudiantes: " + this.estudianteArrayList.size());
                Toast.makeText(Principal.this,"Datos guardados",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Principal.this,"No se guardaron datos",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
