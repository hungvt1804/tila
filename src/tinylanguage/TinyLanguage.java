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
import tinylanguage.tokens.IdToken;

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
            // TODO code application logic here
            args = new String[1];
            args[0] = "E:\\Work\\Java\\tinylanguage\\example\\ex1.tila";
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

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static String getContentSource(String path)throws IOException, Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new String(bytes);
    }
    public static void runFile(String path) throws IOException, Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes));
    }

    public static void run(String source) throws Exception {
        Scanner scanner = new Scanner(source);
        scanner.print();
    }
    

}
