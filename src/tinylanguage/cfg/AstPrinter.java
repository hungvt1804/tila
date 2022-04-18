/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

import java.util.List;
import tinylanguage.statements.Assigment;
import tinylanguage.statements.ExpressionStatement;
import tinylanguage.statements.IntDeclare;
import tinylanguage.statements.Print;
import tinylanguage.statements.Program;
import tinylanguage.statements.Statements;
import tinylanguage.statements.Stmt;
import tinylanguage.statements.While;
import tinylanguage.tokens.BaseToken;

/**
 *
 * @author tuan hung
 */
public class AstPrinter implements Visitor<String>,tinylanguage.statements.Visitor<String> {

    public String print(Expr expr) {
        return expr.accept(this);
    }
    public String print(Stmt stmt) {
        return stmt.accept(this);
    }

   

    @Override
    public String visitBinaryExpr(Binary expr) {
        return format(expr.operator.getLexeme(),expr.left,expr.right);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return format("group",expr.expression);
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        if (expr.value == null) {
            return "NULL";
        }
        return expr.value.toString();
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        return expr.name.getLexeme();
    }

    
    private String format(String name, Object... parts) {
        StringBuilder builder = new StringBuilder();

        builder.append("{").append(name);
        transform(builder, parts);
        builder.append("}");

        return builder.toString();
    }



    private void transform(StringBuilder builder, Object... parts) {
        for (Object part : parts) {
            builder.append(" ");
            if (part instanceof Expr) {
                builder.append(((Expr) part).accept(this));
            } else if (part instanceof BaseToken) {
                builder.append(((BaseToken) part).getLexeme());
            }
            else if(part instanceof Stmt){
                builder.append(((Stmt) part).accept(this));
            }
            else if(part instanceof List){
                transform(builder, ((List) part).toArray());
            }
            else {
                builder.append(part);
            }
        }
    }
    
    //Statement
    @Override
    public String visitAssigment(Assigment stmt) {
        return format("=",stmt.name,stmt.value);
    }

    @Override
    public String visitExpressStatement(ExpressionStatement stmt) {
        return format(";", stmt.expr);
    }

    @Override
    public String visitIntDeclare(IntDeclare stmt) {
        if(stmt.initializer == null){
            return format("int", stmt.name);
        }
        return format("int", stmt.name,stmt.initializer);
    }

    @Override
    public String visitPrint(Print stmt) {
        return format("print", stmt.expr);
    }

    @Override
    public String visitProgram(Program stmt) {
        return format("print", stmt.stmts);
    }

    @Override
    public String visitStatements(Statements stmt) {
        return format("print", stmt.statements);
    }

    @Override
    public String visitWhile(While stmt) {
        return format("while", stmt.condition,stmt.body);
    }
}
