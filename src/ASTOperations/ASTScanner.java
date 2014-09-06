/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ASTOperations;

import com.sun.source.tree.AnnotationTree;
import com.sun.source.tree.CaseTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.ConditionalExpressionTree;
import com.sun.source.tree.DoWhileLoopTree;
import com.sun.source.tree.ForLoopTree;
import com.sun.source.tree.IfTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.WhileLoopTree;
import com.sun.source.util.TreeScanner;
import java.util.List;
/**
 *
 * @author ioannis
 */
public class ASTScanner extends TreeScanner<Void, Void> {
    
    public static Storage theStorage = new Storage();

    public ASTScanner(CompilationUnitTree compilationUnitTree) {
        List<? extends AnnotationTree> theTrees = compilationUnitTree.getPackageAnnotations();
        //System.out.println("I hope that here are the Trees: " + theTrees.toString());

    }
    @Override
    public Void visitIf(IfTree arg0,Void a){
        theStorage.addToIfTreesCollection(arg0.getCondition().toString());    
        theStorage.increaseComplexity();
        return super.visitIf(arg0, a);
    }
    
    @Override
    public Void visitWhileLoop(WhileLoopTree arg0, Void a){
        theStorage.increaseComplexity();
        return super.visitWhileLoop(arg0,a);
    
    }
    
    @Override
    public Void visitForLoop(ForLoopTree arg0, Void a){
        theStorage.addToForLoopTreesCollection(arg0.getCondition().toString());
        System.out.println("ForLoops: " + arg0.getCondition().toString());
        return super.visitForLoop(arg0, a);
    }
    
    @Override
    public Void visitMethod(MethodTree arg0, Void a){
        //System.out.println("Methods: " + arg0.getName().toString());
        theStorage.addToMethodsTreesCollection(arg0.getName().toString());
        return super.visitMethod(arg0, a);
    }
    
    //Added from Complexity
    @Override
    public Void visitCase(CaseTree arg0, Void a) {
        theStorage.increaseComplexity();
        return super.visitCase(arg0, a);
    }

    @Override
    public Void visitConditionalExpression(ConditionalExpressionTree arg0, Void a) {
        theStorage.increaseComplexity();
        return super.visitConditionalExpression(arg0,a);
    }
    
    @Override
    public Void visitDoWhileLoop(DoWhileLoopTree arg0, Void a) {
        theStorage.increaseComplexity();
        return super.visitDoWhileLoop(arg0, a);
    }
    
    @Override
    public Void visitClass(ClassTree arg0, Void a){
        theStorage.addToClassTreesCollection(arg0.getSimpleName().toString());
        return super.visitClass(arg0, a);
    }
}
