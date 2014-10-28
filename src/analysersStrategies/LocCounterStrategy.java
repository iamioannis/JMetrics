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

/**
 *
 * @author Ioannis Mastigopoulos
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
