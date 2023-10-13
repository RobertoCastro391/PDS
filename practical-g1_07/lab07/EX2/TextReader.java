package lab07.EX2;
import java.util.*;
import java.io.*;

public class TextReader implements Interface{

    private String fname;
    private int paragrafo = 1;

    public TextReader(String fname){
        this.fname=fname;
    }
    
    public boolean hasNext() {
        try {
            Scanner sc = new Scanner(new File(this.fname) );
            boolean b = false;
            for (int i = 0; i < this.paragrafo ; i++) {
                b = sc.hasNext();
            }
            sc.close(); 
            return b;

        } catch (FileNotFoundException e) {
            System.out.println("[ERROR]: ficheiro não encontrado");
            return false;
        }
    }

    public String next() {
        try {
            Scanner sc = new Scanner( new File(this.fname) );
            String p = "";
            for (int i = 0; i < this.paragrafo; i++) {
                p = sc.nextLine();
            }
            this.paragrafo++;
            sc.close();
            return p;

        } catch (FileNotFoundException e) {
            System.out.println("[ERROR]: ficheiro não encontrado");
            return null;
        }
    }
    
}
