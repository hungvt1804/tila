/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tinylanguage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import tinylanguage.cfg.AstPrinter;
import tinylanguage.cfg.Expr;
import tinylanguage.cfg.Interpreter;
import tinylanguage.parser.Parser;
import tinylanguage.statements.Program;
import tinylanguage.statements.Stmt;
import tinylanguage.tokens.BaseToken;

/**
 *
 * @author tuan hung
 */
public class Main {

    private static Interpreter interpreter = new Interpreter();

    public static void main(String[] args) {
        try {
//            args = new String[1];
//            args[0] = "E:\\Work\\Java\\TinyLanguage\\example\\full.tila";
            String path = "";
            if (args.length == 1) {
                path = args[0];
            } else if (args.length == 0) {
                path = readInput();
            } else {
                System.out.println("TinyLanguager Compiler has 0 or 1 parameter!");
            }

            exec(path);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void exec(String path) throws Exception {
        File f = new File(path);
        if (f.exists() && path.endsWith("tila")) {
            String source = TinyLanguage.getContentSource(path);
            System.out.println("Ma nguon chuong trinh:\n");
            System.out.println(source);
            System.out.println("--------------------------------------\n");
            Scanner scanner = new Scanner(source);
            List<BaseToken> tokens = scanner.scanTokens();
            Parser parser = new Parser(tokens);
//                    Expr expr =  parser.parse();
//                    System.out.println(new AstPrinter().print(expr));
//                    String result = interpreter.interpret(expr);
//                    System.out.println(result);
            Stmt s = parser.parse();
//            if (s instanceof Program) {
//                ((Program) s).print();
//            }
            System.out.println(new AstPrinter().print(s));
        } else {
            System.out.println("File input must be *.tila");
        }
    }
    static HashMap<Integer, String> mapFiles = new HashMap<>();

    private static String readInput() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap duong dan file hoac thu muc:\n");
        String path = sc.next();
        if ("1".equals(path)) {
            path = "D:\\Work\\Java\\TinyLanguage\\example";
        }
        File f = new File(path);
        if (f.isFile()) {
            return path;
        } else if (f.isDirectory()) {
            listFilesForFolder(f);
            System.out.print("----\n");
            System.out.print("Chon file ma nguon:\n");
            int sub = sc.nextInt();
            String fullFile = path + "\\" + mapFiles.get(sub);
            return fullFile;
        }
        return null;
    }

    public static void listFilesForFolder(final File folder) {
        int index = 0;
        System.out.print("Danh sach cac file ma nguon:\n");
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.getName().startsWith("tc")) {
                index++;
                mapFiles.put(index, fileEntry.getName());
                System.out.println(index + "." + fileEntry.getName());
            }

        }
    }
}
