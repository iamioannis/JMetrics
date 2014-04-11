
package jmetrics;

/**
 *
 * @author ioannis on 01/04/2014
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class codeCounter {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
        }
        else {
            codeCounter loc = new codeCounter();
            File root = new File(args[0]);
            loc.countLinesOfCode(root);
            System.out.println("Found " + loc.lines + " lines of code in "+ root.getName() + " in " + root.getCanonicalPath());
        }
    }

    private long lines = 0;

    private void countLinesOfCode(File f) throws IOException {

        if (f.getName().endsWith(".java")) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line = br.readLine();
                while (line != null) {
                    if (!line.trim().equals("")) {
                        this.lines++;
                    }
                    line = br.readLine();
                }
            }
        }
    }
}

