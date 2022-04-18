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
public class While extends Stmt{
    public final Expr condition;
    public final Stmt body;
    public While(Expr condition, Stmt body){
        this.condition = condition;
        this.body =body;
    }
    @Override
    public String toString() {
        return String.format("{%s} - {%s} - {%s}", getClass().getSimpleName(),condition,body);
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitWhile(this);
    }
    
}
