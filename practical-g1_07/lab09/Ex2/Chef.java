package Ex2;

public abstract class Chef {

    private Chef nextChef = null;

    public void parse (String order) {
        if (nextChef != null) {
            nextChef.parse(order);
        } else {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }
    
    protected boolean canDoMeal (String order, String foodType) {
        return (order == null) || (order.toLowerCase().contains(foodType.toLowerCase()));
    }

    public Chef setNextChef(Chef nextChef) {
        this.nextChef = nextChef;
        return this;
    }
}