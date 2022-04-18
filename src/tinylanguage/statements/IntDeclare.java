/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

import tinylanguage.cfg.Expr;
import tinylanguage.tokens.BaseToken;

/**
 *
 * @author tuan hung
 */
public class IntDeclare extends Stmt {
    public final BaseToken name;
    public final Expr initializer;
    public IntDeclare(BaseToken name, Expr initializer) {
      this.name = name;
      this.initializer = initializer;
    }
    @Override
    public String toString() {
        return String.format("{%s} - {%s} - {%s}", getClass().getSimpleName(),name.toString(),initializer);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitIntDeclare(this);
    }
}
