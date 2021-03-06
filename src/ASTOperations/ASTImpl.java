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

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.util.JavacTask;
import java.io.IOException;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
/**
 *
 * @author Ioannis Mastigopoulos
 */
public class ASTImpl {
    /** 
     * Implementation of the Abstract Syntax Tree Scanner.
     * 
     *@param file String file that contains the absolute path to the file that is going to be scanned and processed 
     * 
     */
    public void scan(String file){
        
        //Initation of the compilation process of the file
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<>();
        //Standar file manager generation from the compiler to handle file
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
        //Collection of the files objects
        Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(file);
        //Asignment of the task required by the compiler to procces the objects collected from the File
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);
        
        //Initiation of Javac compiler task and association with the CompilationTask
        JavacTask javacTask = (JavacTask) task;
        //Creation of the CompilationUnit trees which will store the Trees generated by the compilation of the task
        Iterable<? extends CompilationUnitTree> parseResult = null;
        try {
            //The compiler parsing from the file. 
            parseResult = javacTask.parse();
        } catch (IOException e) {

            // Parsing failed
            e.printStackTrace();
            System.exit(0);
        }
        //Itaration loop to itarate through the Tree collected
        for (CompilationUnitTree compilationUnitTree : parseResult) {
            //Paring of the ASTScanner and initiation of the scanning for specific Trees
            compilationUnitTree.accept(new ASTScanner(compilationUnitTree), null);
        }
        
        }
    }
