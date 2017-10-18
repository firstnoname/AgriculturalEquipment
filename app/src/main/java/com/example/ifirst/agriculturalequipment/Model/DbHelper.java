package com.example.ifirst.agriculturalequipment.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iFirst on 9/14/2017 AD.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String databaseName = "agriculturalEquipment.sqlite";
    private static final int databaseVersion = 1;
    Context mContext;

    private static final String tableG200SQL = "CREATE TABLE tableG200 (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "partName TEXT," +
            "partPrice TEXT" +
            ");";

    private static final String tableGX160SQL = "CREATE TABLE tableGX160 (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "partName TEXT," +
            "partPrice TEXT" +
            ");";



    public DbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tableG200SQL);
        sqLiteDatabase.execSQL(tableGX160SQL);

        String[] insertData = {
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('จานกระตุกชุด (Starter)', '450');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('เขี้ยวสตาร์ท (Starter Claw)', '80');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('เชื้อกดึง (Starter Rope)', '30');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ถังน้ำมัน (Fuel Tank)', '700');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('หม้อกรองอากาศ (Air Filter)', '250');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ลูกสูบ (Piston Set)', '480');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('คาร์บูเรเตอร์ (Carburetor)', '450');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('เสื้อสูบ (Cylinder Set)', '2200');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ก๊อกน้ำมัน (Ball Valve Switch Oil)', '150');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ท่อไอเสีย (Muffler)', '160');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('สวิตช์ปิดเปิด (Switch On-Off)', '120');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('คอยล์ (Coil)', '580');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ฝาถังน้ำมัน  (Fuel Tank Cap)', '50');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ทำสี (New Paint)', '120');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ฝาถังน้ำมันเครื่อง (Oil Tank Cap)', '0');",
                "INSERT INTO tableG200 (partName,partPrice) VALUES ('ปลั๊กหัวเทียน (Spark Plug)', '50');"

        };

        for (int i = 0; i<insertData.length; i++) {
            sqLiteDatabase.execSQL(insertData[i]);
        }

        /*String insertData1 = "INSERT INTO tableG200 (partName,partPrice) VALUES ('part 1', '200');";
        String insertData2 = "INSERT INTO tableG200 (partName,partPrice) VALUES ('part 2', '100');";
        String insertData3 = "INSERT INTO tableG200 (partName,partPrice) VALUES ('', '');";

        sqLiteDatabase.execSQL(insertData1);
        */


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
