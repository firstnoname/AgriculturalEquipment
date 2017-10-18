package com.example.ifirst.agriculturalequipment.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ifirst.agriculturalequipment.Model.SparePart;
import com.example.ifirst.agriculturalequipment.R;

import java.util.ArrayList;

/**
 * Created by ifirst on 10/2/17.
 */

public class TestAdapter extends BaseAdapter {

    //Attribute.
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<SparePart> mySparePart;

    public TestAdapter(Activity activity, ArrayList<SparePart> mySparePart) {
        this.mySparePart = mySparePart;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mySparePart.size();
    }

    @Override
    public SparePart getItem(int i) {
        return mySparePart.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mySparePart.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        v = inflater.inflate(R.layout.test_listview, null);
        TextView txtId = (TextView) v.findViewById(R.id.txtId);
        TextView txtName = (TextView) v.findViewById(R.id.txtName);
        TextView txtPrice = (TextView) v.findViewById(R.id.txtPrice);
        SparePart sparePart = mySparePart.get(i);
        txtId.setText(String.valueOf(sparePart.getId()));
        txtName.setText(sparePart.getPartName());
        txtPrice.setText(sparePart.getPartPrice());

        return v;
    }
}
