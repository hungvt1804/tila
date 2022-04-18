/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

/**
 *
 * @author tuan hung
 * @param <T>
 */
public interface Visitor<T> {
    T visitBinaryExpr(Binary expr);
    T visitGroupingExpr(Grouping expr);
    T visitLiteralExpr(Literal expr);
    T visitVariableExpr(Variable expr);
  
}
