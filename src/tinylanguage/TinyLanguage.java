/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tinylanguage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import tinylanguage.enums.TokenType;
import tokens.IdToken;

/**
 *
 * @author Hung
 */
public class TinyLanguage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            args = new String[1];
            args[0] = "E:\\Work\\Java\\tinylanguage\\example.tila";
            // TODO code application logic here
            if (args.length == 1) {
                String file = args[0];
                File f = new File(file);
                if(f.exists() && file.endsWith("tila")){
                    runFile(file);
                }
                else{
                    System.out.println("File input must be *.tila");
                }
            } else {
                System.out.println("Wrong parameter, please input *.tila");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes));
    }

    public static void run(String source) {
        Scanner scanner = new Scanner(source);
        scanner.print();
    }

}
