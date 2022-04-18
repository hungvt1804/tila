/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage.exceptions;

import tinylanguage.tokens.BaseToken;

/**
 *
 * @author tuan hung
 */
public class RuntimeError extends RuntimeException {

    final BaseToken token;

    public RuntimeError(BaseToken token, String message) {
        super(message);
        this.token = token;
    }
}
