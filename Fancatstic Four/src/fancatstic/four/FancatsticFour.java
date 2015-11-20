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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        System.out.print("Input file: ");
        String filename = scanner.nextLine();
        DataSet data = new DataSet(filename);
        System.out.print("Press 1 for kNN and 2 for Naive Bayes: ");
        
        
        int num = scanner.nextInt();
        System.out.println("");
        
        switch (num) { //kNN
            case 1: {                
                System.out.println("==================");
                System.out.println("k-Nearest Neighbor");
                System.out.println("==================");                
                System.out.print("k = ");
                int k = scanner.nextInt();
                System.out.println("Press:");
                System.out.println("1. Full Training");
                System.out.println("2. 10-fold Cross Validation");
                System.out.println("3. 10-fold Cross Validation (random fold)");
                int choice = scanner.nextInt();
                kNNSolver knn = new kNNSolver(data,k,choice);
                System.out.println("Accuracy kNN: " + knn.countAccuracy()*100 + "%");
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
                System.out.print("Press 1 for full training and 2 for 10-fold cross validation: ");
                System.out.println("Press:");
                System.out.println("1. Full Training");
                System.out.println("2. 10-fold Cross Validation");
                System.out.println("3. 10-fold Cross Validation (random fold)");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        nb.fullTraining();
                        break;
                    }
                    case 2: {
                        nb.crossValidation(10);
                        break;
                    }
                    case 3: {
                        nb.randCrossValidation(10);
                        break;
                    }
                }
                break;
            }
        }
    }
    
}
