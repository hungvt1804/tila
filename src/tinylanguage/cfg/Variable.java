/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

import tinylanguage.tokens.BaseToken;

/**
 *
 * @author tuan hung
 */
public class Variable extends Expr {
    final BaseToken name;
    public Variable(BaseToken name) {
      this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
    
    
    @Override
    <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariableExpr(this);
    }
}
