package Ex2;
import java.util.Random;

public class PastaChef extends Chef {

    @Override
    public void parse(String order) {
        if (canDoMeal(order, "pasta")) {
            System.out.printf("PastaChef: Starting to cook %s. Out in %d minutes!\n", order, this.Time());
        }
        else {
            System.out.println("PastaChef: I can't cook that!");
            super.parse(order);
        }
    }

    private Integer Time() {
        Random rand = new Random();
        return rand.nextInt(20);
    }
}