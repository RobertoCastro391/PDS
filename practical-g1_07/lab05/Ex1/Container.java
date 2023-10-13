package lab05.Ex1;

public class Container{

    private Portion portion;

    public Container(Portion portion){
        setPortion(portion);
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }

    public Portion getPortion() {
        return portion;
    }

    public static Container create(Portion menu) {

        if (menu.getTemperature() == Temperature.COLD && menu.getState() == State.Solid) {
            return new PlasticBag(menu);
        }
        else if (menu.getTemperature() == Temperature.COLD && menu.getState() == State.Liquid) {
            return new PlasticBottle(menu);
        }
        else if ((menu.getTemperature() == Temperature.WARM || menu.getTemperature() == Temperature.COLD) && menu.getState() == State.Solid) {
            return new Tupperware(menu);
        }
        else if ((menu.getTemperature() == Temperature.WARM || menu.getTemperature() == Temperature.COLD) && menu.getState() == State.Liquid) {
            return new TermicBottle(menu);
        }
        else {
            System.out.println("Error: Invalid Portion");
            System.exit(1);
        }
        return null;
    }


}