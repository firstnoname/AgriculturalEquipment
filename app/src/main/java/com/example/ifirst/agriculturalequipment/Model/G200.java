package com.example.ifirst.agriculturalequipment.Model;

import java.io.Serializable;

/**
 * Created by ifirst on 10/8/17.
 */

public class G200 implements Serializable{
    private String engine,starter,starterClaw,starterRope,fuelTank,airFilter,pistonSet,carburetor,
            cylinderSet,ballValveSwitchOil,muffler,switchOnOff,coil,fuelTankCap,newPaint,oilTankCap,
            sparkPlug;
    private Integer engineID,starterID,starterClawID,starterRopeID,fuelTankID,airFilterID,
            pistonSetID,carburetorID,cylinderSetID,ballValveSwitchOilID,mufflerID,switchOnOffID,
            coilID,fuelTankCapID,newPaintID,oilTankCapID,
            sparkPlugID;
    private Double enginePrice,starterPrice,starterClawPrice,starterRopePrice,fuelTankPrice,airFilterPrice,
            pistonSetPrice,carburetorPrice,cylinderSetPrice,ballValveSwitchOilPrice,mufflerPrice,
            switchOnOffPrice,coilPrice,fuelTankCapPrice,newPaintPrice,oilTankCapPrice,sparkPlugPrice;

    private String selectedGroupName;
    private String selectedText;
    private Integer selectedID;

    public String getSelectedGroupName() {
        return selectedGroupName;
    }

    public void setSelectedGroupName(String selectedGroupName) {
        this.selectedGroupName = selectedGroupName;
    }

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }

    public Integer getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(Integer selectedID) {
        this.selectedID = selectedID;
    }
}
