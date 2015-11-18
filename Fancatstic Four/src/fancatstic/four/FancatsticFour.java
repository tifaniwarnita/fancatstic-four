/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fancatstic.four;

import java.util.ArrayList;
import java.util.List;

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
        
        NaiveBayes nb = new NaiveBayes(data.getDataset());
        List<String> hasil = nb.fullTraining(data.getDataset());
        for (int i =0; i<hasil.size(); i++){
            System.out.println(hasil.get(i));
        }
    }
    
}
