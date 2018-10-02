package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorMensage extends ArrayAdapter<Mensage> {

    public AdaptadorMensage(Context context, List<Mensage> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Mensage mensage = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensage, parent, false);
        }

        TextView lblFechaHora = (TextView) convertView.findViewById(R.id.lblFechaHora);
        TextView lblMensaje = (TextView) convertView.findViewById(R.id.lblMensage);

        // mostrar los datos
        lblFechaHora.setText(mensage.fecha);
        lblMensaje.setText(mensage.contenido);

        // Return la convertView ya con los datos
        return convertView;
    }
}
