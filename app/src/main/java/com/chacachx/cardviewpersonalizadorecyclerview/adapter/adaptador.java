package com.chacachx.cardviewpersonalizadorecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chacachx.cardviewpersonalizadorecyclerview.R;
import com.chacachx.cardviewpersonalizadorecyclerview.dto.listaItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolderLista> {
    //LISTADO
    private ArrayList<listaItems> listaDeItems;
    private Context context;
    //ENCARGADO DE ESCUCHAR A QUE ITEM SE LE HACE "CLIC"
    private OnItemClickListener listener;

    public adaptador(ArrayList<listaItems> listaDeItems, Context context, OnItemClickListener listener) {
        this.listaDeItems = listaDeItems;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @NonNull
    @Override
    public ViewHolderLista onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //ASIGNAMOS LA VISTA QUE TENDRAN LOS ITEMS DEL RECYCLERVIEW
        return new ViewHolderLista(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLista viewHolderLista, int i) {
        //ENVIAMOS EL REGISTRO EN LA POSICION i (DEL ARRAYLIST) PARA SER AÑADIDO AL RECYCLERVIEW
        viewHolderLista.bind(this.listaDeItems.get(i), i, this.listener);
    }

    @Override
    public int getItemCount() {
        //RETORNA LA CANTIDAD DE ITEMS
        return listaDeItems.size();
    }

    public class ViewHolderLista extends RecyclerView.ViewHolder {
        TextView titulo, descripcion;
        ImageView imagen;
        FloatingActionButton bookmark;

        public ViewHolderLista(View inflate) {

            super(inflate);
            titulo = inflate.findViewById(R.id.titulo);
            descripcion = inflate.findViewById(R.id.descripcion);
            imagen = inflate.findViewById(R.id.imagen);
            bookmark = inflate.findViewById(R.id.bookmark);
        }

        public void bind(final listaItems listaDeItems, final int position, final OnItemClickListener listener) {
            //LLENAMOS CADA ITEM DEL RECYCLERVIEW CON EL CONTENIDO DE LA BASE DE DATOS
            titulo.setText(listaDeItems.getTitulo().toUpperCase());
            descripcion.setText(listaDeItems.getDescripcion() + "\nURL de la imagen: " + listaDeItems.getImagen());
            //USAMOS GLIDE PARA CARGAR LAS IMAGENES DESDE LA URL
            //https://github.com/bumptech/glide
            //AÑADIR LOS PERMISOS DE INTERNET PARA QUE CARGUEN LAS FOTOS
            Glide.with(context).load(listaDeItems.getImagen()).centerInside()
                    .into(imagen);
            bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Se guardó el item: " + listaDeItems.getId_item(), Toast.LENGTH_LONG).show();
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(position);
                }
            });
        }
    }
}

