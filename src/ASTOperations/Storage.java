/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ASTOperations;

import java.util.ArrayList;

/**
 * Storage facility that stores the Metrics of the analysis
 * @author ioannis
 */
public class Storage {
    
    static int complexity = 1;
    static int avgComplexity = 0;
    
    /**
     *Method that increases the Cyclomatic Complexity when invoked  
     */
    public void increaseComplexity(){
        complexity++;
    }
    
    public void calculateComplexity(){
        avgComplexity = complexity / methodsCollection.size();
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
    
    /**
     * Collection of all the If Loop Tree nodes
     */
    public ArrayList<String> ifTreesCollection  = new ArrayList<String>();
    
    public ArrayList<String> getIfTreesCollection() {
        return ifTreesCollection;
    }
    
    /**
     * Modifier that adds the statement of the If tree to the ifTreeCollection
     * @param statement
     */
    public void addToIfTreesCollection(String statement){

       ifTreesCollection.add(statement);
    }
    
    /**
     * Accessor to retrieve the size of the IfTreeCollection
     * @return 
     */
    public int getIfTreesCollectionSize(){
        return ifTreesCollection.size();

    }

    /**
     * Collection of all the For Loop Tree nodes
     */
    public ArrayList<String> forLoopTreesCollection = new ArrayList<String>();
    
    public ArrayList<String> forLoopTreesCollection() {
        return forLoopTreesCollection;
    }
    
    /**
     * Modifier that adds the statement of the For Loop tree to the ForLoopTreesCollection
     * @param statement
     */
    public void addToForLoopTreesCollection(String statement){

       forLoopTreesCollection.add(statement);
    }
    
    /**
     * Accessor to retrieve the size of the ForLoopTreesCollection
     * @return int
     */
    public int getForLoopTreesCollectionSize(){
        return forLoopTreesCollection.size();

    }
    
    /**
     * Collection of all the Method Tree nodes
     */
    public ArrayList<String> methodsCollection = new ArrayList<String>();
    
    /**
     * Accessor that returns the Methods contained in the MethodTreeCollection
     * @return ArrayList<String>
     */
    public ArrayList<String> methodsTreesCollection() {
        return methodsCollection;
    }
     
    /**
     * Modifier that adds the statement of the Method tree to the MethodTreesCollection
     * @param statement
     */
    public void addToMethodsTreesCollection(String statement){

       methodsCollection.add(statement);
    }
    
    /**
     * Accessor to retrieve the size of the MethodTreesCollection
     * @return 
     */
    public int getMethodsTreesCollectionSize(){
        return methodsCollection.size();

    }
    
    private ArrayList<String> classTreesCollection = new ArrayList<String>();

    /**
     * @return the size of 
     */
    public int getClassTreesCollectionSize() {
        return classTreesCollection.size();
    }

    /**
     * @param String the class name to add to the classTreesCollection
     */
    public void addToClassTreesCollection(String className) {
        classTreesCollection.add(className);
    }
    
    
    
}
