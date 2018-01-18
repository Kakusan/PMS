package com.PMS.sensor;

public class TemperatureSensor extends Sensor  {
    public TemperatureSensor (String deviceName, String patientName, String patientPeriod, String lowerBound, String upperBound, String datasetName) {
        super(deviceName, patientName, patientPeriod, lowerBound, upperBound, datasetName);
    }

}
