/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

/**
 *
 * @author tuan hung
 */
public abstract class Stmt {
    public abstract <T> T accept(Visitor<T> visitor);
}
