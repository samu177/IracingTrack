package com.example.samu_pc.iracingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samu-PC on 22/09/2016.
 */

public class AppDB extends SQLiteOpenHelper{
    //version de la DB
    private static final int DB_VERSION = 1;

    //Nombre del archivo de la DB
    private static final String DB_NAME="series.db";

    //Sentencia SQL para la creación de la tabla series
    private static final String SERIES_TABLE = "CREATE TABLE series" +
            "(_id INT PRIMARY KEY, name TEXT NOT NULL, track TEXT NOT NULL, car TEXT NOT NULL, schedule TEXT NOT NULL, notes TEXT)";

    //constructor
    public AppDB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    //creamos tabla si no existe
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SERIES_TABLE);
    }

    //borramos tabla si existe y creamos una nueva
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SERIES_TABLE);
        onCreate(db);
    }

    //GESTION DE LA BASE DE DATOS

    //insertar series
    public void insertSeries(int id, String name, String track, String car, String schedule, String notes){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            ContentValues values = new ContentValues();
            values.put("_id", id);
            values.put("name", name);
            values.put("track", track);
            values.put("car", car);
            values.put("schedule", schedule);
            values.put("notes", notes);
            db.insert("series", null, values);
            db.close();
        }
    }


    //modificar series
    public void modSeries(int id, String name, String track, String car, String schedule, String notes){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("name", name);
        values.put("track", track);
        values.put("car", car);
        values.put("schedule", schedule);
        values.put("notes", notes);
        db.update("series", values, "_id=" + id, null);
        db.close();
    }


    //borrar series
    public void deleteSeries(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("series", "_id="+id, null);
        db.close();
    }

    //lectura de datos

    //leer un registro
    public Series getSeries(int id){
        SQLiteDatabase db = getReadableDatabase();
        String[] getValues = {"_id", "name", "track", "car", "schedule", "notes"};
        Cursor c = db.query("series", getValues, "_id=" + id, null, null, null, null, null);//devuelve un cursor con el que podemos recorrer la base de datos
        if(c != null){//por si no hay datos almacenados
            c.moveToFirst(); //se mueve al primer dato
        }
        Series series = new Series(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
        db.close();
        c.close();
        return series;
    }

    //leer todos los registros
    public List<Series> getAllSeries() {
        SQLiteDatabase db = getReadableDatabase();
        List<Series> seriesList = new ArrayList<Series>();
        String[] recoverValues = {"_id", "name", "track", "car", "schedule", "notes"};
        Cursor c = db.query("series", recoverValues, null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Series series = new Series(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
            seriesList.add(series);
        } while (c.moveToNext());
        db.close();
        c.close();
        return seriesList;
    }

}

