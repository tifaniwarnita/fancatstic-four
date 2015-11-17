/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fancatstic.four;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tifani
 */
public class DataSet {
    private List<List<String>> dataset = new ArrayList<>(); //TODO: nyimpennya ga dalam bentuk string biar bagus harusnya integer kali ya ga tau deh
    /* private List<List<Info>> attributeInfo;
    
    public class Info {
        private int attribute;
        private String value;
        
        public Info() {
            
        }
    }*/
    
    public DataSet() {
        
    }
    
    public DataSet(String filename) {
        readFile(filename);
        //printDataSet();
    }
    
    public void readFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();

            while (line != null) {
                String[] list = line.split("\\,");
                List<String> instance = new ArrayList<>();
                for (int i=0; i<list.length; i++) {
                    instance.add(list[i]);
                }
                dataset.add(instance);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void printDataSet() {
        for(int i=0; i<dataset.size(); i++) {
            for(int j=0; j<dataset.get(i).size(); j++) {
                System.out.print(dataset.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
    
    public List<List<String>> getDataset() {
        return dataset;
    }
}
