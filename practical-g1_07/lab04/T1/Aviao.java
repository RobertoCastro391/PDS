


public class Aviao {
    String lug_Executiva, lug_Turistica;
    int sizeT, sizeE, total_size;
    int n_filasT, n_filasE, n_lugT, n_lugE;

    // caso exista classe executiva e turistica
    public Aviao(String lug_Executiva, String lug_Turistica) {
        String[] arrayT = lug_Turistica.split("X");
        String[] arrayE = lug_Executiva.split("X");
        n_filasT = Integer.parseInt(arrayT[0]);
        n_lugT = Integer.parseInt(arrayT[1]);
        n_filasE = Integer.parseInt(arrayE[0]);
        n_lugE = Integer.parseInt(arrayE[1]);
        sizeT = n_filasT * n_lugT;
        sizeE = n_filasE * n_lugE;
        total_size = sizeT + sizeE;
    }

    // caso só exista classe turistica

    public Aviao(String lug_Turistica) {
        String[] arrayT = lug_Turistica.split("X");
        n_filasT = Integer.parseInt(arrayT[0]);
        n_lugT = Integer.parseInt(arrayT[1]);
        n_filasE = 0;
        n_lugE = 0;
        sizeT = n_filasT * n_lugT;
        sizeE= 0;
        total_size = sizeT;
    }

    public int getN_filasT() {
        return n_filasT;
    }

    public int getN_filasE() {
        return n_filasE;
    }

    public int getN_filas() {
        return n_filasE + n_filasT;
    }

    public int getN_lugT() {
        return n_lugT;
    }

    public int getN_lugE() {
        return n_lugE;
    }

    public int getTotal_size() {
        return total_size;
    }

    public int getSizeT() {
        return sizeT;
    }

    public int getSizeE() {
        return sizeE;
    }

    @Override
    public String toString(){
        String str="Lugares Disponiveis: ";
        if (sizeE>0){
            str += sizeE+" lugares em Classe Executiva; ";
        }
        str += sizeT+" lugares em Classe Turistica.";
        if (sizeE==0){
            str += "\nClasse Executiva nao disponivel neste voo";
        }
        return str;
    }
}