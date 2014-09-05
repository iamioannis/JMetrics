 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analysersStrategies;

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
import jmetrics.Strategy;

public class LocCounterStrategy implements Strategy{
    
    public void locCount(String dir) throws IOException{
        if(dir.length() == 0){
            System.out.println("No files found");
        }
        else{
            LocCounterStrategy loc = new LocCounterStrategy();
            File root = new File(dir);
            loc.countLinesOfCodeInDirectory(root);
            System.out.println("Lines of code: " + loc.lines + " in " + loc.files + " files" );
        }
    }
    
private long files = 0;
private long lines = 0;

    private void countLinesOfCodeInDirectory(File dir) throws IOException {
    for (File f : dir.listFiles()) {
        int tempLines = 0;
        if (f.isDirectory()) {
            countLinesOfCodeInDirectory(f);
        } 
    else {
        if (f.getName().endsWith(".java")) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                //PEDNING added check for comment lines
                if (!line.trim().equals("") && !line.trim().startsWith("//") && !line.trim().startsWith("*") && !line.trim().startsWith("/*") && !line.trim().startsWith("/**") && !line.trim().startsWith("*/")) {
                    this.lines++;
                    tempLines++;
                        }
                line = br.readLine();
            }
            br.close();
            System.out.println("The Lines of code in " + f.getName() + " is " + tempLines);
            this.files++;
        }
        }
}
}
    
    @Override
    public void analyse(String dir) {
        try {
            locCount(dir);
        } catch (IOException ex) {
            Logger.getLogger(LocCounterStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
