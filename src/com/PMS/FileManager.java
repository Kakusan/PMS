package com.PMS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    List<String[]> dataLines = new ArrayList<String[]>();

    public void readFile(String fileIndex) {
        try {
            //URL fileIndex = Thread.currentThread().getContextClassLoader().getResource("SampleInput.txt");
            //System.out.println(fileIndex);
            FileReader fr = new FileReader (fileIndex);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(" ");
                dataLines.add(strings);
//                for (int i = 0; i < strings.length; i++) {
//                    System.out.println(strings[i]);
//                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", "SampleInput");
            e.printStackTrace();
        }
    }

    public List<String[]> getDataLines() {
        return dataLines;
    }


}
