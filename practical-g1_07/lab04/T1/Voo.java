import java.util.ArrayList;
import java.util.TreeMap;

public class Voo {
    String codigo;
    Aviao aviao;
    int n_reservas;
    TreeMap<Integer, ArrayList<Integer>> mapa_reservas = new TreeMap<Integer, ArrayList<Integer>>();


    public Voo(String codigo, Aviao aviao) {
        this.codigo = codigo;
        this.aviao = aviao;
        n_reservas = 0;
        if (aviao.getSizeE()>0){    //se houver lugares de executiva
            for (int i = 0; i < aviao.getN_filasE(); i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int j = 0; j < aviao.getN_lugE(); j++) {
                    temp.add(0);
                }
                mapa_reservas.put(i, temp);
            }
        }
        for (int i = aviao.getN_filasE(); i < aviao.getN_filas(); i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < aviao.getN_lugT(); j++) {
                temp.add(0);
            }
            mapa_reservas.put(i, temp);
        }

    }

    public int getN_reservas() {
        return n_reservas;
    }

    public void setN_reservas(int n_reservas) {
        this.n_reservas = n_reservas;
    }

    public String getCodigo() {
        return codigo;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public TreeMap<Integer, ArrayList<Integer>> getMapaReservas(){
        return mapa_reservas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void addReserva(Reserva reserva) {
        int nPassOrigin=reserva.getN_passageiros();
        n_reservas++;
        char tipoC='T';
        if (reserva.getClasse().equals(Classe.Executiva)){tipoC='E';}
        if (reserva.getClasse().equals(Classe.Executiva)) {
            boolean filasVazias=false;
            for (int i = 0; i < aviao.n_filasE; i++) {
                filasVazias=false;
                if (lugaresDisponiveisFila(mapa_reservas.get(i)) == aviao.n_lugE){
                    filasVazias=true;
                    for (int j = 0; j < aviao.n_lugE; j++) {
                        mapa_reservas.get(i).set(j, n_reservas);
                        reserva.setN_passageiros(reserva.getN_passageiros() - 1);
                        if (reserva.getN_passageiros() == 0) {
                            break;
                        }
                    }
                }
                if (reserva.getN_passageiros() == 0) {
                    break;
                } 
            }
            if (filasVazias==false){
                for (int i = 0; i < aviao.n_filasE; i++) {
                    for (int j = 0; j < aviao.n_lugE; j++) {
                        if (mapa_reservas.get(i).get(j) == 0) {
                            mapa_reservas.get(i).set(j,n_reservas);
                            reserva.setN_passageiros(reserva.getN_passageiros() - 1);
                        }
                        if (reserva.getN_passageiros() == 0) {
                            break;
                        }
                    }
                    if (reserva.getN_passageiros() == 0) {
                        break;
                    }
                }
            }

        } else if (reserva.getClasse().equals(Classe.Turistica)) {
            boolean filasVazias=false;
            for (int i = aviao.getN_filasE(); i < aviao.getN_filas(); i++) {
                filasVazias=false;
                if (lugaresDisponiveisFila(mapa_reservas.get(i)) == aviao.getN_lugT()){
                    filasVazias=true;
                    for (int j = 0; j < aviao.getN_lugT(); j++) {
                        mapa_reservas.get(i).set(j, n_reservas);
                        reserva.setN_passageiros(reserva.getN_passageiros() - 1);
                        if (reserva.getN_passageiros() == 0) {
                            break;
                        }
                    }
                }
                if (reserva.getN_passageiros() == 0) {
                    break;
                } 
            }
            if (filasVazias==false){
                for (int i = aviao.getN_filasE(); i < aviao.getN_filas(); i++) {
                    for (int j = 0; j < aviao.getN_lugT(); j++) {
                        if (mapa_reservas.get(i).get(j) == 0) {
                            mapa_reservas.get(i).set(j,n_reservas);
                            reserva.setN_passageiros(reserva.getN_passageiros() - 1);
                        }
                        if (reserva.getN_passageiros() == 0) {
                            break;
                        }
                    }
                    if (reserva.getN_passageiros() == 0) {
                        break;
                    }
                }
            }
        }
        if (reserva.getN_passageiros()>0){
            System.out.println("Nao foi possivel obter lugares para a reserva: "+tipoC+" "+nPassOrigin);
            cancelaReserva(n_reservas);
            n_reservas--;
        } else{
            System.out.print(codigo+":"+n_reservas+" = "+obterLugares(n_reservas).get(0));
            for (int i = 1; i < obterLugares(n_reservas).size(); i++) {
                System.out.print(" | "+obterLugares(n_reservas).get(i));
            }
            System.out.println();
        }

    }

    public ArrayList<String> obterLugares(int nReserva){
        char[] letters = new char[26];
        for (int i=0; i<letters.length; i++){
            letters[i]=(char)(i+65);
        }
        ArrayList<String> lugares = new ArrayList<String>();
        for (int i = 0; i < aviao.getN_filas(); i++) {
            for (int j = 0; j < mapa_reservas.get(i).size(); j++) {
                if (mapa_reservas.get(i).get(j) == nReserva) {
                    String lugar="";
                    lugar+=(i+1);
                    lugar+=letters[j];
                    lugares.add(lugar);
                }
            }
        }
        return lugares;
    }

    public void cancelaReserva(int n) {
        for (int i = 0; i < aviao.getN_filas(); i++) {
            for (int j = 0; j < mapa_reservas.get(i).size(); j++) {
                if (mapa_reservas.get(i).get(j) == n) {
                    mapa_reservas.get(i).set(j, 0);
                }

            }
        }
    }

    public int lugaresDisponiveisFila(ArrayList<Integer> lista) {
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString(){
        String str="Codigo de voo "+codigo+"\n"+aviao;

        return str;
    }




}
