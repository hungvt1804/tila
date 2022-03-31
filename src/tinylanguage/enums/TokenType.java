/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.enums;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hung
 */
public enum TokenType {
    //Single Character token
    BEGIN("begin"),
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    MINUS("-"),
    PLUS("+"),
    SEMICOLON(";"),
    SLASH("/"),
    STAR("*"),
    POW("^"),
    EQUAL("="),
    LARGER(">"),
    LESS("<"),
    //
    IDENTIFIER("ID"), NUMBER("NUMBER"),
    IF("if"),
    THEN("then"),
    ELSE("else"),
    END("end"),
    WHILE("while"),
    DO("do"),
    EOF("eof"),
    
    INT("int");

    //Keywords
    private final String value;

    private TokenType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

  

    public static TokenType find(String value) {
        value = value.toLowerCase();
        for (TokenType v : values()) {
            if (v.getValue().equals(value)) {
                return v;
            }
        }
        return null;
    }

    public static boolean isBreakCharacter(String c){
        List<String> breaks=  Arrays.asList(
                LEFT_PAREN.getValue(), RIGHT_PAREN.getValue(),
                MINUS.getValue(),PLUS.getValue(),SEMICOLON.getValue(),
                SLASH.getValue(),STAR.getValue(),
                POW.getValue(),
                
                EQUAL.getValue(),
                LARGER.getValue(),
                LESS.getValue()
        );
        return breaks.contains(c);
    }
}
