public class Reserva {
    private Classe classe;
    private int n_passageiros;

    public Reserva(Classe classe, int n_passageiros){
        this.classe=classe;
        this.n_passageiros=n_passageiros;
    }

    public Classe getClasse(){
        return classe;
    }

    public int getN_passageiros(){
        return n_passageiros;
    }

    public void setClasse(Classe classe){
        this.classe=classe;
    }

    public void setN_passageiros(int n_passageiros){
        this.n_passageiros=n_passageiros;
    }

    @Override
    public String toString(){
        return "Classe: "+classe+" Nº de passageiros: "+n_passageiros;
    }
    
}
