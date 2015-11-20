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
import java.util.Scanner;

/**
 *
 * @author Tifani
 */
public class FancatsticFour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        DataSet data = new DataSet("weather.nominal.arff");
        System.out.print("Press 1 for kNN and 2 for Naive Bayes: ");
        
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("");
        
        switch (num) { //kNN
            case 1: {
                System.out.println("==================");
                System.out.println("k-Nearest Neighbor");
                System.out.println("==================");
                /* List<String> identify = new ArrayList<>();
                identify.add("sunny");
                identify.add("hot");
                identify.add("high");
                identify.add("FALSE");
                kNN knn = new kNN(data,identify,3);
                knn.printQueue();
                System.out.println(knn.solve());
                //knn.printQueue();
                //System.out.println(knn.solve());
                */
                kNNSolver fulltraining = new kNNSolver(data,1,2);
                System.out.println("Accuracy kNN full-training : " + fulltraining.countAccuracy()*100 + "%");
                break;
            }
            case 2: { // Naive Bayes
                System.out.println("===========");
                System.out.println("Naive Bayes");
                System.out.println("===========");
                List<String> classValues = data.getClassValues();
                List<String> attributes = data.getAttributes();
                Map<String,List<String>> attributeValues = data.getAttributeValues();

                NaiveBayes nb = new NaiveBayes(data.getDataset(),attributes,attributeValues,classValues);
                nb.fullTraining();
                break;
            }
        }
    }
    
}
