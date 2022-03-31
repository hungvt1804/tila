/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tinylanguage.enums.TokenType;
import tokens.BaseToken;
import tokens.TokenProvider;

/**
 *
 * @author Hung
 */
public class Scanner {
    private final String source;
    private final int sourceLength;
    private int start = 0;
    private int current = 0;
    private int currentLine = 1;
    private final List<Object> whiteSpaces = Arrays.asList(' ','\t','\r');
    private final List<BaseToken> tokens = new ArrayList<>();
    public Scanner(String source){
        this.source = source;
        this.sourceLength = source.length();
    }
   
    public List<BaseToken> scanTokens(){
        while(!isEndSource()){
            start = current;
            scanToken();
        }
        addTokenEOF();
        return tokens;
    }
    private void scanToken(){
        char currentChar = currentChar();
        if(isNewLine(currentChar)){
            currentLine ++;
        }
        if(!isWhiteSpace(currentChar)){
            String text = String.valueOf(currentChar);
            BaseToken token = TokenProvider.getToken(text, text, currentLine);
            if(token == null){
                text = getCurrentString(currentChar);
                token = TokenProvider.getToken(text, text, currentLine,true);
            }
            
            if(token!=null){
                tokens.add(token);
            }
        }
    }
    private String getCurrentString(char c){
        if(isEndCommand(c)) return String.valueOf(c);
        StringBuilder result = new StringBuilder();
        while (!isWhiteSpace(c) && !isNewLine(c) && !isEndCommand(c)) {            
            result.append(c);
            if(isEndSource()) break;
            c = currentChar();
        }
        if(result.length()>0 && isEndCommand(c)){
            current--;
        }
        return result.toString();
    }
    private void addTokenEOF(){
        tokens.add(new BaseToken(TokenType.EOF, null, null, currentLine));
    }
    private boolean isWhiteSpace(char c){
        return whiteSpaces.contains(c);
    }
    private boolean isNewLine(char c){
        return c == '\n';
    }
    private boolean isEndCommand(char c){
        return TokenType.isBreakCharacter(String.valueOf(c));
    }
    private char currentChar(){
        return source.charAt(current++);
    }
    private boolean  isEndSource(){
        return current>=sourceLength;
    }

    public void print(){
        this.scanTokens();
        StringBuilder result = new StringBuilder();
        for (BaseToken token : this.tokens) {
            result.append(token.toString()).append("\n");
        }
        System.out.println(result.toString());
    }
    
}
