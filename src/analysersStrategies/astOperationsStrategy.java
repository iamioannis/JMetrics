/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analysersStrategies;

import ASTOperations.ASTImpl;
import static ASTOperations.ASTScanner.theStorage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jmetrics.Strategy;


/**
 *
 * @author ioannis
 */
public class astOperationsStrategy implements Strategy{
    
     public void astImpl(String dir) throws IOException{
        File files = new File(dir);
        ASTAnalysis(files);
        printResults();

    }

    public static void ASTAnalysis(File files) throws IOException{
        ASTImpl astImplementation = new ASTImpl();
        for (File f: files.listFiles()){
            if (f.isDirectory()){
                ASTAnalysis(f);
            }else{
                if(f.getName().endsWith(".java")){
                astImplementation.scan(f.getAbsolutePath());
                }
            }
        }
    }
     
    

    @Override
    public void analyse(String dir) {
         try {
             astImpl(dir);
         } catch (IOException ex) {
             Logger.getLogger(astOperationsStrategy.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void printResults() {
        System.out.println("Number of If Statements in project: "+ theStorage.getIfTreesCollectionSize() + "\n" + "Number of For Loops in Project: " 
                    + theStorage.getForLoopTreesCollectionSize() + "\n" + "Number of Methods in Project: " + theStorage.getMethodsTreesCollectionSize());
        System.out.println("Number of Classes in the project: " + theStorage.getClassTreesCollectionSize() + "\n");
        System.out.println("Cyclomatic Complexity: " + theStorage.getComplexity());
        //System.out.println("Average of Cyclomatic Complexity: " + theStorage.getAvgComplexity());
    }
}

