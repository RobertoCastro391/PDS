package Ex3;

public class Main {
    public static void main(String[] args) {
        
        ATCMediator ATC = new ATC();

        Flight TP234Airline = new Flight(ATC,"TP234");
        Runway mainRunway = new Runway(ATC);

        ATC.registerFlight(TP234Airline);
        ATC.registerRunway(mainRunway);

        TP234Airline.getReady();
        //ATC.land(TP234Airline);
        
        // ATC.land(TP234Airline);

        Flight lh3434Airline = new Flight(ATC, "LH3434");
        ATC.registerFlight(lh3434Airline);

        lh3434Airline.getReady();
        ATC.land(lh3434Airline);
    }
}
