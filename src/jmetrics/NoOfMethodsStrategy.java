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

import java.lang.reflect.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoOfMethodsStrategy implements Strategy {
    
    private long noOfMethods =0;
    private long files= 0;

    public void methodCount(String dir) throws IOException{

    if(dir.length() ==0 ){
        System.out.println("No files found");
    }else{
        NoOfMethodsStrategy nom = new NoOfMethodsStrategy();
        File root = new File(dir);
        nom.countMethodsInDirectory(root);
        System.out.println("Number of methods: "+nom.noOfMethods + " in " + nom.files + " files");
    }
         
    }
    
    private void countMethodsInDirectory(File dir) throws IOException{
    for (File f : dir.listFiles()){
        if (f.isDirectory()){
            countMethodsInDirectory(f);
        }else{
        if(f.getName().endsWith(".java")){
            //BufferedReader br = new BufferedReader(new FileReader(f));
            Class c = f.getClass();
            Method m[] = c.getDeclaredMethods();
            int x = m.length;
            noOfMethods = noOfMethods + x;
            this.files++;
        }
        }
    }
    
    }

@Override
public void analyse(String dir){
    try{
        methodCount(dir);
    }catch (IOException ex){
    Logger.getLogger(NoOfMethodsStrategy.class.getName()).log(Level.SEVERE, null, ex);
    }

}
}


    