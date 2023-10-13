package lab07.Ex3;

public class Bebida extends Produto{

    private String name;
    private Double weight;

    Bebida(String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
    }

    public String getName(){
        return this.name;
    }

    public void draw() {
        System.out.println("Bebida '" + getName() + "' - Weight: " + getTotalWeight());
    }

    public Double getTotalWeight() {
        return this.weight;
    }

} 