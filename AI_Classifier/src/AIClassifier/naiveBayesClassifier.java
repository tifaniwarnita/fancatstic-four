/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AIClassifier;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author ASUS X202E
 */
public class naiveBayesClassifier {
    private final static Map<String,Map<String,Map<String,Integer>>> model = new HashMap<>();
    private final static List<String> attributes = new ArrayList<>(Arrays.asList("buying","maint","doors","persons","lug_boot","safety"));
    private final static Map<String,List<String>> attributeValues = new HashMap<>();
    private final static List<String> classValues = new ArrayList<>(Arrays.asList("unacc","acc","good","vgood"));
    private final static double totalCount = 1728;
    
    public void initialize() {
        //isi attributeValues & model
    }
    public static String classify(List<String> newdata) {
            double maxp = 0;
            double p;
            String classification = "";
            for (String classValue : classValues) { 
                int classCount = model.get("Class").get("Total").get(classValue);
                p=(double)classCount/totalCount;                
                for (int i=0;i<newdata.size();i++) {
                    String atrName = attributes.get(i);
                    String atrValue = newdata.get(i);       
                    double atrp = (double)model.get(atrName).get(atrValue).get(classValue)/(double)classCount;
                    p *= atrp;
                }
                if (p>=maxp) {
                    maxp = p;
                    classification = classValue;
                }
            }
            return classification;
    }
}
