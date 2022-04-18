/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

import tinylanguage.cfg.Expr;
import tinylanguage.tokens.BaseToken;

/**
 *
 * @author Hung
 */
public class Assigment extends Stmt{
    public final BaseToken name;
    public final Expr value;
    
    public Assigment(BaseToken name, Expr value) {
      this.name = name;
      this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{%s} - {%s} - {%s}", getClass().getSimpleName(),name.toString(),value);
    }

    
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitAssigment(this);
    }
    
}
