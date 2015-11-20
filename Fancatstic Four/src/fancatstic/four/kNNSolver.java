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
    private int attrSize;
    private int k;
    
    public kNNSolver(){
        
    }
    
    public kNNSolver(DataSet data, int _k, int choice){
        k = _k;
        fullset = data.getDataset();
        attrSize = data.getDataset().get(0).size()-1;
        for (int i=0; i<data.getDataset().size(); i++) {
            oldClasses.add(data.getDataset().get(i).get(attrSize));
        }
        
        /* Jika memilih Full Training */
        if (choice == 1){
            
        }
    }
    
<<<<<<< HEAD
    public void fullTraining(DataSet data){
        for (int i=0; i< fullset.size(); i++) {
            knn.add(new kNN(data,fullset.get(i),k));
            newClasses.add(knn.get(i).solve());
=======
        for (int i=0; i<data.getDataset().size(); i++) {
            knn.add(new kNN(data,data.getDataset().get(i),k));
           // newClasses.add(knn.get(i).solve());
>>>>>>> 44703e6ff2d4e85ddf54a381ab8edb232791264d
        }
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
	float sumacc = 0;
	float maxacc = 0;
	int last = 0;
	int start;
	List<List<String>> trainingset =  new ArrayList<>();
	List<List<String>> testingset;
	for (int i=0;i<folds;i++) {
            System.out.println("i = "+i);
		start = last;
		last = start + fullset.size()/folds;
		if (i < fullset.size() % folds) {
                    last++;
		}
		testingset =  fullset.subList(start,last);
                trainingset.clear();
		if (start>0) trainingset.addAll(fullset.subList(0,start));
                trainingset.addAll(fullset.subList(last,fullset.size()));
                
		/*float acc = accuracy(testingset,testSet(testingset,createModel(trainingset)));
                System.out.println("Accuracy: "+acc);
                System.out.println();
		sumacc += acc;
		if (acc>maxacc) maxacc = acc;*/
	}
	float avgacc = (float)sumacc/(float)folds;
	System.out.println("Average accuracy: "+avgacc*100+"%");
	System.out.println("Max accuracy: "+maxacc*100+"%");
    }
        
    void randCrossValidation(int folds) {
	float sumacc = 0;
	float maxacc = 0;
	int n;
	List<List<String>> trainingset =  new ArrayList<>();
	List<List<String>> testingset = new ArrayList<>();
        java.util.Set<Integer> testNumbers = new java.util.HashSet<>();
        java.util.Random rng = new java.util.Random();
	for (int i=0;i<folds;i++) {
            System.out.println("i = "+i);
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
                    } else {
                        testingset.add(fullset.get(j));
                    }
                }
                
                
                
		/* float acc = accuracy(testingset,testSet(testingset,createModel(trainingset)));
                System.out.println("Accuracy: "+acc);
                System.out.println();
		sumacc += acc;
		if (acc>maxacc) maxacc = acc; */
	}
	float avgacc = (float)sumacc/(float)folds;
	System.out.println("Average accuracy: "+avgacc*100+"%");
	System.out.println("Max accuracy: "+maxacc*100+"%");
    }
    
    
    
}