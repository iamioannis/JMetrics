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

import com.sun.source.tree.CaseTree;
import com.sun.source.tree.CatchTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.ConditionalExpressionTree;
import com.sun.source.tree.DoWhileLoopTree;
import com.sun.source.tree.EnhancedForLoopTree;
import com.sun.source.tree.ForLoopTree;
import com.sun.source.tree.IfTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.WhileLoopTree;
import com.sun.source.util.TreeScanner;
/**
 * Main scanner of the AST generated by the compilation task.
 * It is responsible for scanning the AST and processes any of the Tree nodes that are relevant
 * to the metrics produced if they exist.
 * 
 * @author Ioannis Mastigopoulos
 */
public class ASTScanner extends TreeScanner<Void, Void> {
    
    public static Storage theStorage = new Storage();

    public ASTScanner(CompilationUnitTree compilationUnitTree) {
    }
    
    @Override
    public Void visitIf(IfTree it,Void a){
        theStorage.increaseIfTrees();
        theStorage.increaseComplexity();
        return super.visitIf(it, a);
    }
    
    @Override
    public Void visitWhileLoop(WhileLoopTree wl, Void a){
        theStorage.increaseComplexity();
        return super.visitWhileLoop(wl,a);
    
    }
    
    @Override
    public Void visitForLoop(ForLoopTree flt, Void a){
        theStorage.increaseNoOfForLoops();
        return super.visitForLoop(flt, a);
    }
    
    @Override
    public Void visitMethod(MethodTree mt, Void a){
        String nb = mt.getName().toString();
        if(!"<init>".equals(nb)){
            //System.out.println("Method: " +mt.getName());
            theStorage.increaseMethodCount();
        }        
        return super.visitMethod(mt, a);
    }
    
    @Override
    public Void visitCase(CaseTree ct, Void a) {
        theStorage.increaseComplexity();
        return super.visitCase(ct, a);
    }
    
    @Override
    public Void visitCatch(CatchTree ct, Void a){
        theStorage.increaseComplexity();
        return super.visitCatch(ct, a);
    }

    @Override
    public Void visitConditionalExpression(ConditionalExpressionTree arg0, Void a) {
        theStorage.increaseComplexity();
        return super.visitConditionalExpression(arg0,a);
    }
    
    @Override
    public Void visitDoWhileLoop(DoWhileLoopTree dwl, Void a) {
        theStorage.increaseComplexity();
        return super.visitDoWhileLoop(dwl, a);
    }
    
    @Override
    public Void visitClass(ClassTree ct, Void a){
        String nb = ct.getSimpleName().toString();
        if(!"".equals(nb)){
        theStorage.increaseClassCount();
        }
        return super.visitClass(ct, a);
    }

    @Override
    public Void visitEnhancedForLoop(EnhancedForLoopTree efl, Void a){
        theStorage.increaseNoOfForLoops();
        return super.visitEnhancedForLoop(efl, a);
    }
    
}
