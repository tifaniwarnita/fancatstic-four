package fancatstic.four;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tifani
 */
public class kNN {
    List<Integer> distance = new ArrayList<>();
    
    public kNN() {
        
    }
    
    public kNN(DataSet data, List<String> identify, int k) {
        for (int i=0; i<data.getData().size(); i++) {
            int dis = 0;
            for (int j=0; j<data.getData().get(i).size()-1; j++) {
                if (data.getData().get(i).get(j).equals(identify.get(j))) {
                    
                } else {
                    dis++;
                }
                //System.out.print(data.getData().get(i).get(j) + " " + identify.get(j));
            }
            distance.add(dis);
        }
        for (int i=0; i<data.getData().size(); i++) {
            System.out.println(distance.get(i));
        }
    }
}
