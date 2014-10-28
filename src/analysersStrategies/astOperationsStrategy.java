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
 * @author Ioannis Mastigopoulos
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
        System.out.println("Number of If Statements in project: "+ theStorage.getIfTrees() + "\n" + "Number of Methods in Project: " + theStorage.getNoOfMethods());
        System.out.println("Number of For Loops in the project: " + theStorage.getNoOfForLoops());
        System.out.println("Number of Classes in the project: " + theStorage.getNoOfClasses() + "\n");
        System.out.println("Cyclomatic Complexity: " + theStorage.getComplexity());
        System.out.println("Cyclomatic Complexity based on If statements: " + theStorage.getCCBasedOnIfStatemets());
    }
}

