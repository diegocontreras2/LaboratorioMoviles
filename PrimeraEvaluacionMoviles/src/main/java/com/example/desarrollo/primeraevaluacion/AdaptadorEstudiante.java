package com.example.desarrollo.primeraevaluacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {
    public AdaptadorEstudiante(@NonNull Context context, @NonNull List<Estudiante> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Estudiante estudiante = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_estudiante,parent,false);
        }

        TextView lblCorrelativo = convertView.findViewById(R.id.lyCorrelativo);
        TextView lblNombreEstudiante = convertView.findViewById(R.id.lyNombreEstudiante);
        TextView lblCodigoEstudiante = convertView.findViewById(R.id.lyCodigoEstudiante);
        TextView lblMateriaPromedio = convertView.findViewById(R.id.lyMateriaPromedio);

        lblCorrelativo.setText("" + (position + 1));
        lblNombreEstudiante.setText(estudiante.nombre);
        lblCodigoEstudiante.setText(estudiante.codigo);
        lblMateriaPromedio.setText(estudiante.materia + ": " + new DecimalFormat("#.00").format(estudiante.promedio).toString());

        return convertView;
    }
}
