package lab01.WSSolver;
import java.util.*;
import java.io.*;

public class ReadData {
    
    String filename;
    static String word;
    static ArrayList<String> ws = new ArrayList<String>();
    static ArrayList<String> wordsToFind = new ArrayList<String>();
    
    public static void read(String filename) throws FileNotFoundException {         //function to read the file
        
        try {
            Scanner scanner = new Scanner(new FileReader("lab01/WSSolver/" + filename)).useDelimiter("\n|\\s|,|;");
            while (scanner.hasNext()) {
                
                word = scanner.next();
                boolean upCase = true;
                boolean valid = true;
                
                if (word == null || word.isEmpty()) {                               //verifies if there is an empty line in the file
                    System.err.println("ERRO: there is an empty line in the file!");
                    System.exit(0);
                }
 
                for (int a = 0; a < word.length(); a++) {
                    Character character = word.charAt(a);
                    
                    if(((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z'))) {    //verifies if the characters in the soup/word are valid
                        if (!Character.isUpperCase(character)) {
                            upCase = false;                                                                     //verifies if the word is in uppercase
                        } 
                    }
                    else {
                        valid = false;
                    }
                }

                if (upCase == true){
                    if (valid == false) {
                        System.err.println("ERROR: There is a character in the soup which is not an alfabetic character!");
                        System.exit(0);
                    }
                    ws.add(word); 
                } 
                else if (upCase == false) {
                    if (valid == false) {
                        System.err.printf("ERROR: Word: %s is not valid and will not be add to the words to find! It must only include alfabetic characters\n",word);
                        continue;
                    }
                    wordsToFind.add(word);
                }
            }
            scanner.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("ERROR: file not found!");
            System.exit(0);
        }  
    }

    public static ArrayList<String> getWs() {
        return ws;
    }

    public static ArrayList<String> getWordsToFind() {
        return wordsToFind;
    }
}