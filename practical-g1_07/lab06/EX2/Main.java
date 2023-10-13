package lab06.EX2;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--------TESTE COM FICHEIRO TXT-------");

        ContactsStorageInterface storageTxt = new ContactsFileTXT();
        ManageContactList manageContactListTXT = new ManageContactList(storageTxt);
 
        manageContactListTXT.openAndLoad(storageTxt);
        manageContactListTXT.printContactsList();

        Contact contato1 = new Contact("João Luis", 377347643);
        Contact contato2 = new Contact("Diana Miranda", 934794373);
        manageContactListTXT.add(contato1);
        manageContactListTXT.add(new Contact("Marta Inácio",7363636));
        System.out.println("Contacto: "+ manageContactListTXT.getByName("Marta Inácio"));
        System.out.println("Contacto: "+ manageContactListTXT.getByName("Daniela"));
        System.out.println("Maria existe na lista de contactos? " + manageContactListTXT.exist(contato2));
        manageContactListTXT.printContactsList();
        manageContactListTXT.remove(manageContactListTXT.getByName("Marta"));
        manageContactListTXT.printContactsList();
        manageContactListTXT.saveAndClose(storageTxt);

        System.out.println("-------------------------------\n");

        System.out.println("--------TESTE COM FICHEIRO CSV-------");

        ContactsStorageInterface storageCSV = new ContactsFileCSV();
        ManageContactList manageContactListCSV = new ManageContactList(storageCSV);
 
        manageContactListCSV.openAndLoad(storageCSV);
        manageContactListCSV.printContactsList();

        Contact contato3 = new Contact("Rafaela", 123456789);
        Contact contato4 = new Contact("Sara", 987654321);
        manageContactListCSV.add(contato3);
        manageContactListCSV.add(new Contact("Fabio Dias",64559876));
        System.out.println("Contacto: "+ manageContactListCSV.getByName("Fabio Dias"));
        System.out.println("Contacto: "+ manageContactListCSV.getByName("Maria"));
        System.out.println("Maria existe na lista de contactos? " + manageContactListCSV.exist(contato4));
        manageContactListCSV.printContactsList();
        manageContactListCSV.remove(manageContactListCSV.getByName("Filipe"));
        manageContactListCSV.printContactsList();
        manageContactListCSV.saveAndClose(storageCSV);

        System.out.println("-------------------------------\n");

    }
}
