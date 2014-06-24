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
public class analyserHandler {
    private Strategy locStrategy;
    private Strategy nomStrategy;
    private Strategy astviewStrategy;
    
    public analyserHandler(Strategy strategy){
        this.locStrategy = strategy;
        
    }

    analyserHandler(LocCounterStrategy locCounterStrategy){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
            
    public void executeAnalyserHandler(String dire){
        locStrategy.analyse(dire);
    
}
}
