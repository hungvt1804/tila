/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

import java.util.List;

/**
 *
 * @author tuan hung
 */
public class Program extends Stmt{
    public final Statements stmts;
    public Program(Statements stmts){
        this.stmts = stmts;
    }
    public void print(){
        List<Stmt> items = this.stmts.statements;
        for (Stmt item : items) {
            System.out.println(item.toString());
        }
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitProgram(this);
    }
    
}
