/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.tokens;

import tinylanguage.enums.TokenType;

/**
 *
 * @author Hung
 */
public class BaseToken {
    protected TokenType tokenType;

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public TokenType getTokenType() {
        return tokenType;
    }
    protected String lexeme;

    public String getLexeme() {
        return lexeme;
    }
    protected Object literal;

    public Object getLiteral() {
        return literal;
    }

    public int getLine() {
        return line;
    }
    protected int line = 0;
    
    public BaseToken(TokenType tokenType, String lexeme, Object literal, int line){
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Lexeme: %s, Literal: %s, Line: %s",tokenType, lexeme, literal, line);
    }
    public boolean check(){
        return true;
    }
}
