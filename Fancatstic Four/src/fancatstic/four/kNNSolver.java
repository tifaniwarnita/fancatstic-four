package fancatstic.four;


import fancatstic.four.DataSet;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jessica
 */
public class kNNSolver {
    private List<String> oldClasses = new ArrayList<>();
    private List<String> newClasses = new ArrayList<>();
    private List<kNN> knn = new ArrayList<>();
    private List<List<String>> fullset;
    private List<String> classValues = new ArrayList<>();
    private int k;
    
    public kNNSolver(){
        
    }
    
    public kNNSolver(DataSet data, int _k, int choice){
        k = _k;
        fullset = data.getDataset();
        classValues = data.getClassValues();
        for (int i=0; i<data.getDataset().size(); i++) {
            oldClasses.add(data.getClass(i));
        }
        
        /* Jika memilih Full Training */
        if (choice == 1){
            fullTraining();
        }
        else if (choice == 2){
            crossValidation(10);
        }
        else if (choice==3){
            randCrossValidation(10);
        }
    }
    
    public void fullTraining(){
        System.out.println("Full Training");
        for (int i=0; i< fullset.size(); i++) {
            knn.add(new kNN(fullset,fullset.get(i),k));
            newClasses.add(knn.get(i).solve());
        }
    }
    
    public int countCorrect(){
        int count = 0;
    
        for (int i=0; i<oldClasses.size(); i++) {
            if (oldClasses.get(i).equals(newClasses.get(i))){
                count++;
            }   
        }
        
        return count;
    }
    
    public int countIncorrect(){
        int count = 0;
    
        for (int i=0; i<oldClasses.size(); i++) {
            if (oldClasses.get(i).equals(newClasses.get(i))){
                count++;
            }   
        }
        
        return oldClasses.size()-count;
    }
    
    public float countAccuracy(){
        int count = 0;
    
        for (int i=0; i<oldClasses.size(); i++) {
            if (oldClasses.get(i).equals(newClasses.get(i))){
                count++;
            }   
        }
        float accuracy = (float)count / (float)oldClasses.size();
        return accuracy;
    }
    
    
    public void crossValidation(int folds) {
        System.out.println("Cross Validation");
	int last = 0;
	int start;
	List<List<String>> trainingset =  new ArrayList<>();
	List<List<String>> testingset;
	for (int i=0;i<folds;i++) {
            //System.out.println("i = "+i);
            start = last;
            last = start + fullset.size()/folds;
            if (i < fullset.size() % folds) {
                last++;
            }
	
            testingset =  fullset.subList(start,last);
            trainingset.clear();
            if (start>0) trainingset.addAll(fullset.subList(0,start));
                trainingset.addAll(fullset.subList(last,fullset.size()));
                
            for (int j=0; j< testingset.size(); j++) {
                knn.add(new kNN(trainingset,testingset.get(j),k));
                newClasses.add(knn.get(j).solve());
            }
	}
    }
        
    void randCrossValidation(int folds) {
        System.out.println("Cross Validation (random fold)");
	int n;
	List<List<String>> trainingset =  new ArrayList<>();
	List<List<String>> testingset = new ArrayList<>();
        java.util.Set<Integer> testNumbers = new java.util.HashSet<>();
        java.util.Random rng = new java.util.Random();
	for (int i=0;i<folds;i++) {
            //System.out.println("i = "+i);
            n = fullset.size()/folds;
            if (i < fullset.size() % folds) {
                n++;
            }
            
            testNumbers.clear();
            while (testNumbers.size() < n) {
                Integer next = rng.nextInt(fullset.size()-1) + 1;
                testNumbers.add(next);
            }
            
            testingset.clear();
            trainingset.clear();
            for (int j=0;j<fullset.size();j++) {
                if (!testNumbers.contains(j)) {
                    trainingset.add(fullset.get(j));
                }
                else {
                    testingset.add(fullset.get(j));
                }
            }
                     
            for (int j=0; j< testingset.size(); j++) {
                knn.add(new kNN(trainingset,testingset.get(j),k));
                newClasses.add(knn.get(j).solve());
            }
        }
    }
    
    public int countClass(){
        int nclass = classValues.size();
        return nclass;
    }
    
    public int[][] confusionMatrix(){
        int nclass = classValues.size();
        int[][] matrix = new int[nclass][nclass];
        
        for (int j=0; j<nclass; j++){
            for (int k=0; k<nclass; k++){
                matrix[j][k]=0;
            }
        }
        
        for (int i=0; i < newClasses.size(); i++){
            for (int j=0; j<nclass; j++){ //actual values
                for (int k=0; k<nclass; k++){ //prediction
                    if (oldClasses.get(i).equals(classValues.get(j)) && newClasses.get(i).equals(classValues.get(k))){
                        matrix[j][k]++;
                    }
                }
            }
        }
        
        return matrix;
    }
    
}