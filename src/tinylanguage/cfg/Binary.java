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
public class Binary extends Expr {
    final Expr left;
    final BaseToken operator;
    final Expr right;
    public Binary(Expr left, BaseToken operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }
    @Override
    public String toString() {
        return String.format("Class <%s> - <%s> - <%s> - <%s>", getClass(),left.toString(),operator,right);
    }
    @Override
    <T> T accept(Visitor<T> visitor) {
        return visitor.visitBinaryExpr(this);
    }
}
