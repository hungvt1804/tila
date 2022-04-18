package tinylanguage;

import java.io.File;
import tinylanguage.cfg.AstPrinter;
import tinylanguage.cfg.Binary;
import tinylanguage.cfg.Expr;
import tinylanguage.cfg.Grouping;
import tinylanguage.cfg.Literal;
import static tinylanguage.TinyLanguage.runFile;
import tinylanguage.enums.TokenType;
import tinylanguage.tokens.BaseToken;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tuan hung
 */
public class TestParser {
    public static void main(String[] args) {
        Expr expression = new Binary(
                new Grouping(new Literal(12)),
                new BaseToken(TokenType.STAR, "*", null, 1),
                new Grouping(new Literal(24))
        );
        System.out.println(new AstPrinter().print(expression));
    }
}
