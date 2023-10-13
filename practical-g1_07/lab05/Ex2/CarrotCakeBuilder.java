package lab05.Ex2;

public class CarrotCakeBuilder implements CakeBuilder {
    Cake chocolateCake;

    public void setCakeShape(Shape shape) {
        chocolateCake.setShape(shape);
    }

    public void addCakeLayer() {
        chocolateCake.addCakeLayer();
    }
 
    public void addCreamLayer() {
        Cream cream = new Cream("Carrots");
        chocolateCake.setMidLayerCream(cream);
    }

    public void addTopLayer() {
        Cream cream = new Cream("Chocolate");
        chocolateCake.setTopLayerCream(cream);
    }

    public void addTopping() {
        Topping topping = new Topping("Fruit");
        chocolateCake.setTopping(topping);
    }

    public void addMessage(String m) {
        chocolateCake.setMessage(m);
    }


    public void createCake() {
        chocolateCake = new Cake("Carrots");
    }

    public Cake getCake() {
        return chocolateCake;
    }
}
