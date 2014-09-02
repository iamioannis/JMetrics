/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmetrics;

import analysersStrategies.LocCounterStrategy;
import analysersStrategies.NoOfMethodsStrategy;
import analysersStrategies.astOperationsStrategy;

/**
 *
 * @author ioannis
 */
public class analyserHandler {
    
    private Strategy strategy;
    
    public analyserHandler(Strategy strategy){
        this.strategy = strategy;
    }
      
    public void executeAnalyserHandler(String dire){
        strategy.analyse(dire);
    }
    
}
