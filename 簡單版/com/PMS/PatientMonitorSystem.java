package com.PMS;

import com.PMS.sensor.*;
import java.util.ArrayList;
import java.util.List;

public class PatientMonitorSystem {
    List<String[]> dataLines = new ArrayList<String[]>();
    List<Sensor> sensors = new ArrayList<Sensor>();

    public void work (String inputDataName) throws Exception {
		
        FileManager fileManager = new FileManager();
		String dir = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));
        fileManager.readFile(dir.substring(6) + inputDataName + ".txt");
        dataLines = fileManager.getDataLines();

        for (int i = 0; i < dataLines.get(0)[0].length(); i++) {    
            if (!Character.isDigit(dataLines.get(0)[0].charAt(i)))
                throw new Exception("monitor period error.");
        }  

        for (int i = 1; i < dataLines.size(); i++) {
            if (dataLines.get(i)[0].equals("patient")) {

                if (dataLines.get(i).length != 3)
                    throw new Exception("patient data format error.");
                if (dataLines.get(i+1).length != 5)
                    throw new Exception("sensor data format error.");

                String[] patientData = dataLines.get(i);
                String[] sensorData = dataLines.get(i+1);
                if (sensorData[0].equals("BloodPressureSensor"))
                    sensors.add(new BloodPressureSensor(sensorData[1], patientData[1], patientData[2], sensorData[3], sensorData[4], sensorData[2]));
                else if (sensorData[0].equals("PulseSensor"))
                    sensors.add(new PulseSensor(sensorData[1], patientData[1], patientData[2], sensorData[3], sensorData[4], sensorData[2]));
                else if (sensorData[0].equals("TemperatureSensor"))
                    sensors.add(new TemperatureSensor(sensorData[1], patientData[1], patientData[2], sensorData[3], sensorData[4], sensorData[2]));
                else 
                    throw new Exception("sensor data format error.");
            }
        }

        int monitorPeriod = Integer.valueOf(dataLines.get(0)[0]);
        for (int i = 0; i <= monitorPeriod; i++) {
            for (Sensor sensor : sensors)
                sensor.Work(i);
        }

        for (Sensor sensor : sensors)
            sensor.Report(monitorPeriod);
    }


}
