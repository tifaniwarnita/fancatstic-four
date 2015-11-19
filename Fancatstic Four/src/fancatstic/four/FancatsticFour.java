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
>>>>>>> a592f84be37b5d5b825395b9ad3a379e8d159b96
  
/*=======
        identify.add("low");
        identify.add("sunny");
        identify.add("hot");
        identify.add("high");
        identify.add("FALSE");
        //kNN knn = new kNN(data,identify,4);
        NaiveBayes nb = new NaiveBayes(data.getDataset());
        System.out.println(nb.classify(identify));
>>>>>>> origin/master
=======
        kNN knn = new kNN(data,identify,1728);
        knn.printQueue();
        System.out.println(knn.solve());
        
<<<<<<< HEAD
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
=======
        NaiveBayes nb = new NaiveBayes(data.getDataset());
        List<String> hasil = nb.testSet(data.getDataset());
        for (int i =0; i<hasil.size(); i++){
            System.out.println(hasil.get(i));
        }
        System.out.println(nb.accuracy(data.getDataset(), hasil));
>>>>>>> a592f84be37b5d5b825395b9ad3a379e8d159b96*/
        
        kNNSolver fulltraining = new kNNSolver(data,7);
        System.out.println("Accuracy kNN full-training : " + fulltraining.countAccuracy()*100 + "%");
>>>>>>> origin/master
    }
    
}
