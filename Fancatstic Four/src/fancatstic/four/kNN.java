package fancatstic.four;

import java.util.*;

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
    private int k;
    private DataSet data;
    private PriorityQueue<Neighbor> neighbors;
    private List<DataClass> classes = new ArrayList<>();
    
    public kNN() {
        // Empty constructor
    }
    
    public kNN(DataSet _data, List<String> identify, int _k) {
        k = _k;
        data = _data;
        neighbors = new PriorityQueue(k, new Comparator<Neighbor>() {
            @Override
            public int compare(Neighbor neighbor1, Neighbor neighbor2) {
                return Integer.compare(neighbor2.distance, neighbor1.distance);
            }
        });
        
        // Menghitung jarak dari setiap atribut
        for (int i=0; i<data.getDataset().size(); i++) {
            int dis = 0;
            for (int j=0; j<data.getDataset().get(i).size()-1; j++) {
                if (data.getDataset().get(i).get(j).equals(identify.get(j))) {
                    
                } else {
                    dis++;
                }
                System.out.print(data.getDataset().get(i).get(j) + " ");
            }
            System.out.println("distance: " + dis);
            Neighbor n = new Neighbor(i,dis);
            neighbors.add(n);
            if (neighbors.size() > k)
                neighbors.poll();
        }

    }
    
    public void printQueue(){
        Queue<Neighbor> copy = new PriorityQueue<Neighbor>(neighbors);
        
        Iterator<Neighbor> itr = copy.iterator();
        System.out.println("SIZE: " + copy.size());
        while(itr.hasNext()){
            Neighbor n = copy.poll();
            System.out.println(n.index + " - " + n.index);
        }
    }
    
    public String solve() {
        PriorityQueue<Neighbor> copy = new PriorityQueue<Neighbor>(neighbors);
        
        // Mencari jumlah masing-masing kelas pada priority queue Neighbor
        Iterator<Neighbor> itr = copy.iterator();
        while(itr.hasNext()){
            Neighbor n = itr.next();
            
            boolean found = false;
            int j = 0;
            while ((j < classes.size()) && !found){
                // Jika kelas yang sama sudah ada, maka counter hanya akan bertambah
                if (data.getClass(n.index).equals(classes.get(j).classData)){
                    classes.get(j).addCounter();
                    found = true;
                } else {
                    j++;
                }
            }
            // Jika kelas belum ada pada list, maka kelas akan ditambahkan
            if (!found){
                DataClass newData = new DataClass(data.getClass(n.index));
                classes.add(newData);
            }
        }
        classes.sort(new Comparator<DataClass>(){
                @Override
                public int compare(DataClass d1, DataClass d2) {
                    return (d1.count < d2.count ? 1 : -1);
                }
        });
        
        return classes.get(0).classData;
    }
    
    //Nested class DataClass
    public class DataClass {
        public String classData;
        public int count;

        public DataClass(){
            this.classData = "";
            this.count = 1;
        }

        public DataClass(String _classData){
            this.classData = new String(_classData);
            this.count = 1;
        }
        
        public void addCounter() {
            this.count++;
        }

        public void printData(){
            System.out.println(classData + " - " + count);
        }
    }
    
    //Nested class Neighbor
    public class Neighbor {
        public int index;
        public int distance;

        public Neighbor(){
            this.index = 0;
            this.distance = 0;
        }

        public Neighbor(int _index, int _distance){
            this.index = _index;
            this.distance = _distance;
        }
    }
}
