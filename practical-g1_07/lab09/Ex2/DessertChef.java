package Ex2;
import java.util.Random;

public class DessertChef extends Chef {

    @Override
    public void parse(String order) {
        if (canDoMeal(order, "dessert")) {
            System.out.printf("DessertChef: Starting to cook %s. Out in %d minutes!\n", order, this.Time());
        }
        else {
            System.out.println("DessertChef: I can't cook that!");
            super.parse(order);
        }
    }

    private Integer Time() {
        Random rand = new Random();
        return rand.nextInt(20);
    }
}