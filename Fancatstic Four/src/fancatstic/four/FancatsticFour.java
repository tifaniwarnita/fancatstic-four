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
//<<<<<<< HEAD
       // DataSet data = new DataSet("car.data");
//=======
        DataSet data = new DataSet("weather.txt");
//>>>>>>> origin/master
    /*    List<String> identify = new ArrayList<>();
        identify.add("vhigh");
        identify.add("vhigh");
        identify.add("2");
        identify.add("2");
        identify.add("small");
        identify.add("low");
*/
    List<String> oldClasses = new ArrayList<>();
    int attr = data.getDataset().get(0).size()-1;
    for (int i=0; i<data.getDataset().size(); i++) {
        oldClasses.add(data.getDataset().get(i).get(attr));
    }
    
    List<String> newClasses = new ArrayList<>();
    List<kNN> knn = new ArrayList<>();
    for (int i=0; i<data.getDataset().size(); i++) {
        knn.add(new kNN(data,data.getDataset().get(i),3));
        //knn.printQueue();
        newClasses.add(knn.get(i).solve());
    }
    
    int countAccuracy = 0;
    for (int i=0; i<data.getDataset().size(); i++) {
        if (oldClasses.get(i).equals(newClasses.get(i))){
            //System.out.println("same");
            countAccuracy++;
        }
    }
    float accuracy = (float)countAccuracy / (float)data.getDataset().size();

    System.out.println("Accuracy = " + accuracy);
    
/*=======
        identify.add("low");
        identify.add("sunny");
        identify.add("hot");
        identify.add("high");
        identify.add("FALSE");
        //kNN knn = new kNN(data,identify,4);
        NaiveBayes nb = new NaiveBayes(data.getDataset());
        System.out.println(nb.classify(identify));
>>>>>>> origin/master*/
    }
    
}