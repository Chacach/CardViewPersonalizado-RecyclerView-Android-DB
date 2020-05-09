package com.chacachx.cardviewpersonalizadorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.chacachx.cardviewpersonalizadorecyclerview.adapter.adaptador;
import com.chacachx.cardviewpersonalizadorecyclerview.dto.listaItems;
import com.chacachx.cardviewpersonalizadorecyclerview.query.query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView cardViewPersonalizada, cardViewPersonalizadaDos;
    ArrayList<listaItems> listaDeItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //VERTICAL
        cardViewPersonalizada = findViewById(R.id.cardViewPersonalizada);
        //HORIZONTAL
        cardViewPersonalizadaDos = findViewById(R.id.cardViewPersonalizadaDos);
        //HORIZONTAL
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cardViewPersonalizadaDos.setLayoutManager(layoutManager);
        //VERTICAL
        cardViewPersonalizada.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        query consulta = new query();
        listaDeItems = consulta.listaItemsDB(getApplicationContext());

        adaptador adaptadorLista = new adaptador(listaDeItems, getApplicationContext(), new adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Toast.makeText(getApplicationContext(), "Se seleccionó: " + listaDeItems.get(i).getId_item(), Toast.LENGTH_LONG).show();
            }
        });
        cardViewPersonalizadaDos.setAdapter(adaptadorLista);

        cardViewPersonalizada.setAdapter(adaptadorLista);

    }
}
