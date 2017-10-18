package com.example.ifirst.agriculturalequipment.Submit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.ifirst.agriculturalequipment.CustomAdapter.TestAdapG200;
import com.example.ifirst.agriculturalequipment.Model.G200;
import com.example.ifirst.agriculturalequipment.R;

import java.util.ArrayList;

public class SubmitEstimate extends AppCompatActivity {

    private ArrayList<String> arrSelectedText = new ArrayList<>();
    private ArrayList<Integer> arrSelectedID = new ArrayList<>();
    private ArrayList<G200> arrG200Lists = new ArrayList<>();
    ListView g200Listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate);

        Intent getIntent = getIntent();
        arrSelectedID = getIntent.getIntegerArrayListExtra("id");
        arrSelectedText = getIntent.getStringArrayListExtra("text");
        arrG200Lists = (ArrayList<G200>) getIntent.getSerializableExtra("arrSelected");

        Log.d("arrG200Lists size : ", String.valueOf(arrG200Lists.size()));

        /*TestAdapG200 adapter = new TestAdapG200(this, arrG200Lists);
        g200Listview = (ListView) findViewById(R.id.g200Listview);
        g200Listview.setAdapter(adapter);*/
        /*for (int i = 0; i<arrG200Lists.size(); i ++) {
            G200 mG200 = new G200();
            mG200 = arrG200Lists.get(i);
            Log.d("mG200 : ", mG200.getSelectedGroupName());
        }*/
        /*for (int i = 0; i<arrSelectedID.size(); i++) {
            Log.d("Index of child : ", String.valueOf(arrSelectedID.get(i)));
            Log.d("String of child : ", arrSelectedText.get(i));
        }*/
    }
}
