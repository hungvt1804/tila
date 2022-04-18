/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

/**
 *
 * @author tuan hung
 */
public interface Visitor<T> {
    T visitAssigment(Assigment stmt);
    T visitExpressStatement(ExpressionStatement stmt);
    T visitIntDeclare(IntDeclare stmt);
    T visitPrint(Print stmt);
    T visitProgram(Program stmt);
    T visitStatements(Statements stmt);
    T visitWhile(While stmt);

}
