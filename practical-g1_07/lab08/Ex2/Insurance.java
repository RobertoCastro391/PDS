package lab08.Ex2;

import java.util.HashMap;

public class Insurance {
    private static HashMap<Person, Integer> listPerson = new HashMap<Person, Integer>();
    private static int InsuranceNum = 0;

    public static void regist(Person p) {
        if (listPerson.containsKey(p)) {
            System.out.printf("%s is already registed at the Insurance with number: %d !\n", p.getName(), listPerson.get(p));
        }
        else {
            listPerson.put(p, ++InsuranceNum);
            System.out.printf("%s has been registed at the Insurance with number: %d !\n", p.getName(), listPerson.get(p));
        }
    }
}
