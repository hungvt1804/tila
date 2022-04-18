/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.cfg;

import tinylanguage.enums.TokenType;
import tinylanguage.exceptions.RuntimeError;
import tinylanguage.tokens.BaseToken;

/**
 *
 * @author tuan hung
 */
public class Interpreter implements Visitor<Object> {

    public String interpret(Expr expression) {
        return evaluate(expression).toString();
    }

 
    @Override
    public Object visitBinaryExpr(Binary expr) {
        Object left = evaluate(expr.left);
        Object right = evaluate(expr.right);
        TokenType type = expr.operator.getTokenType();
        checkNumberOperand(expr.operator, left, right);
        switch (type) {
            case MINUS -> {
                return (int) left - (int) right;
            }
            case STAR -> {
                return (int) left * (int) right;
            }
            case POW -> {
                return (int) left ^ (int) right;
            }
        }

        return null;
    }

    @Override
    public Object visitGroupingExpr(Grouping expr) {
        return evaluate(expr.expression);
    }

    @Override
    public Object visitLiteralExpr(Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitVariableExpr(Variable expr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    private void checkNumberOperand(BaseToken operator, Object... operands) {
        for (Object operand : operands) {
            if (!(operand instanceof Integer)) {
                throw new RuntimeError(operator, "Operand must be a number.");
            }
        }
    }
}
