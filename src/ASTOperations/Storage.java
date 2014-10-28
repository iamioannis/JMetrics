 /*
 * Copyright (C) 2014 Ioannis Mastigopoulos
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package ASTOperations;


/**
 * Storage facility that stores the Metrics of the analysis
 * @author Ioannis Mastigopoulos
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
    
    public int getCCBasedOnIfStatemets(){
        int ccboif = noOfIfTrees + 2;
        
        return ccboif;
    }
    
}
