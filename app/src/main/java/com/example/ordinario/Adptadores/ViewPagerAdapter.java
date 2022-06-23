package com.example.ordinario.Adptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ordinario.Entidades.Sitio;
import com.example.ordinario.Mapa.Mapa;
import com.example.ordinario.R;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Sitio> modelo;
    Context context;

    public ViewPagerAdapter(ArrayList<Sitio> modelo, Context context) {
        this.modelo = modelo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelo.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);
        ImageView imagen;
        TextView nombre, descripcion;
        imagen = view.findViewById(R.id.imageView);
        nombre = view.findViewById(R.id.txtNombre);
        descripcion = view.findViewById(R.id.txtDescripcion);
        imagen.setImageResource(modelo.get(position).getImagenId());
        nombre.setText(modelo.get(position).getNombre());
        descripcion.setText(modelo.get(position).getDescripcion());

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(context, Mapa.class);

                Toast.makeText(imagen.getContext(), "Seleccionó: "+ nombre.getText(), Toast.LENGTH_SHORT).show();
                switch (nombre.getText()+""){
                    case "Universidad del Istmo":
                        i.putExtra("Longitud",16.288914348605175);
                        i.putExtra("Latitud",-95.24087069875968);
                        i.putExtra("Nombre", nombre.getText());
                        context.startActivity(i);
                        break;
                    case "Parque Miguel Hidalgo":
                        i.putExtra("Longitud",16.568267045187223);
                        i.putExtra("Latitud",-95.09846289772922);
                        i.putExtra("Nombre", nombre.getText());
                        context.startActivity(i);
                        break;
                    case "Gimnasio Halcon":
                        i.putExtra("Longitud",16.564798329493122);
                        i.putExtra("Latitud",-95.0980115279016);
                        i.putExtra("Nombre", nombre.getText());
                        context.startActivity(i);
                        break;
                    case "Abarrotes Super Todo":
                        i.putExtra("Longitud",16.546314567078486);
                        i.putExtra("Latitud",-95.08892592498154);
                        i.putExtra("Nombre", nombre.getText());
                        context.startActivity(i);
                        break;
                }
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
