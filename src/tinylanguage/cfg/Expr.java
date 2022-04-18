/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

/**
 *
 * @author tuan hung
 */
public abstract class Expr {
    abstract <T> T accept(Visitor<T> visitor);
}
