/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.statements;

import java.util.List;

/**
 *
 * @author Hung
 */
public class Statements extends Stmt {
    public final List<Stmt> statements;
    public Statements(List<Stmt> statements){
        this.statements = statements;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\n [[\n");
        for (Stmt item : statements) {
            builder.append("\t").append(item.toString()).append("\n");
        }
        builder.append("\n ]]\n");
        return builder.toString();
    }
    
    
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitStatements(this);
    }
    
}
