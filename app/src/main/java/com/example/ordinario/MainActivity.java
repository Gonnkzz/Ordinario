package com.example.ordinario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import com.example.ordinario.Adptadores.ViewPagerAdapter;
import com.example.ordinario.Entidades.Sitio;
import com.example.ordinario.Presentador.InterfacePresentador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InterfacePresentador {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<Sitio> listaSitios;
    Integer[] color  = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        listaSitios = new ArrayList<Sitio>();
        setSitios();

        viewPagerAdapter = new ViewPagerAdapter(listaSitios, this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPadding(50, 0, 50, 0);

        Integer[] color_temp = {
                getResources().getColor(R.color.UnistmoColor),
                getResources().getColor(R.color.ParqueColor),
                getResources().getColor(R.color.GymColor),
                getResources().getColor(R.color.AbarroteColor)
        };

        color = color_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position < (viewPagerAdapter.getCount()-1) && position < (color.length)-1){
                    viewPager.setBackgroundColor((Integer)
                            argbEvaluator.evaluate(positionOffset,
                                    color[position],
                                    color[position+1]));
                }else {
                    viewPager.setBackgroundColor(color[color.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void setSitios (){
        listaSitios.add(new Sitio("Universidad del Istmo", "La universidad del istmo es una de las mejores universidades " +
                "donde se forjan los nuevos talentos del mañana",R.drawable.unistmo));
        listaSitios.add(new Sitio("Parque Miguel Hidalgo", "El parque Miguel Hidalgo es uno de los lugares mejor situados para " +
                "estar en compañia de los familiares contando con grandes espacios de diversion para los mas pequeños",R.drawable.parque));
        listaSitios.add(new Sitio("Gimnasio Halcon", "La salud es muy importante por eso el gimnasio Halcon ofrece sus " +
                "espacios en los que tienen crossfit y gimnasio con hierro",R.drawable.gym));
        listaSitios.add(new Sitio("Abarrotes Super Todo", "Apoyando a los negocios locales, Cd. Ixtepec tiene un abarrotes " +
                "Super todo en el que puedes ir a comprar con la seguridad de que lo que busques ahí estará",R.drawable.abarrotes));
    }


}