package com.PMS.sensor;

public class BloodPressureSensor extends Sensor {

    public BloodPressureSensor (String deviceName, String patientName, String patientPeriod, String lowerBound, String upperBound, String datasetName) {
        super(deviceName, patientName, patientPeriod, lowerBound, upperBound, datasetName);
    }

}
