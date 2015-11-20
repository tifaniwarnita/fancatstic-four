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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tifani
 */
public class DataSet {
    private List<List<String>> dataset = new ArrayList<>(); //TODO: nyimpennya ga dalam bentuk string biar bagus harusnya integer kali ya ga tau deh
    private List<String> attributes = new ArrayList<>();
    private Map<String,List<String>> attributeValues = new HashMap<>();
    private final String DATA_TAG = "@data";
    private final String ATTRIBUTE_TAG = "@attribute";
        
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
        arffReader(filename);
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
    
    public void arffReader(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while (line != null && line.toLowerCase().indexOf(DATA_TAG) == -1) {
		if (!line.isEmpty() && line.charAt(0) != '%') {
                    String[] parts = line.split("\\s", 3); //ngebagi line jadi 3 string
                    if (parts[0].equalsIgnoreCase(ATTRIBUTE_TAG)) { //ngecek depannnya @attribute
			attributes.add(parts[1]); //masukin nama atribut
                        System.out.println(parts[1]);
                        String[] values = parts[2].replaceAll(" |\\{|\\}|'","").split(",");
			List<String> atr = new ArrayList<>();
                        for (String s : values) {
                            s = s.trim(); //buang whitespace
                            atr.add(s);
                            System.out.println(s);
			}
			attributeValues.put(parts[1],atr); //masukin value attribute ke map
                        System.out.println();
                    }
                }
                line = br.readLine();
            }
            
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
