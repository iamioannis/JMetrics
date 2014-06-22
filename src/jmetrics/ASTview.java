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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jdt.astview.*;

public class ASTview implements Strategy{
    
public int noOfASTNodes;
    private TreeInfoCollector treeInfo;
    public ASTview() {
        
    }
    
    public void noOfNodes() throws IOException{
        noOfASTNodes = treeInfo.getSize();
        System.out.println("No of Nodes"+ noOfASTNodes);
}
    
    @Override
    public void analyse(String dir){
    try{
        noOfNodes();
    } catch (IOException ex){
        Logger.getLogger(ASTview.class.getName()).log(Level.SEVERE,null, ex);
    }
    }
    
}
