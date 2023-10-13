package lab06.EX2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactsFileCSV implements ContactsStorageInterface {
    public List<Contact> loadContacts() {
        
        List<Contact> ContactsList = new ArrayList<>();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("lab06/EX2/contactsList.csv"));
            String linha;
            while ((linha = fileReader.readLine()) != null) {

                String[] contactInfo = linha.split(";");
                ContactsList.add(new Contact(contactInfo[0],Integer.valueOf(contactInfo[1])));
            }
            fileReader.close();
            
        } catch (IOException e) {
            System.err.println("File not found...");
            System.exit(0);
        }
        System.out.println("Contactos adicionados com sucesso!");
        return ContactsList;
    }

    public boolean saveContacts(List<Contact> list) {

        try {
            File file = new File("lab06/EX2/contactsSaved.csv");
            FileWriter fw = new FileWriter(file);

            if (list == null) {
                fw.close();
                System.out.println("Lista de contactos vazia...");
                return false;
            }

            fw.write("------------ LISTA DE CONTACTOS ------------");
            for(Contact contact: list) {
                fw.write(contact.getName() + ";" + contact.getNumber());
                fw.write("\n");
            }
            fw.write("------------ FIM DA LISTA DE CONTACTOS ------------");
            fw.close();
            

        } catch (IOException e) {
            System.err.println("Erro " + e.toString());
            return false;
        }
        System.out.println("Lista de contactos guardada com sucesso!");
        return true;
    }
    
}
