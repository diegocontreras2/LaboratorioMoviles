package com.example.desarrollo.primeraevaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EstudianteActivity extends AppCompatActivity {

    private TextView txtNombreEstudiante;
    private TextView txtCodigoEstudiante;
    private TextView txtMateriaEstudiante;
    private TextView txtPrimerParcialEstudiante;
    private TextView txtSegunoParcialEstudiante;
    private TextView txtTercerParcialEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        this.txtNombreEstudiante = findViewById(R.id.txtNombreEstudiante);
        this.txtCodigoEstudiante = findViewById(R.id.txtCodigoEstudiante);
        this.txtMateriaEstudiante= findViewById(R.id.txtMateriaEstudiante);
        this.txtPrimerParcialEstudiante = findViewById(R.id.txtPrimerParcialEstudiante);
        this.txtSegunoParcialEstudiante = findViewById(R.id.txtSegundoParcialEstudiante);
        this.txtTercerParcialEstudiante = findViewById(R.id.txtTercerParcialEstudiante);
    }

    public void onClickBotton(View view){
        if (view.getId() == R.id.btnGuardarEstudiante){

            if (!this.txtNombreEstudiante.getText().toString().isEmpty() && !this.txtCodigoEstudiante.getText().toString().isEmpty() && !this.txtMateriaEstudiante.getText().toString().isEmpty() && !this.txtPrimerParcialEstudiante.getText().toString().isEmpty() && !this.txtSegunoParcialEstudiante.getText().toString().isEmpty() && !this.txtTercerParcialEstudiante.getText().toString().isEmpty()){
                try {

                    if ((Double.parseDouble(this.txtPrimerParcialEstudiante.getText().toString()) >= 0 && Double.parseDouble(this.txtPrimerParcialEstudiante.getText().toString()) <= 10)
                            && (Double.parseDouble(this.txtSegunoParcialEstudiante.getText().toString()) >= 0 && Double.parseDouble(this.txtSegunoParcialEstudiante.getText().toString()) <= 10)
                            && (Double.parseDouble(this.txtTercerParcialEstudiante.getText().toString()) >= 0 && Double.parseDouble(this.txtTercerParcialEstudiante.getText().toString()) <= 10)){

                        Estudiante estudiante = new Estudiante();
                        estudiante.nombre = this.txtNombreEstudiante.getText().toString();
                        estudiante.codigo = this.txtCodigoEstudiante.getText().toString();
                        estudiante.materia = this.txtMateriaEstudiante.getText().toString();

                        estudiante.parcial1 = Double.parseDouble(this.txtPrimerParcialEstudiante.getText().toString());
                        estudiante.parcial2 = Double.parseDouble(this.txtSegunoParcialEstudiante.getText().toString());
                        estudiante.parcial3 = Double.parseDouble(this.txtTercerParcialEstudiante.getText().toString());
                        estudiante.promedio = (estudiante.parcial1 * 0.3) + (estudiante.parcial2 * 0.3) + (estudiante.parcial3 * 0.4);

                        Intent devolverDatosEstudiante = new Intent(EstudianteActivity.this,Principal.class);
                        devolverDatosEstudiante.putExtra("datosEstudiantes",estudiante);

                        setResult(RESULT_OK,devolverDatosEstudiante);
                        finish();
                    }else{
                        Toast.makeText(this,"Datos no validos",Toast.LENGTH_SHORT).show();
                    }


                }catch (NumberFormatException e){
                    Toast.makeText(this,"Datos no validos",Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(EstudianteActivity.this, "Error campos vacios", Toast.LENGTH_SHORT).show();
            }



        }
    }
}
