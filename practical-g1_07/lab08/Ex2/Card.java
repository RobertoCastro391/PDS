package lab08.Ex2;

import java.util.HashMap;

public class Card {
    private static HashMap<Person, Integer> listPerson = new HashMap<Person, Integer>();
    private static int cardNum = 0;

    public static void regist(Person p) {
        if (listPerson.containsKey(p)) {
            System.out.printf("%s have alredy an employee card with number: %s!\n", p.getName(), listPerson.get(p));
        }
        else {
            listPerson.put(p, ++cardNum);
            System.out.printf("%s has been given an employee card with number: %s!\n", p.getName(), listPerson.get(p));
        }
    }
    
    public HashMap<Person, Integer> getListPerson() {
        return listPerson;
    }
}