package com.PMS.sensor;

import com.PMS.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private String deviceName, patientName;
    private int patientPeriod;
    private int lowerBound, upperBound;
    private List<Double> patientData = new ArrayList<Double>();

    public Sensor (String deviceName, String patientName, String patientPeriod, String lowerBound, String upperBound, String datasetName) {
        this.deviceName = deviceName;
        this.patientName = patientName;
        this.patientPeriod = Integer.valueOf(patientPeriod);
        this.lowerBound = Integer.valueOf(lowerBound);
        this.upperBound = Integer.valueOf(upperBound);

        FileManager fileManager = new FileManager();
        fileManager.readFile("D:/" + datasetName);
        for (String[] data: fileManager.getDataLines())
            patientData.add(Double.valueOf(data[0]));
    }


    public void Work (int currentPeriod) {
        if (currentPeriod % patientPeriod == 0) {
            int order = currentPeriod / patientPeriod;
            if (order >= patientData.size() || patientData.get(order) == -1)
                System.out.println("[" + patientPeriod * order + "] " + deviceName + " falls");
            else if (patientData.get(order) < lowerBound || patientData.get(order) > upperBound)
                System.out.println("[" + patientPeriod * order + "] " + patientName + " is in danger! Cause: " + deviceName + " " + patientData.get(order));
        }
    }

    public void Report (int monitorPeriod) {
        System.out.println("patient " + patientName);
        System.out.println(this.getClass().getSimpleName() + " " + deviceName);
        for (int i = 0; i <= monitorPeriod / patientPeriod; i++)
            if (i >= patientData.size())
                System.out.println("[" + patientPeriod * i + "] -1.0" );
            else
                System.out.println("[" + patientPeriod * i + "] " + patientData.get(i));
    }

}

