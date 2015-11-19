/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fancatstic.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tifani
 */
public class FancatsticFour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        DataSet data = new DataSet("weather.txt");
        
        /*List<String> identify = new ArrayList<>();
        identify.add("vhigh");
        identify.add("vhigh");
        identify.add("2");
        identify.add("2");
        identify.add("small");
        identify.add("low");
        kNN knn = new kNN(data,identify,1728);
        knn.printQueue();
        System.out.println(knn.solve()); */
        
        List<String> classValues = new ArrayList<>();
        classValues.add("yes");
        classValues.add("no");
        
        List<String> attributes = new ArrayList<>(Arrays.asList("outlook","temperature","humidity","windy"));
        Map<String,List<String>> attributeValues = new HashMap<>();
        attributeValues.put("outlook", new ArrayList<>(Arrays.asList("sunny","overcast","rainy")));
        attributeValues.put("temperature", new ArrayList<>(Arrays.asList("hot","mild","cool")));
        attributeValues.put("humidity", new ArrayList<>(Arrays.asList("high","normal")));
        attributeValues.put("windy", new ArrayList<>(Arrays.asList("TRUE","FALSE")));
        NaiveBayes nb = new NaiveBayes(data.getDataset(),attributes,attributeValues,classValues);
        nb.fullTraining();
    }
    
}
