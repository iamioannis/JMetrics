/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmetrics;
/**
 *
 * @author ioannis
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jdt.astview.*;

public class ASTViewStrategy implements Strategy{
    
  private TreeInfoCollector treeInfo;
  public int noOfASTNodes = 0;
  private Class c[];
  private Field noOfFields[];
  private int totalNoOffields;

  public void countNoOfASTNodes(String dir) throws IOException{
    ASTViewStrategy astview = new ASTViewStrategy();
    File root = new File(dir);
    noOfNodes(root);
    System.out.println("No of fields: "+ totalNoOffields);
  }
  
  private void noOfNodes(File dir) throws IOException{
        int x;
        //for(File f : dir.listFiles()){
           
            if (dir.getName().endsWith(".java")){
                Class g = dir.getClass();
                noOfFields = g.getDeclaredFields();
                x=noOfFields.length;
                totalNoOffields =+ x;
                
                }
            //}
       
       }
       
    @Override
    public void analyse(String dir){
    try{
        countNoOfASTNodes(dir);
    } catch (IOException ex){
        Logger.getLogger(ASTViewStrategy.class.getName()).log(Level.SEVERE,null, ex);
    }
    }
  }
    
  
    

