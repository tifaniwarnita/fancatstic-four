/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fancatstic.four;

import java.util.*;

/**
 *
 * @author jessica
 */
public class DataClass {
    private String classData;
    private int count;
    
    public DataClass(){
        
    }
    
    public DataClass(String _classData){
        classData = new String(_classData);
        count = 1;
    }

    /**
     * @return the classData
     */
    public String getClassData() {
        return classData;
    }

    /**
     * @param classData the classData to set
     */
    public void setClassData(String classData) {
        this.classData = classData;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    public void addCounter(){
        this.count++;
    }
    
    public void printData(){
        System.out.println(classData + " - " + count);
    }
    
    
}
