/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

import tinylanguage.cfg.Expr;

/**
 *
 * @author tuan hung
 */
public class ExpressionStatement extends Stmt {

    public final Expr expr;
    public ExpressionStatement(Expr expr){
        this.expr = expr;
    }
    @Override
    public String toString() {
        return String.format("{%s} - {%s}", getClass().getSimpleName(),expr);
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitExpressStatement(this);
    }
    
}
