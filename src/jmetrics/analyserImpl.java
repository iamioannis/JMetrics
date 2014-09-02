/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmetrics;

import analysersStrategies.LocCounterStrategy;
import analysersStrategies.NoOfMethodsStrategy;
import analysersStrategies.astOperationsStrategy;
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
    

    
    
    //This is where new Strategies should be implemented
    
    handler =  new analyserHandler(new astOperationsStrategy());
    handler.executeAnalyserHandler(dir);
}
}