package Ex3;

public interface ATCMediator {
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    void setLandingStatus(boolean status);
    boolean isLandingOk();
    void land(Flight flight);
}