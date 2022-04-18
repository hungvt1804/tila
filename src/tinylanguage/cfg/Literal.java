/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

/**
 *
 * @author tuan hung
 */
public class Literal extends Expr {
    final Object value;
    public Literal(Object value) {
      this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
    @Override
    <T> T accept(Visitor<T> visitor) {
        return visitor.visitLiteralExpr(this);
    }
}
