/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ASTOperations;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Storage facility that stores the Metrics of the analysis
 * @author ioannis
 */
public class Storage {
    
    static int complexity = 2;
    static int avgComplexity = 0;
    static int noOfIfTrees = 0;
    static int noOfMethods = 0;
    static int noOfClasses = 0;
    static int noOfForLoops = 0;

    
    /**
     *Method that increases the Cyclomatic Complexity when invoked  
     */
    public void increaseComplexity(){
        complexity++;
    }
    
    
    /**
     * Accessor that retrieves the Cyclomatic Complexity Metric
     * @return complexity
     */
    public int getComplexity(){
        return complexity;
    }
    /**
     * Accessor to retrieve the Average Cyclomatic  Complexity
     * @return 
     */
    public int getAvgComplexity(){
        return avgComplexity;
    }
       
    //IfStatements
    
    /**
     * Accesor that returns the size of If Trees
     * @return the ifTrees
     */
    public int getIfTrees() {
        return noOfIfTrees;
    }
    /**
     * Modifier increases the number of If Tree nodes
     * @param statement
     */
    public void increaseIfTrees() {
        noOfIfTrees++;
    }
    

    //For Loops
    

    /**
     * Modifier that increases the number of For Loop Occurances
     * 
     */
    public void increaseNoOfForLoops() {
        noOfForLoops++;
    }
    
    /**
     * Accessor that returns the number of For Loops in the Project
     * @return the noOfForLoops
     */
    public int getNoOfForLoops() {
        return noOfForLoops;
    }

    
    //Methods 
    /**
     * Modifier that increases the number of Methods
     * 
     */
    public void increaseMethodCount(){

       noOfMethods++;
    }
    
    /**
     * Accessor that retrieves the number of Methods in the Project
     * @return the noOfMethods
     */
    public int getNoOfMethods(){
        return noOfMethods;

    }
    
    //Classes
    
    /**
     * Modifier that increases the number of Classes
     * 
     */
    public void increaseClassCount(){

       noOfClasses++;
    }
    
    /**
     * Accessor that retrieves the number of Classes in the Project
     * @return the noOfClasses
     */
    public int getNoOfClasses(){
        return noOfClasses;

    }
    
}
