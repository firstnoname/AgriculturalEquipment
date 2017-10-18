package com.example.ifirst.agriculturalequipment.EstimateMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ifirst.agriculturalequipment.Estimation.EstimateG200;
import com.example.ifirst.agriculturalequipment.R;

public class EstimateMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_menu);
    }

    public void intentEstG200(View view){
        Intent intentEstG200 = new Intent(this, EstimateG200.class);
        startActivity(intentEstG200);
    }
}
