package lab07.Ex3;
import java.util.*;

public class Caixa extends Produto{

    private String name;
    private Double weight;
    private ArrayList<Produto> produtos;
    static int count = 0;

    public Caixa(String name, int weight){
        this.name = name;
        this.weight = Double.valueOf(weight);
        this.produtos = new ArrayList<Produto>();
    }

    public void add(Produto produto){
        this.produtos.add(produto);
    }
    
    public String getName() {
        return name;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Double getWeight() {
        return weight;
    }

    public void draw(){

        System.out.println("* Caixa '" + getName() + "' [Weight: " + getWeight() + " ; Total: " + this.getTotalWeight() + "]");
        count++;
        for(Produto produto : this.produtos){
            for(int i = 0; i < count; i++){
                System.out.print("  ");
            }
            produto.draw();
        }
        count--;
    }

    public Double getTotalWeight() {
        Double totalWeight = this.weight;
        for (Produto produto : produtos) {
            totalWeight += produto.getTotalWeight();
        }
        return totalWeight;
    }
    

    

    
} 