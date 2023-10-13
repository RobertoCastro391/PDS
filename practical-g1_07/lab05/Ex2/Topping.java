package lab05.Ex2;

public class Topping {
    String topping;

    public Topping(String topping) {
        this.topping = topping;
    }

    public String getCream() {
        return topping;
    }

    public void setCream(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return topping;
    }
}