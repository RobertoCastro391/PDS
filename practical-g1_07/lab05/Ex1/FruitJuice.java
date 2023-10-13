package lab05.Ex1;

public class FruitJuice extends PortionFactory {
    
    String outros;

    public FruitJuice(String outros) {
        super();
        setTemperature(Temperature.COLD);
        setState(State.Liquid);
        this.outros = outros;
    }
        
    @Override
    public String toString() {
        return "FruitJuice: " + this.outros + ", Temperature " + getTemperature() + ", State " + getState();
    }
}