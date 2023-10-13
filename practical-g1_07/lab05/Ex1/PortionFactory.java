package lab05.Ex1;

public class PortionFactory implements Portion {
    
    private State state;
    private Temperature temp;

    public State getState(){
        return this.state;
    }

    public Temperature getTemperature(){
        return this.temp;
    }

    public void setTemperature(Temperature t){
        this.temp = t;
    }
    
    public void setState(State state){
        this.state = state;
    }

    public String toString(){
        return "";
    }

    public static Portion create(String nome, Temperature t) {

        if (nome == "Beverage" && t == Temperature.COLD)
            return new FruitJuice("Orange");
        else if (nome == "Beverage" && t == Temperature.WARM)
            return new Milk();
        else if (nome == "Meat" && t == Temperature.COLD)
            return new Tuna();
        else if (nome == "Meat" && t == Temperature.WARM)
            return new Pork();
        else{
            System.out.println("Error: Invalid Portion");
            System.exit(1);
        }
        return null;
    }
}