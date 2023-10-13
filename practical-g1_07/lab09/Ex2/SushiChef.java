package Ex2;
import java.util.Random;

public class SushiChef extends Chef {

    @Override
    public void parse(String order) {
        if (canDoMeal(order, "sushi")) {
            System.out.printf("SushiChef: Starting to cook %s. Out in %d minutes!\n", order, this.Time());
        }
        else {
            System.out.println("SushiChef: I can't cook that!");
            super.parse(order);
        }
    }

    private Integer Time() {
        Random rand = new Random();
        return rand.nextInt(20);
    }
}