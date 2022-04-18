/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

/**
 *
 * @author tuan hung
 */
public class Grouping extends Expr{
    final Expr expression;
    public Grouping(Expr expression) {
      this.expression = expression;
    }
    @Override
    public String toString() {
        return expression.toString();
    }
    @Override
    <T> T accept(Visitor<T> visitor) {
        return visitor.visitGroupingExpr(this);
    }
}
