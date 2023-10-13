package Ex2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList <String> ListOfOrder = new ArrayList<>();
        ListOfOrder.add("veggie burger");
        ListOfOrder.add("Pasta Carbonara");
        ListOfOrder.add("PLAIN pizza, no toppings!");
        ListOfOrder.add("sushi nigiri and sashimi");
        ListOfOrder.add("salad with tuna");
        ListOfOrder.add("strawberry ice cream and waffles dessert");

        Chef foodChef = new SushiChef().setNextChef(
                new PastaChef().setNextChef(
                        new BurgerChef().setNextChef(
                                new PizzaChef().setNextChef(
                                        new DessertChef()))));

        for (String request : ListOfOrder) {
            System.out.println("Can I please get a " + request + "?");
            foodChef.parse(request);
        }
    }

}