/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fancatstic.four;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.io.FileReader;

/**
 *
 * @author Venny
 */
public class NaiveBayesClassifier {
    private final static Map<String,Map<String,Map<String,Integer>>> model = new HashMap<>();
    private final static List<String> attributes = new ArrayList<>();
    private final static Map<String,List<String>> attributeValues = new HashMap<>();
    private final static List<String> classValues = new ArrayList<>();
    
    public final static void buildModelFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String attribute = br.readLine();
            while (!attribute.equals("Class")) {
                attributes.add(attribute);
                attributeValues.put(attribute,new ArrayList<>());
                model.put(attribute, new HashMap<>());
                String line = br.readLine();
                while (!line.isEmpty()) {
                    String[] values = line.split(" - ");
                    String atrName = values[0];
                    attributeValues.get(attribute).add(atrName);
                    model.get(attribute).put(atrName, new HashMap<>());
                    for (int i=1;i<values.length;i++) {
                       String[] classCount = values[i].split(": ");
                       String className = classCount[0];
                       int count = Integer.parseInt(classCount[1]);
                       model.get(attribute).get(atrName).put(className, count);
                    }
                    line = br.readLine();
                }
                attribute = br.readLine();
            }
            String line = br.readLine();
            model.put("Class",new HashMap<>());
            model.get("Class").put("Total",new HashMap<>());
            while (line!=null) {
                String[] classCount = line.split(" - ");
                String className = classCount[0];
                if (!className.equals("total")) classValues.add(className);
                int count = Integer.parseInt(classCount[1]);
                model.get("Class").get("Total").put(className, count);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static String classify(List<String> newdata) {
            double maxp = 0;
            double p;
            int totalCount = model.get("Class").get("Total").get("total");
            String classification = "";
            for (String classValue : classValues) { 
                int classCount = model.get("Class").get("Total").get(classValue);
                p=(double)classCount/totalCount;                
                for (int i=0;i<newdata.size();i++) {
                    String atrName = attributes.get(i);
                    String atrValue = newdata.get(i);       
                    double atrp = (double)model.get(atrName).get(atrValue).get(classValue)/(double)classCount;
                    p *= atrp;
                }
                if (p>=maxp) {
                    maxp = p;
                    classification = classValue;
                }
            }
            return classification;
    }
    
    public static Map<String,Map<String,Map<String,Integer>>> getModel() {
        return model;
    }
}
