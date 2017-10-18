package com.example.ifirst.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.ifirst.agriculturalequipment.CustomAdapter.TestAdapter;
import com.example.ifirst.agriculturalequipment.EstimateMenu.EstimateMenu;
import com.example.ifirst.agriculturalequipment.Model.SparePart;
import com.example.ifirst.agriculturalequipment.Model.SparePartDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SparePartDAO sparePartDAO = new SparePartDAO(getApplicationContext());
        sparePartDAO.open();
//        ArrayList<SparePart> spareParts = sparePartDAO.getAllSparePart();
        ArrayList<SparePart> spareParts = sparePartDAO.getAllSparePartWithCondition("tableG200");
        sparePartDAO.close();

        myListview = (ListView) findViewById(R.id.test_listview);

        //Test adapter are working.
        TestAdapter adapter = new TestAdapter(this, spareParts);

        myListview.setAdapter(adapter);
    }

    public void intentToEstG200(View view){
        Intent intentToEstG200 = new Intent(this, EstimateMenu.class);
        startActivity(intentToEstG200);
    }
}
