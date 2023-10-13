package Ex3;

public class Flight implements Command {
    private ATCMediator atcMediator;
    private String flightNumb;

    public Flight(ATCMediator atcMediator, String flightNumb) {
        this.atcMediator = atcMediator;
        this.flightNumb = flightNumb;
    }

    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println(this.flightNumb + " landed successfully!");
            atcMediator.setLandingStatus(true);
        } else
            System.out.println(this.flightNumb + " is waiting for landing.");
    }

    public void getReady() {
        System.out.println(this.flightNumb + " is ready for landing.");
        atcMediator.land(this);
    }
}
