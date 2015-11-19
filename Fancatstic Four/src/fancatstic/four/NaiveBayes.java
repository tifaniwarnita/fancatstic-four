package fancatstic.four;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class NaiveBayes {
        List<String> attributes;
        private Map<String,List<String>> attributeValues = new HashMap<>();
        private List<String> classValues = new ArrayList<>();
        private List<List<String>> fullset;

	public NaiveBayes(List<List<String>> dataset, List<String> attributes, Map<String,List<String>> attributeValues, List<String> classValues) {
            fullset = dataset;
            this.attributes = attributes;
            this.attributeValues = attributeValues;
            this.classValues = classValues;
        }
        
        public Map<String,Map<String,Map<String,Integer>>> createModel(List<List<String>> dataset) {
                int i;
		int j;
                
                //inisialisasi seluruh isi model dengan 0
		Map<String,Map<String,Map<String,Integer>>> model = new HashMap<>();
		for (Map.Entry<String, List<String>> attribute : attributeValues.entrySet()) {
                    model.put(attribute.getKey(),new HashMap<>());
                    for (String atrValue : attribute.getValue()) {
                        model.get(attribute.getKey()).put(atrValue,new HashMap<>());
                        for (String classValue : classValues) {
                            model.get(attribute.getKey()).get(atrValue).put(classValue, 0);
                        }
                    }
		}
                
                model.put("Class", new HashMap<>());
                model.get("Class").put("Total", new HashMap<>());
                
                for (String classValue : classValues) {
                    model.get("Class").get("Total").put(classValue, 0);
                }
                
		for (i=0;i<dataset.size();i++) {
			String classValue = dataset.get(i).get(attributes.size());
                        model.get("Class").get("Total").put(classValue, model.get("Class").get("Total").get(classValue)+1);
			for (j=0;j<attributes.size();j++) {
                            String atrName = attributes.get(j);
                            String atrValue = dataset.get(i).get(j);
                            model.get(atrName).get(atrValue).put(classValue,model.get(atrName).get(atrValue).get(classValue)+1);
			}
		}
                
                return model;
        }
       
        
        public String classify(List<String> newdata, Map<String,Map<String,Map<String,Integer>>> model) {
            double maxp = 0;
            double p;
            int totalCount=0;
            
            for (int classCount : model.get("Class").get("Total").values()) {
                totalCount+= classCount;
            }
            String classification = "";
            for (String classValue : classValues) { 
                int classCount = model.get("Class").get("Total").get(classValue);
                p=(double)classCount/(double)totalCount;                
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
            System.out.println(classification);
            return classification;
        }
        
        public void printModel(Map<String,Map<String,Map<String,Integer>>> model) {
            for (String atrName : attributes) {
                    System.out.println(atrName);
                    for (String atrValue : attributeValues.get(atrName)) {
                        System.out.print(atrValue);
                        for (String classValue : classValues) {
                            System.out.print(" - "+classValue+": "+model.get(atrName).get(atrValue).get(classValue));
                        }
                        System.out.println();
                    }
                    System.out.println();
            }
        }
        public void exportModel(String filename, Map<String,Map<String,Map<String,Integer>>> model) throws FileNotFoundException, UnsupportedEncodingException{
            try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
                for (String atrName : attributes) {
                    writer.println(atrName);
                    for (String atrValue : attributeValues.get(atrName)) {
                        writer.print(atrValue);
                        for (String classValue : classValues) {
                            writer.print(" - "+classValue+": "+model.get(atrName).get(atrValue).get(classValue));
                        }
                        writer.println();
                    }
                    writer.println();
                }
            }
        }
<<<<<<< HEAD
        
        public List<String> testSet(List<List<String>> dataset, Map<String,Map<String,Map<String,Integer>>> model){
            List<String> hasil = new ArrayList<>();
            for (int i=0; i< dataset.size() ; i++){
                List<String> test = new ArrayList<>();
                for (String s : dataset.get(i)) {
                    System.out.print(s+" ");
                }
                System.out.print(" - ");
                for (int j=0; j< dataset.get(0).size()-1; j++){
                    test.add(dataset.get(i).get(j));
                }
               hasil.add(classify(test, model));
            }
            return hasil;
        }
        
        public float accuracy(List<List<String>> dataset, List<String> result){
            int natr = dataset.get(0).size();
            int a=0;
            for (int i=0; i < dataset.size(); i++){
                String r = dataset.get(i).get(natr-1);
                if (r.equals(result.get(i))){
                    a++;
                }
            }
            float acc = (float)a/dataset.size();
            System.out.println();
            System.out.println("Correctly Classified Instances: "+a);
            System.out.println("Incorrectly Classified Instances: "+(dataset.size()-a));
            return acc;
        }
        
        public void fullTraining() {
            Map<String,Map<String,Map<String,Integer>>> model = createModel(fullset);
            printModel(model);
            System.out.println("Accuracy: "+accuracy(fullset,testSet(fullset,model))*100+"%");
        }
        
        void crossValidation(int folds) {
            /*
            float sumacc = 0;
            float maxacc = 0;
            for (int i=0;i<folds;i++) {
                    //testingset =  ambil folds% dari dataset
                    //trainingset = (100-folds)% dari dataset
                    createModel(trainingset);
                    float acc = accuracy(testingset,testSet(testingset));
                    sumacc += acc;
                    if (acc>maxacc) maxacc = acc;
            }
            float avgacc = sumacc/dataset.size();
            System.out.println("Average accuracy: "+avgacc);
            System.out.println("Max accuracy: "+maxacc);*/
        }
=======
>>>>>>> origin/master
}