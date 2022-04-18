package tinylanguage.exceptions;

import tinylanguage.tokens.BaseToken;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tuan hung
 */
public class ParseException extends RuntimeException {

    private BaseToken token;
    private String message;

    public ParseException(BaseToken token) {
        this.token = token;
    }

    public ParseException(String message) {
        this.message = message;
    }

    public ParseException(BaseToken token, String message) {
        this.token = token;
        this.message = message;
    }

    @Override
    public String getMessage() {
        String m = message != null ? this.message : "";
        if (token == null) {
            return m;
        }
        StringBuilder builder = new StringBuilder("Error ");
        if(m!=null){
            builder.append(m);
        }
        if(token.getLexeme()!=null){
            builder.append(" near \"").append(token.getLexeme()).append("\" ");
        }
        builder.append(" at line ").append(token.getLine());
        return builder.toString();
    }

}
