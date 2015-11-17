package fancatstic.four;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class NaiveBayes {
	private List<Map<String,Map<String,Integer>>> model;
        private Map<String,Integer> classes = new HashMap<>();
        private int datasize;

	public NaiveBayes(List<List<String>> dataset) {
		int i;
		int j;
		int natr = dataset.get(0).size();
                datasize = dataset.size();

		model = new ArrayList<>();
		for (i=0;i<natr;i++) {
			model.add(new HashMap<>());
		}

		for (i=0;i<datasize;i++) {
			String classvalue = dataset.get(i).get(natr-1);
                        if (!classes.containsKey(classvalue)) {
                            classes.put(classvalue,1);
                        } else {
                            classes.put(classvalue,classes.get(classvalue)+1);
                        }
			for (j=0;j<natr-1;j++) {
				String atrvalue = dataset.get(i).get(j);
				if (!model.get(j).containsKey(atrvalue)) {
					model.get(j).put(atrvalue,new HashMap<>());
				}
				if (!model.get(j).get(atrvalue).containsKey(classvalue)) {
					model.get(j).get(atrvalue).put(classvalue,1);	
				} else {
					model.get(j).get(atrvalue).put(classvalue,model.get(j).get(atrvalue).get(classvalue)+1);
				}
			}
		}
                
                for (i=0;i<model.size()-1;i++) {
                    System.out.println("Attribute " + (i+1));
                    for (Map.Entry<String, Map<String,Integer>> entry : model.get(i).entrySet()) {
                        System.out.print(entry.getKey());
                        for (Map.Entry<String,Integer> entry2 : entry.getValue().entrySet()) {
                            System.out.print(" - "+entry2.getKey()+": "+entry2.getValue());
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                
        }
        
        public String classify(List<String> newdata) {
            double maxp = 0;
            double p;
            String classified = "";
            for (Map.Entry<String,Integer> classesEntry : classes.entrySet()) {
                p=(double)classesEntry.getValue()/(double)datasize;                
                for (int i=0;i<newdata.size()-1;i++) {
                    double atrp = model.get(i).get(newdata.get(i)).containsKey(classesEntry.getKey()) ? (double)model.get(i).get(newdata.get(i)).get(classesEntry.getKey())/(double)classesEntry.getValue() : 0;
                    p *= atrp;
                }
                System.out.println("P("+classesEntry.getKey()+") = "+p);
                if (p>=maxp) {
                    maxp = p;
                    classified = classesEntry.getKey();
                }
            }
            return classified;
        }
}