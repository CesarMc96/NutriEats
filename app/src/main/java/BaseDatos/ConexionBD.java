package BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class ConexionBD extends SQLiteOpenHelper {

    private static final String BD_NAME = "eats.sqlite";

    public ConexionBD(Context context) {
        super(context, BD_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table usuarios(id integer primary key autoincrement,nombre text,apellidos text,telefono text, email text,contrasena text)");
        db.execSQL("Create table tarjetas(id integer primary key autoincrement, tarjeta text, fecha text, codigo text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Create table usuarios(id integer primary key autoincrement,nombre text,apellidos text,telefono text, email text,contrasena text)");
        db.execSQL("Create table tarjetas(id integer primary key autoincrement, tarjeta text, fecha text, codigo text)");
    }

}
