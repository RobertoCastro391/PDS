package lab08.Ex2;

import java.util.HashMap;

public class SocialSecurity {
    private static HashMap<Person, Integer> listPerson = new HashMap<Person, Integer>();
    private static int socialSecurityNum = 0;

    public static void regist(Person p) {
        if (listPerson.containsKey(p)) {
            System.out.printf("%s is already registed in Social Security with number: %d !\n", p.getName(), listPerson.get(p));
        }
        else {
            listPerson.put(p, ++socialSecurityNum);
            System.out.printf("%s has been registed in Social Security with number: %d !\n", p.getName(), listPerson.get(p));
        }
    }
}