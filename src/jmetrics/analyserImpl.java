/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmetrics;

import java.io.IOException;

/**
 *
 * @author ioannis
 */
public final class analyserImpl {
    
    public static void  main(String[] args) throws IOException{
    String dir = args[0];
    
    analyserHandler handler = new analyserHandler(new LocCounterStrategy());
    handler.executeAnalyserHandler(dir);
    
    analyserHandler handler2 = new analyserHandler(new NoOfMethodsStrategy());
    handler2.executeAnalyserHandler(dir);
    
    analyserHandler handler3 = new analyserHandler(new ASTViewStrategy());
    handler3.executeAnalyserHandler(dir);
    }
    
}
