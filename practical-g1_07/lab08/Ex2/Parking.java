package lab08.Ex2;

import java.util.ArrayList;

public class Parking {
    private static ArrayList<Person> allowedPerson = new ArrayList<Person>();

    public static void allow(Person person) {
        if (allowedPerson.contains(person)) {
            System.out.printf("%s has already access to the parking!\n", person.getName());
        } 
        else {
            allowedPerson.add(person);
            System.out.printf("%s has been given access to the parking!\n", person.getName());
        }
    }
}