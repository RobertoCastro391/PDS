package lab05.Ex2;

public class Cream {
    String cream;

    public Cream(String cream) {
        this.cream = cream;
    }

    public String getCream() {
        return cream;
    }

    public void setCream(String cream) {
        this.cream = cream;
    }

    @Override
    public String toString() {
        return cream;
    }
}