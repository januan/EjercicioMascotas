package com.javiernunez.puppies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFav;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quito imagen 5 estrellas
        ImageView img5Stars= (ImageView) findViewById(R.id.imgFiveStarts);
        img5Stars.setVisibility(View.INVISIBLE);

        //recibe datos mascotas -> ToDo ver cómo pasar un listado
        /*
        Bundle parametros = getIntent().getExtras();
        mascotasFav =  (ArrayList<Mascota>) getIntent().getSerializableExtra("listado");
        */


        listaMascotasFav= (RecyclerView) findViewById(R.id.rvMascotasFavoritas);


        //GridLayoutManager lm = new GridLayoutManager(this,2);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(lm);

        inicializaListaMascotasFav();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFav);
        listaMascotasFav.setAdapter(adaptador);
    }

    public void inicializaListaMascotasFav(){
        mascotasFav = new ArrayList<Mascota>();

        mascotasFav.add(new Mascota(R.drawable.mascota4,"Marroncete", 5));
        mascotasFav.add(new Mascota(R.drawable.mascota3,"Hamster", 4));
        mascotasFav.add(new Mascota(R.drawable.mascota6,"Juguetón", 4));
        mascotasFav.add(new Mascota(R.drawable.mascota1,"Scooby", 3));
        mascotasFav.add(new Mascota(R.drawable.mascota2,"Infantil", 2));

    }

}
