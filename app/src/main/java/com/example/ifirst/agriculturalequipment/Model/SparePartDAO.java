package com.example.ifirst.agriculturalequipment.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by iFirst on 9/14/2017 AD.
 */

public class SparePartDAO {

    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public SparePartDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public ArrayList<SparePart> getAllSparePart(){
        ArrayList<SparePart> spareParts = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM tableG200;", null);
        cursor.moveToFirst();
        SparePart sparePart;

        while (!cursor.isAfterLast()) {
            sparePart = new SparePart();
            sparePart.setId(cursor.getInt(0));
            sparePart.setPartName(cursor.getString(1));
            sparePart.setPartPrice(cursor.getString(2));
            spareParts.add(sparePart);
            //Log.d("Print id : ", String.valueOf(cursor.getInt(0)));
            cursor.moveToNext();
        }
        cursor.close();

        return spareParts;
    }

    public ArrayList<SparePart> getAllSparePartWithCondition(String tblName){
        ArrayList<SparePart> spareParts = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + tblName + ";", null);
        cursor.moveToNext();    
        SparePart sparePart;

        while (!cursor.isAfterLast()) {
            sparePart = new SparePart();
            sparePart.setId(cursor.getInt(0));
            sparePart.setPartName(cursor.getString(1));
            sparePart.setPartPrice(cursor.getString(2));
            spareParts.add(sparePart);
            cursor.moveToNext();
        }
        cursor.close();

        return spareParts;
    }
}
