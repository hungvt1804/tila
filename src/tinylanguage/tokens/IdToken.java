package tinylanguage.tokens;

import tinylanguage.enums.TokenType;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hung
 */
public class IdToken extends BaseToken implements RegexToken{
    
    public IdToken(String lexeme, Object literal, int line){
        super(TokenType.IDENTIFIER, lexeme, literal, line);
    }
    
    public static String regex = "([a-z]|[A-Z])([a-z]|[A-Z]|[0-9])*";
}
