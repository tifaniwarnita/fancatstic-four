package fancatstic.four;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                model.get("Class").get("Total").put("total",0);
                
		for (i=0;i<dataset.size();i++) {
			String classValue = dataset.get(i).get(attributes.size());
                        model.get("Class").get("Total").put(classValue, model.get("Class").get("Total").get(classValue)+1);
                        model.get("Class").get("Total").put("total", model.get("Class").get("Total").get("total")+1);
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
            int totalCount=model.get("Class").get("Total").get("total");
            
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
            //System.out.println(classification);
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
            System.out.println("Class");
            for (String classval : classValues){
                System.out.print(classval+" - ");
                System.out.println(model.get("Class").get("Total").get(classval));
            }
            System.out.println("total - "+model.get("Class").get("Total").get("total"));
            System.out.println();
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
                writer.println("Class");
                for (String classval : classValues){
                    writer.print(classval+" - ");
                    writer.println(model.get("Class").get("Total").get(classval));
                }
                writer.println("total - "+model.get("Class").get("Total").get("total"));
            }
        }
        
        public List<String> testSet(List<List<String>> dataset, Map<String,Map<String,Map<String,Integer>>> model){
            List<String> hasil = new ArrayList<>();
            for (int i=0; i< dataset.size() ; i++){
                List<String> test = new ArrayList<>();
                for (String s : dataset.get(i)) {
                    //System.out.print(s+" ");
                }
                //System.out.print(" - ");
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
        
        public int[][] confusionMatrix(List<List<String>> dataset, List<String> result){
            int nclass = classValues.size();
            int natr = dataset.get(0).size();
            int[][] matrix = new int[nclass][nclass];
            
            for (int j=0; j<nclass; j++){
                for (int k=0; k<nclass; k++){
                    matrix[j][k]=0;
                }
            }
            
            for (int i=0; i < dataset.size(); i++){
                String dataclass = dataset.get(i).get(natr-1);
                for (int j=0; j<nclass; j++){ //actual values
                    for (int k=0; k<nclass; k++){ //prediction
                        if (dataclass.equals(classValues.get(j)) && result.get(i).equals(classValues.get(k))){
                            matrix[j][k]++;
                        }
                    }
                }
            }
            
            return matrix;
        }
        
        public void fullTraining() {
            Map<String,Map<String,Map<String,Integer>>> model = createModel(fullset);
            printModel(model);
            System.out.println("Accuracy: "+accuracy(fullset,testSet(fullset,model))*100+"%");
            System.out.println("Confusion Matrix:");
            int[][] matrix = confusionMatrix(fullset,testSet(fullset,model));
            for (int j=0; j<classValues.size(); j++){
                for (int k=0; k<classValues.size(); k++){
                    System.out.print(matrix[j][k]+" ");
                }
                System.out.println();
            }
            try {
                exportModel("model.txt",model);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(NaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        void crossValidation(int folds) {
	float sumacc = 0;
	float maxacc = 0;
        float [][] matrix = new float[classValues.size()][classValues.size()];
	int last = 0;
	int start;
	List<List<String>> trainingset =  new ArrayList<>();
	List<List<String>> testingset;
        
        // Initializing confusion matrix
        for (int j=0; j<classValues.size(); j++){
            for (int k=0; k<classValues.size(); k++){
                matrix[j][k] = 0;
            }
        }
        
        // Classify
	for (int i=0;i<folds;i++) {
            System.out.print("i = "+i);
            start = last;
            last = start + fullset.size()/folds;
            if (i < fullset.size() % folds) {
                last++;
            }
            testingset =  fullset.subList(start,last);
            trainingset.clear();
            if (start>0) trainingset.addAll(fullset.subList(0,start));
            trainingset.addAll(fullset.subList(last,fullset.size()));
                
            float acc = accuracy(testingset,testSet(testingset,createModel(trainingset)));
            System.out.println("Accuracy: "+acc);
            sumacc += acc;
            if (acc>maxacc) maxacc = acc;
            
            System.out.println("Confusion Matrix");
            int[][] cmatrix = confusionMatrix(testingset,testSet(testingset,createModel(trainingset)));
            for (int j=0; j<classValues.size(); j++){
                for (int k=0; k<classValues.size(); k++){
                    System.out.print(cmatrix[j][k]+ " ");
                    matrix[j][k] += (float)cmatrix[j][k];
                }
                System.out.println();
            }
            System.out.println();
	}
	float avgacc = (float)sumacc/(float)folds;
	System.out.println("Average accuracy: "+avgacc*100+"%");
	System.out.println("Max accuracy: "+maxacc*100+"%");
        System.out.println("Average Confusion Matrix");
        for (int j=0; j<classValues.size(); j++){
            for (int k=0; k<classValues.size(); k++){
                matrix[j][k] = matrix[j][k]/(float)folds;
                System.out.printf("%.2f",matrix[j][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
        
    void randCrossValidation(int folds) {
	float sumacc = 0;
	float maxacc = 0;
	int n;
        float [][] matrix = new float[classValues.size()][classValues.size()];
        
        // Initializing confusion matrix
        for (int j=0; j<classValues.size(); j++){
            for (int k=0; k<classValues.size(); k++){
                matrix[j][k] = 0;
            }
        }
        
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
            float acc = accuracy(testingset,testSet(testingset,createModel(trainingset)));
            System.out.println("Accuracy: "+acc);
            sumacc += acc;
            if (acc>maxacc) maxacc = acc;
                
            System.out.println("Confusion Matrix");
            int[][] cmatrix = confusionMatrix(testingset,testSet(testingset,createModel(trainingset)));
            for (int j=0; j<classValues.size(); j++){
                for (int k=0; k<classValues.size(); k++){
                    System.out.print(cmatrix[j][k]+ " ");
                    matrix[j][k] += (float)cmatrix[j][k];
                }
                System.out.println();
            }
            System.out.println();
	}
	float avgacc = (float)sumacc/(float)folds;
	System.out.println("Average accuracy: "+avgacc*100+"%");
	System.out.println("Max accuracy: "+maxacc*100+"%");
        System.out.println("Average Confusion Matrix");
        for (int j=0; j<classValues.size(); j++){
            for (int k=0; k<classValues.size(); k++){
                matrix[j][k] = matrix[j][k]/(float)folds;
                System.out.printf("%.2f",matrix[j][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}