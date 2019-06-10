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
        db.execSQL("insert into usuarios values('a','a','12','c@hot.com','123')");
        db.execSQL("Create table comidas(id integer primary key autoincrement,nombre text,precio int,tipo text)");
        db.execSQL("insert into comidas values('spaguetti pesto','35','comida')");
        db.execSQL("insert into comidas values('pollo con arroz','25','comida')");
        db.execSQL("insert into comidas values('ensalada primavera','45','desayuno')");
        db.execSQL("insert into comidas values('buebito con arroz','35','desayuno')");
        db.execSQL("insert into comidas values('ensalada nocturna','25','cena')");
        db.execSQL("insert into comidas values('emparedados de pollo','45','cena')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Create table usuarios(id integer primary key autoincrement,nombre text,apellidos text,telefono text, email text,contrasena text)");
    }

}
