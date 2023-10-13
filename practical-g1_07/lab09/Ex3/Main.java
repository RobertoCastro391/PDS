package Ex3;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Collection collection = new ArrayList<>();

        Command add = new AddCommand(collection);
        Command remove = new RemoveCommand(collection);

        control.setCommand(add);
        control.execute("Azuleijo");
        control.execute("Tiago");
        control.execute("Esgueira");
        control.execute("Monção");
        control.execute("Beta");
        control.execute("Sardinha");
        control.execute("rugby");

        System.out.println(collection);
        control.undo();
        System.out.println(collection);


        control.setCommand(remove);
        control.execute("Tiago");
        control.execute("Maximo");
        System.out.println(collection);
        control.undo();
        
        control.execute("Pinderica");
        control.undo();

        System.out.println(collection);
    }
}