package com.chacachx.cardviewpersonalizadorecyclerview.query;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chacachx.cardviewpersonalizadorecyclerview.database.database;
import com.chacachx.cardviewpersonalizadorecyclerview.dto.listaItems;

import java.util.ArrayList;

public class query {

    public ArrayList<listaItems> listaItemsDB(Context context) {
        ArrayList<listaItems> listaDeItems;
        String consulta = "SELECT * FROM LISTADO";
        listaDeItems = llenadoGenerico(context, consulta);
        return listaDeItems;

    }

    public ArrayList<listaItems> llenadoGenerico(Context context, String consulta) {
        listaItems item;
        ArrayList<listaItems> listaDeItems = new ArrayList<>();
        database baseDeDatos = new database(context, null, null, 1);
        SQLiteDatabase db = baseDeDatos.getReadableDatabase();
        Cursor fila = db.rawQuery(consulta, null);
        while (fila.moveToNext()) {
            item = new listaItems(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3));
            listaDeItems.add(item);
        }
        db.close();
        return listaDeItems;
    }
}
