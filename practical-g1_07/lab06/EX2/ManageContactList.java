package lab06.EX2;

import java.util.ArrayList;
import java.util.List;

public class ManageContactList implements ContactsInterface {
    
    private ContactsStorageInterface contacts;
    private List<Contact> ContactsList;

    public ManageContactList(ContactsStorageInterface contacts) {
        this.contacts = contacts;
        ContactsList = new ArrayList<Contact>();
    }

    public void openAndLoad(ContactsStorageInterface store) {
        this.contacts = store;
        ContactsList = store.loadContacts();
    }

    public void saveAndClose(){
        this.contacts.saveContacts(ContactsList);

    }

    public void saveAndClose(ContactsStorageInterface store){
        store.saveContacts(ContactsList);

    }

    public boolean exist(Contact contact){
        for (Contact contactInLits: ContactsList) {
            if (contactInLits.equals(contact)) {
                return true;
            }
        }
        return false;
    }

    public Contact getByName(String name){
        for (Contact contactInLits: ContactsList) {
            if (contactInLits.getName().equals(name)) {
                return contactInLits;
            }
        }
        System.out.printf("O contacto com o nome %s não foi encontrado...\n", name);
        return null;
    }

    public boolean add(Contact contact){
        
        if (!exist(contact)) {
            System.out.printf("Contacto com o nome: %s adicionado com sucesso...\n", contact.getName());
            ContactsList.add(contact);
            return true;
        }
        else {
            System.out.printf("Contacto com o nome: %s já na lista de contactos...\n",contact.getName());
            return false;
        }
    }

    public boolean remove(Contact contact){
        if (exist(contact)) {
            System.out.printf("Contacto com o nome: %s removido com sucesso...\n",contact.getName());
            ContactsList.remove(contact);
            return true;
        }
        else {
            System.out.println("Contacto com o nome não encontrado na lista de contactos...");
            return false;
        }
    }

    public void printContactsList() {
        if (ContactsList == null) {
            System.out.println("Lista de Contactos vazia...");
            return;
        }

        System.out.println("------------ LISTA DE CONTACTOS ------------");
        for (Contact contact: ContactsList) {
            System.out.println(contact);
        }
        System.out.println("------------ FIM DA LISTA DE CONTACTOS ------------");

    }
}
