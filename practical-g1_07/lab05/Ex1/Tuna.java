package lab05.Ex1;

public class Tuna extends PortionFactory {
    Tuna(){
        super();
        setTemperature(Temperature.COLD);
        setState(State.Solid);
    }

    @Override
    public String toString(){
        return "Tuna: " + "Temperatura " + this.getTemperature() + ", State " + this.getState();
    }
}