package Ex2;
import java.util.Random;

public class PizzaChef extends Chef {

    @Override
    public void parse(String order) {
        if (canDoMeal(order, "pizza")) {
            System.out.printf("PizzaChef: Starting to cook %s. Out in %d minutes!\n", order, this.Time());
        }
        else {
            System.out.println("PizzaChef: I can't cook that!");
            super.parse(order);
        }
    }

    private Integer Time() {
        Random rand = new Random();
        return rand.nextInt(20);
    }
}