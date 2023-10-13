package lab07.Ex3;

public class Doce extends Produto{

    private String name;
    private Double weight;

    Doce (String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
    }

    public String getName(){
        return this.name;
    }

    public void draw() {
        System.out.println("Doce '" + getName() + "' - Weight: " + getTotalWeight());
    }

    public Double getTotalWeight() {
        return this.weight;
    }

} 