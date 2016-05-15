package com.javiernunez.puppies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas= (RecyclerView) findViewById(R.id.rvMascotas);


        //GridLayoutManager lm = new GridLayoutManager(this,2);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(lm);
        inicializaListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializaListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota1,"Scooby", 3));
        mascotas.add(new Mascota(R.drawable.mascota2,"Infantil", 2));
        mascotas.add(new Mascota(R.drawable.mascota3,"Hamster", 4));
        mascotas.add(new Mascota(R.drawable.mascota4,"Marroncete", 5));
        mascotas.add(new Mascota(R.drawable.mascota5,"Tristón", 1));
        mascotas.add(new Mascota(R.drawable.mascota6,"Juguetón", 4));

    }

    public void irActividadFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, Favoritas.class);
        //intent.putExtra("listado",mascotas);
        startActivity(intent);
    }

}
