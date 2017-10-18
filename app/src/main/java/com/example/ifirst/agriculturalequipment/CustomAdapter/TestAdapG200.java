package com.example.ifirst.agriculturalequipment.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ifirst.agriculturalequipment.Model.G200;
import com.example.ifirst.agriculturalequipment.R;

import java.util.ArrayList;

/**
 * Created by ifirst on 10/12/17.
 */

public class TestAdapG200 extends BaseAdapter {

    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<G200> mG200;

    public TestAdapG200(Activity activity, ArrayList<G200> mG200) {
        this.mG200 = mG200;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mG200.size();
    }

    @Override
    public G200 getItem(int i) {
        return mG200.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mG200.get(i).getSelectedID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        v = inflater.inflate(R.layout.test_listview, null);
        TextView txtId = (TextView) v.findViewById(R.id.txtId);
        TextView txtName = (TextView) v.findViewById(R.id.txtName);
        TextView txtPrice = (TextView) v.findViewById(R.id.txtPrice);
        G200 g200 = mG200.get(i);
        txtId.setText(g200.getSelectedID());
        txtName.setText(g200.getSelectedGroupName());
        txtPrice.setText(g200.getSelectedText());

        return v;
    }
}
