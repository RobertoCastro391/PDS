package lab05.Ex1;

public class Pork extends PortionFactory {
    Pork(){
        super();
        setTemperature(Temperature.WARM);
        setState(State.Solid);
    }

    @Override
    public String toString(){
        return "Pork: " + "Temperatura " + this.getTemperature() + ", State " + this.getState();
    }
}