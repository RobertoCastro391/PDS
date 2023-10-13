package Ex3;

public class ATC implements ATCMediator {
    private Flight flight;
    private Runway runway;
    private boolean land = false;

    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    public void registerFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isLandingOk() {
        return land;
    }

    public void setLandingStatus(boolean status) {
        land = status;
    }

    public void land(Flight flight) {
        if (runway.isFree()) {
            this.setLandingStatus(true);
            flight.land();
            this.runway.setFree(false);
        } else {
            this.setLandingStatus(false);
        }
    }
    
}
