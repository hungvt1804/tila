/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.parser;

import java.util.ArrayList;
import tinylanguage.cfg.Binary;
import tinylanguage.cfg.Expr;
import tinylanguage.cfg.Grouping;
import tinylanguage.cfg.Literal;
import java.util.List;
import tinylanguage.cfg.Variable;
import tinylanguage.exceptions.ParseException;
import tinylanguage.enums.TokenType;
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
public class Parser {

    private final List<BaseToken> tokens;
    private int current = 0;

    public Parser(List<BaseToken> tokens) {
        this.tokens = tokens;
    }

    public Stmt parse() {
        //return expression();
        return program();
    }

    /*Statements*/
    private Stmt program() {
        if (match(TokenType.BEGIN)) {
            Statements stmts = statements();
            consume(TokenType.END, "Program must be start with BEGIN and end with END and EOF");
            if(!isAtEnd()){
                throw new ParseException("Program must be start with BEGIN and end with END and EOF");
            }
            return new Program(stmts);
        }
        throw new ParseException("Program must be start with BEGIN and end with END and EOF");
    }

    private Statements statements() {
        List<Stmt> statements = new ArrayList<>();
        while (!isAtEnd()) {            
            Stmt stmt = statement();
            if(stmt == null) break;
            consume(TokenType.SEMICOLON, "Statement must be end with SEMICOLON");    
            statements.add(stmt);
        }
        
        return new Statements(statements);
    }

    private Stmt statement() {
        if (match(TokenType.INT)) {
            return intDeclare();
        }
        if (match(TokenType.PRINT)) {
            return printStatement();
        }
        if (match(TokenType.IDENTIFIER)) {
            return assigment();
        }
        if (match(TokenType.WHILE)) {
            return loop();
        }
        if (match(TokenType.END)) {
            current--;
            return null;
        }
        return expressionStatement();

    }

    private void synchronize() {
        advance();

        while (!isAtEnd()) {
            if (previous().getTokenType() == TokenType.SEMICOLON) {
                return;
            }
            advance();
        }
    }

    private Stmt printStatement() {
        Expr expr = expression();
        return new Print(expr);
    }

    private Stmt intDeclare() {
        BaseToken name = consume(TokenType.IDENTIFIER, "Expect variable name");
        Expr initializer = null;
        if (match(TokenType.EQUAL)) {
            initializer = expression();
        }
        return new IntDeclare(name, initializer);
    }

    private Stmt expressionStatement() {
        Expr expr = expression();
        return new ExpressionStatement(expr);
    }

    private Stmt assigment() {
        BaseToken name = previous();
        Expr initializer = null;
        if (match(TokenType.EQUAL)) {
            initializer = expression();
            return new Assigment(name, initializer);
        }
        throw new ParseException(name, "Assigment must have value!");
    }

    private Stmt loop() {

        Expr condition = expression();
        consume(TokenType.DO, "Expect DO keyword after condition");
        consume(TokenType.BEGIN, "Expect BEIGN keyword after DO keyword");
        Stmt body = statements();
        consume(TokenType.END, "While loop need END keyword");

        return new While(condition, body);
    }

    /*Expr*/
    private Expr expression() {
        return term();
    }

    private Expr term() {
        //term -> multiply ( ( - ) multiply )*
        Expr expr = multiply();
        while (match(TokenType.MINUS)) {
            BaseToken operator = previous();
            Expr right = multiply();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr multiply() {
//        multiply -> pow ( ( * ) pow )*

        Expr expr = pow();
        while (match(TokenType.STAR)) {
            BaseToken operator = previous();
            Expr right = pow();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr pow() {
        //pow -> extra ( ( ^ ) extra )+
        Expr expr = extra();
        while (match(TokenType.POW)) {
            BaseToken operator = previous();
            Expr right = extra();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr extra() {
        return primary();
    }

    private Expr primary() {
        if (isAtEnd()) {
            return null;
        }
        if (match(TokenType.NUMBER)) {
            return new Literal(previous().getLiteral());
        }
        if (match(TokenType.LEFT_PAREN)) {
            Expr expr = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
            return new Grouping(expr);
        }
        if(match(TokenType.IDENTIFIER)){
            return new Variable(previous());
        }
        throw new ParseException("No expression found");
    }

    private void consume(String message, TokenType... types) {
        int count = 0;
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                count++;
            }
        }
        if (count != types.length) {
            throw new ParseException(peek(), message);
        }
    }

    private BaseToken consume(TokenType type, String message) {
        if (check(type)) {
            return advance();
        }
        throw new ParseException(peek(), message);
    }

    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }
        return false;
    }

    private BaseToken advance() {
        if (!isAtEnd()) {
            current++;
        }
        return previous();
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) {
            return false;
        }
        return peek().getTokenType() == type;
    }

    private boolean isAtEnd() {
        return peek().getTokenType() == TokenType.EOF;
    }

    private BaseToken peek() {
        return tokens.get(current);
    }

    private BaseToken previous() {
        return tokens.get(current - 1);
    }
}
