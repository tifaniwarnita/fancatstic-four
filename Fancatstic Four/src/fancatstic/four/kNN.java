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
    PriorityQueue<Neighbor> neighbors;
    List<DataClass> classes = new ArrayList<>();
    
    public kNN() {
        
    }
    
    public kNN(DataSet data, List<String> identify, int _k) {
        k = _k;
        neighbors = new PriorityQueue(k, new Comparator<Neighbor>() {
            @Override
            public int compare(Neighbor neighbor1, Neighbor neighbor2) {
                //return neighbor1.getDistance() < neighbor2.getDistance() ? -1 : neighbor1.getDistance() == neighbor2.getDistance() ? 0 : 1;
                return Integer.compare(neighbor1.getDistance(),neighbor2.getDistance());
            }
    }   );
        
        for (int i=0; i<data.getDataset().size(); i++) {
            int dis = 0;
            for (int j=0; j<data.getDataset().get(i).size()-1; j++) {
                if (data.getDataset().get(i).get(j).equals(identify.get(j))) {
                    
                } else {
                    dis++;
                }
                //System.out.print(data.getData().get(i).get(j) + " " + identify.get(j));
            }
            Neighbor n = new Neighbor(i,data.getDataset().get(i),dis);
            neighbors.add(n);
        }
        /*for (int i=0; i<data.getDataset().size(); i++) {
            System.out.println(neighbors.get(i).getIndex() + ", " + neighbors.get(i).getDistance());
        }
        */
    }
    
    public void printQueue(){
        //List<Neighbor> copy = new ArrayList<Neighbor>(neighbors);
        PriorityQueue<Neighbor> copy = new PriorityQueue<Neighbor>(neighbors);
            
        for(int i=0; i<k; i++){
                System.out.print(copy.peek().getIndex() + " - " + copy.peek().getDistance());
                copy.remove();
                //System.out.print(copy.get(i).getIndex() + " - " + copy.get(i).getDistance());
                System.out.println();
        }
        System.out.println();

    }
    
    public void countClasses(){
        PriorityQueue<Neighbor> copy = new PriorityQueue<Neighbor>(neighbors);
        for(int i=0; i<k; i++){
            List<String> data = new ArrayList<>(copy.peek().getData());
            copy.remove();
            // Jika list masih kosong, elemen data akan dimasukkan
            if (classes.isEmpty()){
                DataClass newData = new DataClass(data.get(data.size()-1));
                classes.add(newData);
            }
            else {
                boolean found = false;
                int j = 0;
                while ((j < classes.size()) && !found){
                    // Jika kelas yang sama sudah ada, maka counter hanya akan bertambah
                    if (data.get(data.size()-1).equals(classes.get(j).getClassData())){
                        classes.get(j).addCounter();
                        found = true;
                    }
                    j++;
                }
                
                // Jika kelas belum ada pada list, maka kelas akan ditambahkan
                if (!found && j == classes.size()){
                    DataClass newData = new DataClass(data.get(data.size()-1));
                    classes.add(newData);
                }
            }
        }
        
        for(int i=0; i<classes.size(); i++){
            classes.get(i).printData();
        }
        
    }
    
    public String solve(){
        countClasses();
        classes.sort(new Comparator<DataClass>(){
            @Override
            public int compare(DataClass d1, DataClass d2) {
                return d1.getCount() < d2.getCount() ? 1 : -1;
            }
    });
        return classes.get(0).getClassData();
    }
}
