package com.PMS;

import com.PMS.sensor.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        List<String[]> dataLines = fileManager.getDataLines();
        List<Sensor> sensors = new ArrayList<Sensor>();
        fileManager.readFile("D:/SampleInput.txt");

        for (int i = 1; i < dataLines.size(); i++) {
            if (dataLines.get(i)[0].equals("BloodPressureSensor"))
                sensors.add(new BloodPressureSensor(dataLines.get(i)[1], dataLines.get(i - 1)[1], dataLines.get(i - 1)[2], dataLines.get(i)[3], dataLines.get(i)[4], dataLines.get(i)[2]));
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
