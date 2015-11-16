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
        List<String> identify = new ArrayList<>();
        /*identify.add("vhigh");
        identify.add("vhigh");
        identify.add("2");
        identify.add("2");
        identify.add("small");
        identify.add("low");*/
        identify.add("sunny");
        identify.add("hot");
        identify.add("high");
        identify.add("FALSE");
        //kNN knn = new kNN(data,identify,4);
        NaiveBayes nb = new NaiveBayes(data.getData());
        System.out.println(nb.classify(identify));
    }
    
}
