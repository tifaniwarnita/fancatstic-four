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
        System.out.println("Working Directory = " +
        System.getProperty("user.dir"));
        DataSet data = new DataSet("weather.nominal.arff");
        
        List<String> classValues = data.getClassValues();
        List<String> attributes = data.getAttributes();
        Map<String,List<String>> attributeValues = data.getAttributeValues();
        
        NaiveBayes nb = new NaiveBayes(data.getDataset(),attributes,attributeValues,classValues);
        nb.fullTraining();
        
    }
    
}
