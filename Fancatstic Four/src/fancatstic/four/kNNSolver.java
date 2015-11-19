package fancatstic.four;


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
    private int attrSize;
    
    public kNNSolver(){
        
    }
    
    public kNNSolver(DataSet data, int k){
        attrSize = data.getDataset().get(0).size()-1;
        for (int i=0; i<data.getDataset().size(); i++) {
            oldClasses.add(data.getDataset().get(i).get(attrSize));
        }
    
        for (int i=0; i<data.getDataset().size(); i++) {
            knn.add(new kNN(data,data.getDataset().get(i),k));
            newClasses.add(knn.get(i).solve());
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
}