package com.example.ifirst.agriculturalequipment.Estimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ifirst.agriculturalequipment.Model.G200;
import com.example.ifirst.agriculturalequipment.R;
import com.example.ifirst.agriculturalequipment.Submit.SubmitEstimate;

import java.util.ArrayList;

public class EstimateG200 extends AppCompatActivity {

    private RadioGroup rdgEngine,rdgStarter,rdgStarterClaw,rdgStarterRope,rdgFuelTank,rdgAirFilter,
            rdgPistonSet,rdgCarburetor,rdgCylinderSet,rdgBallValveSwitchOil,rdgMuffler,
            rdgSwitchOnOff,rdgCoil,rdgFuelTankCap,rdgNewPaint,rdgOilTankCap, rdgSparkPlug;

    private RadioButton rdbEngine,rdbStarter,rdbStarterClaw,rdbStarterRope,rdbFuelTank,rdbAirFilter,
            rdbPistonSet,rdbCarburetor,rdbCylinderSet,rdbBallValveSwitchOil,rdbMuffler,
            rdbSwitchOnOff,rdbCoil,rdbFuelTankCap,rdbNewPaint,rdbOilTankCap, rdbSparkPlug;

    private RadioButton rdbEngineStart,rdbEngineCantStart;
    private RadioButton starter; //ยังไม่ได้ตั้งชื่อ
    private RadioButton starterClaw; //ยังไม่ได้ตั้งชื่อ RadioButton
    private RadioButton starterRope; //ยังไม่ได้ตั้งชื่อ RadioButton
    private RadioButton rdbChangeFuelTank,rdbNotChangeFuelTank;
    private RadioButton rdbChangeOnlyAirFilter,rdbChangeAirFilter, rdbNotChangeAirFilter;
    private RadioButton rdbChangePistonSet,rdbNotChangePistonSet;
    private RadioButton rdbChangeCarburetor,rdbNotChangeCarburetor;
    private RadioButton rdbChangeCylinderSet,rdbChangeOnlyPiston, rdbNotChangeCylinderSet;
    private RadioButton rdbChangeBallValveSwitchOil,rdbNotChangeBallValveSwitchOil;
    private RadioButton rdbChangeMuffler,rdbNotChangeMuffler;
    private RadioButton rdbChangeSwitchOnOff, rdbNotChangeSwitchOnOff;
    private RadioButton rdbChangeCoil, rdbNotChangeCoil;
    private RadioButton rdbChangeFuelTankCap, rdbNotChangeFuelTankCap;
    private RadioButton rdbChangeNewPaint, rdbNotNewPaint;
    private RadioButton rdbChangeOilTankCap, rdbNotChangeOilTankCap;
    private RadioButton rdbChangeSparkPlug, rdbNotChangeSparkPlug;

    private LinearLayout container_button;
    private Button btnEstimate,btnResetEstimate;

    private ArrayList<String> arrSelectedGroupName = new ArrayList<>();
    private ArrayList<String> arrSelectedText = new ArrayList<>();
    private ArrayList<Integer> arrSelectedID = new ArrayList<>();
    private ArrayList<G200> arrSelected = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_g200);

        bindWidget();


        rdbEngineStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //เครื่องสตาร์ทติด
                for (int i = 0; i<rdgStarterClaw.getChildCount(); i++) {
                    rdgStarterClaw.getChildAt(i).setEnabled(true);
                }
            }
        });

        rdbEngineCantStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //เครื่องสตาร์ทไม่ติด
                for (int i = 0; i<rdgStarterClaw.getChildCount(); i++) {
                    rdgStarterClaw.getChildAt(i).setEnabled(false);
                }
            }
        });

        btnEstimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValueFromRadioButton();
                Intent intentSubmit = new Intent(getApplicationContext(), SubmitEstimate.class);
                intentSubmit.putExtra("id", arrSelectedID);
                intentSubmit.putExtra("text", arrSelectedText);
                intentSubmit.putExtra("objG200", arrSelected);

                ArrayList<G200> mG200;
                mG200 = arrSelected;
                Log.d("mG200 : ", String.valueOf(mG200.size()));
                //Task:: ส่งค่าไปที่ SubmitEstimate ไม่ได้!!!
                //startActivity(intentSubmit);
            }
        });


    }

    private void getValueFromRadioButton() {
        int radioButtonID;

        radioButtonID = rdgEngine.getCheckedRadioButtonId();
        rdbEngine = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgEngine.indexOfChild(rdbEngine));
        arrSelectedText.add(String.valueOf(rdbEngine.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.engine));
        /*G200 objG200 = new G200();
        objG200.setSelectedGroupName(String.valueOf(R.string.engine));
        objG200.setSelectedText(String.valueOf(rdbEngine.getText()));
        objG200.setSelectedID(rdgEngine.indexOfChild(rdbEngine));
        arrSelected.add(objG200);*/

        radioButtonID = rdgStarter.getCheckedRadioButtonId();
        rdbStarter = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgStarter.indexOfChild(rdbStarter));
        arrSelectedText.add(String.valueOf(rdbStarter.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.starter));
/*        objG200.setSelectedGroupName("จานกระตุก");
        objG200.setSelectedText(String.valueOf(rdbStarter.getText()));
        objG200.setSelectedID(rdgStarter.indexOfChild(rdbStarter));
        arrSelected.add(objG200);*/

        radioButtonID = rdgStarterClaw.getCheckedRadioButtonId();
        rdbStarterClaw = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgStarterClaw.indexOfChild(rdbStarterClaw));
        arrSelectedText.add(String.valueOf(rdbStarterClaw.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.starterClaw));

        radioButtonID = rdgStarterRope.getCheckedRadioButtonId();
        rdbStarterRope = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgStarterRope.indexOfChild(rdbStarterRope));
        arrSelectedText.add(String.valueOf(rdbStarterRope.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.starterRope));

        radioButtonID = rdgFuelTank.getCheckedRadioButtonId();
        rdbFuelTank = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgFuelTank.indexOfChild(rdbFuelTank));
        arrSelectedText.add(String.valueOf(rdbFuelTank.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.fuelTank));

        radioButtonID = rdgAirFilter.getCheckedRadioButtonId();
        rdbAirFilter = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgAirFilter.indexOfChild(rdbAirFilter));
        arrSelectedText.add(String.valueOf(rdbAirFilter.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.airFilter));

        radioButtonID = rdgPistonSet.getCheckedRadioButtonId();
        rdbPistonSet = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgPistonSet.indexOfChild(rdbPistonSet));
        arrSelectedText.add(String.valueOf(rdbPistonSet.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.pistonSet));

        radioButtonID = rdgCarburetor.getCheckedRadioButtonId();
        rdbCarburetor = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgCarburetor.indexOfChild(rdbCarburetor));
        arrSelectedText.add(String.valueOf(rdbCarburetor.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.carburetor));

        radioButtonID = rdgCylinderSet.getCheckedRadioButtonId();
        rdbCylinderSet = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgCylinderSet.indexOfChild(rdbCylinderSet));
        arrSelectedText.add(String.valueOf(rdbCylinderSet.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.cylinderSet));

        radioButtonID = rdgBallValveSwitchOil.getCheckedRadioButtonId();
        rdbBallValveSwitchOil = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgBallValveSwitchOil.indexOfChild(rdbBallValveSwitchOil));
        arrSelectedText.add(String.valueOf(rdbBallValveSwitchOil.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.ballValveSwitchOil));

        radioButtonID = rdgMuffler.getCheckedRadioButtonId();
        rdbMuffler = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgMuffler.indexOfChild(rdbMuffler));
        arrSelectedText.add(String.valueOf(rdbMuffler.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.muffler));

        radioButtonID = rdgSwitchOnOff.getCheckedRadioButtonId();
        rdbSwitchOnOff = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgSwitchOnOff.indexOfChild(rdbSwitchOnOff));
        arrSelectedText.add(String.valueOf(rdbSwitchOnOff.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.switchOnOff));

        radioButtonID = rdgCoil.getCheckedRadioButtonId();
        rdbCoil = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgCoil.indexOfChild(rdbCoil));
        arrSelectedText.add(String.valueOf(rdbSwitchOnOff.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.coil));

        radioButtonID = rdgFuelTankCap.getCheckedRadioButtonId();
        rdbFuelTankCap = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgFuelTankCap.indexOfChild(rdbFuelTankCap));
        arrSelectedText.add(String.valueOf(rdbFuelTankCap.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.fuelTankCap));

        radioButtonID = rdgNewPaint.getCheckedRadioButtonId();
        rdbNewPaint = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgNewPaint.indexOfChild(rdbNewPaint));
        arrSelectedText.add(String.valueOf(rdbNewPaint.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.newPaint));

        radioButtonID = rdgOilTankCap.getCheckedRadioButtonId();
        rdbOilTankCap = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgOilTankCap.indexOfChild(rdbOilTankCap));
        arrSelectedText.add(String.valueOf(rdbOilTankCap.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.oilTankCap));

        radioButtonID = rdgSparkPlug.getCheckedRadioButtonId();
        rdbSparkPlug = (RadioButton) findViewById(radioButtonID);
        arrSelectedID.add(rdgSparkPlug.indexOfChild(rdbSparkPlug));
        arrSelectedText.add(String.valueOf(rdbSparkPlug.getText()));
        arrSelectedGroupName.add(String.valueOf(R.string.sparkPlug));

        for (int i = 0; i<arrSelectedID.size(); i++) {
            G200 objG200 = new G200();
            objG200.setSelectedID(arrSelectedID.get(i));
            objG200.setSelectedText(arrSelectedText.get(i));
            objG200.setSelectedGroupName(arrSelectedGroupName.get(i));
            arrSelected.add(objG200);
            /*Log.d("Index of child : ", String.valueOf(arrSelectedID.get(i)));
            Log.d("String of child : ", arrSelectedText.get(i));*/
        }


        /*for (int i = 0; i<arrSelected.size(); i++) {
            G200 mG200 = arrSelected.get(i);
            Log.d("objG200 : ", mG200.getSelectedGroupName());
            Log.d("objG200 : ", mG200.getSelectedText());
            Log.d("objG200 : ", mG200.getSelectedID().toString());
        }*/

    }

    private void bindWidget() {
        rdgEngine = (RadioGroup) findViewById(R.id.rdgEngine);
        rdgStarter = (RadioGroup) findViewById(R.id.rdgStarter);
        rdgStarterClaw = (RadioGroup) findViewById(R.id.rdgStarterClaw);
        rdgStarterRope = (RadioGroup) findViewById(R.id.rdgStarterRope);
        rdgFuelTank = (RadioGroup) findViewById(R.id.rdgFuelTank);
        rdgAirFilter = (RadioGroup) findViewById(R.id.rdgAirFilter);
        rdgPistonSet = (RadioGroup) findViewById(R.id.rdgPistonSet);
        rdgCarburetor = (RadioGroup) findViewById(R.id.rdgCarburetor);
        rdgCylinderSet = (RadioGroup)findViewById(R.id.rdgCylinderSet);
        rdgBallValveSwitchOil = (RadioGroup)findViewById(R.id.rdgBallValveSwitchOil);
        rdgMuffler = (RadioGroup)findViewById(R.id.rdgMuffler);
        rdgSwitchOnOff = (RadioGroup)findViewById(R.id.rdgSwitchOnOff);
        rdgCoil = (RadioGroup)findViewById(R.id.rdgCoil);
        rdgFuelTankCap = (RadioGroup) findViewById(R.id.rdgFuelTankCap);
        rdgNewPaint = (RadioGroup) findViewById(R.id.rdgNewPaint);
        rdgOilTankCap = (RadioGroup) findViewById(R.id.rdgOilTankCap);
        rdgSparkPlug = (RadioGroup) findViewById(R.id.rdgSparkPlug);


        rdbEngineStart = (RadioButton) findViewById(R.id.rdbEngineStart);
        rdbEngineCantStart = (RadioButton) findViewById(R.id.rdbEngineCantStart);
//        starter ยังไม่ได้ตั้งชื่อ.
//        starterClaw ยังไม่ได้ตั้งชื่อ.
//        starterRope ยังไม่ได้ตั้งชื่อ.
        rdbChangeFuelTank = (RadioButton) findViewById(R.id.rdbChangeFuelTank);
        rdbNotChangeFuelTank = (RadioButton) findViewById(R.id.rdbNotChangeFuelTank);
        rdbChangeOnlyAirFilter = (RadioButton) findViewById(R.id.rdbChangeOnlyAirFilter);
        rdbChangeAirFilter = (RadioButton) findViewById(R.id.rdbChangeAirFilter);
        rdbNotChangeAirFilter = (RadioButton) findViewById(R.id.rdbNotChangeAirFilter);
        rdbChangePistonSet = (RadioButton) findViewById(R.id.rdbChangePistonSet);
        rdbNotChangePistonSet = (RadioButton) findViewById(R.id.rdbNotChangePistonSet);
        rdbChangeCarburetor = (RadioButton) findViewById(R.id.rdbChangeCarburetor);
        rdbNotChangeCarburetor = (RadioButton) findViewById(R.id.rdbNotChangeCarburetor);
        rdbChangeCylinderSet = (RadioButton) findViewById(R.id.rdbChangeCylinderSet);
        rdbChangeOnlyPiston = (RadioButton) findViewById(R.id.rdbChangeOnlyPiston);
        rdbNotChangeCylinderSet = (RadioButton) findViewById(R.id.rdbNotChangeCylinderSet);
        rdbChangeBallValveSwitchOil = (RadioButton) findViewById(R.id.rdbChangeBallValveSwitchOil);
        rdbNotChangeBallValveSwitchOil = (RadioButton) findViewById(R.id.rdbNotChangeBallValveSwitchOil);
        rdbChangeMuffler = (RadioButton) findViewById(R.id.rdbChangeMuffler);
        rdbNotChangeMuffler = (RadioButton) findViewById(R.id.rdbNotChangeMuffler);
        rdbChangeSwitchOnOff = (RadioButton) findViewById(R.id.rdbChangeSwitchOnOff);
        rdbNotChangeSwitchOnOff = (RadioButton) findViewById(R.id.rdbNotChangeSwitchOnOff);
        rdbChangeCoil = (RadioButton) findViewById(R.id.rdbChangeCoil);
        rdbNotChangeCoil = (RadioButton) findViewById(R.id.rdbNotChangeCoil);
        rdbChangeFuelTankCap = (RadioButton) findViewById(R.id.rdbChangeFuelTankCap);
        rdbNotChangeFuelTankCap = (RadioButton) findViewById(R.id.rdbNotChangeFuelTankCap);
        rdbChangeNewPaint = (RadioButton) findViewById(R.id.rdbChangeNewPaint);
        rdbNotNewPaint = (RadioButton) findViewById(R.id.rdbNotNewPaint);
        rdbChangeOilTankCap = (RadioButton) findViewById(R.id.rdbChangeOilTankCap);
        rdbNotChangeOilTankCap = (RadioButton) findViewById(R.id.rdbNotChangeOilTankCap);
        rdbChangeSparkPlug = (RadioButton) findViewById(R.id.rdbChangeSparkPlug);
        rdbNotChangeSparkPlug = (RadioButton) findViewById(R.id.rdbNotChangeSparkPlug);

        container_button = (LinearLayout) findViewById(R.id.container_button);
        btnEstimate = (Button) findViewById(R.id.btnEstimate);
        btnResetEstimate = (Button) findViewById(R.id.btnResetEstimate);
    }

}
