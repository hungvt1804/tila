package tinylanguage.tokens;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;
import tinylanguage.enums.TokenType;
import tinylanguage.tokens.BaseToken;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Hung
 */
public class TokenProvider {

    public static BaseToken getToken(String charToken, String text, int line, boolean isFull) {
        TokenType type = null;
        if (charToken.length() == 0) {
            return null;
        }
        type = TokenType.find(charToken);
        if (type != null) {
            return new BaseToken(type, text, null, line);
        } else {
            if (isFull) {
                if (text.matches(IdToken.regex)) {
                    return new IdToken(text, null, line);
                } else if (text.matches(NumberToken.regex)) {
                    return new NumberToken(text, Integer.parseInt(text), line);
                }
            }

        }
        return null;
    }

    public static BaseToken getToken(String charToken, String text, int line) {
        return getToken(charToken, text, line, false);
    }
}
