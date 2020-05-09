package com.chacachx.cardviewpersonalizadorecyclerview.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LISTADO(ID_ITEM TEXT PRIMARY KEY, TITULO TEXT, DESCRIPCION TEXT, IMAGEN TEXT)");
        db.execSQL("INSERT INTO LISTADO (ID_ITEM, TITULO, DESCRIPCION, IMAGEN) VALUES ('ITEM-1', 'Título item 1', 'Descripción item 1', 'https://image.freepik.com/vector-gratis/paisaje-minimalista-desierto_23-2148269225.jpg')");
        db.execSQL("INSERT INTO LISTADO (ID_ITEM, TITULO, DESCRIPCION, IMAGEN) VALUES ('ITEM-2', 'Título item 2', 'Descripción item 2', 'https://i.pinimg.com/originals/72/dc/33/72dc339da93a143ec1ed0d54143ecfea.jpg')");
        db.execSQL("INSERT INTO LISTADO (ID_ITEM, TITULO, DESCRIPCION, IMAGEN) VALUES ('ITEM-3', 'Título item 3', 'Descripción item 3', 'https://i0.wp.com/www.andro-life.com/wp-content/uploads/2017/08/Wallpaper-5.png?fit=1600%2C900&ssl=1')");
        db.execSQL("INSERT INTO LISTADO (ID_ITEM, TITULO, DESCRIPCION, IMAGEN) VALUES ('ITEM-4', 'Título item 4', 'Descripción item 4', 'https://i2.wp.com/www.andro-life.com/wp-content/uploads/2017/08/Wallpaper-3.jpg?resize=1024%2C576&ssl=1')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}