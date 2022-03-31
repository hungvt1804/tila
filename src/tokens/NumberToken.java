/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokens;

import tinylanguage.enums.TokenType;

/**
 *
 * @author Hung
 */
public class NumberToken extends BaseToken implements RegexToken{
    
    public NumberToken(String lexeme, Object literal, int line){
        super(TokenType.NUMBER, lexeme, literal, line);
    }
    public static String regex = "0|[1-9][0-9]*";
}