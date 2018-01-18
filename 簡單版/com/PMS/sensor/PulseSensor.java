package com.PMS.sensor;

public class PulseSensor extends Sensor {
    
    public PulseSensor (String deviceName, String patientName, String patientPeriod, String lowerBound, String upperBound, String datasetName) {
        super(deviceName, patientName, patientPeriod, lowerBound, upperBound, datasetName);
    }

}
