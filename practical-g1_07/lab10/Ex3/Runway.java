package Ex3;

public class Runway implements Command {
    private ATCMediator atcMediator;
    private boolean free;

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        free = true;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println("Landing permission granted.");
            atcMediator.setLandingStatus(true);
        } else
            System.out.println("Unable to land.");
    }
}