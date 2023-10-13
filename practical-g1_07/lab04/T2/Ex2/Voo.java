package lab03.Ex2;

import java.util.ArrayList;

public class Voo {
    private String codigo;
    private Aviao aviao;
    private int sequentialNumber = 1;
    private static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public Voo(String codigo, Aviao aviao) {
        this.codigo = codigo;
        this.aviao = aviao;
    }

    public void exibirMapa(){       // função para exibir o mapa do avião
        int numFilas = 0;       // variável para armazenar o número de filas
        int numColunas = 0;         // variável para armazenar o número de colunas

        if(aviao.getAssentosExecutiva() == null){
            numFilas = aviao.getAssentosTuristica().length;         // se o avião não tiver assentos executivos, o número de filas é igual ao número de filas da classe turística
            numColunas = aviao.getAssentosTuristica()[0].length;        // se o avião não tiver assentos executivos, o número de colunas é igual ao número de colunas da classe turística

            System.out.print("   ");             
            for (int i = 1; i <= numFilas; i++){
                if (i <= 8){
                    System.out.print(i + "  ");
                }else{
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            for (int i = 0; i < numColunas; i++){
                System.out.print(letras[i] + "  ");
                for(int j = 0; j < aviao.getAssentosTuristica().length; j++){
                    System.out.print(aviao.getAssentosTuristica()[j][i] + "  ");
                }
                System.out.println();
            }

        }else{
            numFilas = aviao.getAssentosExecutiva().length + aviao.getAssentosTuristica().length;           // se o avião tiver assentos executivos, o número de filas é igual ao número de filas da classe executiva + o número de filas da classe turística
            numColunas = Math.max(aviao.getAssentosExecutiva()[0].length, aviao.getAssentosTuristica()[0].length);      // o numero de colunas é igual ao maior número de colunas entre as classes executiva e turística

            System.out.print("   ");
            for (int i = 1; i <= numFilas; i++){
                if (i <= 8){
                    System.out.print(i + "  ");
                }else{
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            for (int i = 0; i < numColunas; i++){
                System.out.print(letras[i] + "  ");
                if(i < aviao.getAssentosExecutiva()[0].length){
                    for(int j = 0; j < aviao.getAssentosExecutiva().length; j++){
                        System.out.print(aviao.getAssentosExecutiva()[j][i] + "  ");
                    }
                }
                else{
                    for(int j = 0; j < aviao.getAssentosExecutiva().length; j++){
                        System.out.print("   ");
                    }
                }

                if(i < aviao.getAssentosTuristica()[0].length){
                    for(int j = 0; j < aviao.getAssentosTuristica().length; j++){
                        System.out.print(aviao.getAssentosTuristica()[j][i] + "  ");
                    }
                }
                else{
                    for(int j = 0; j < aviao.getAssentosTuristica().length; j++){
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void adicionarReserva(String opcao, char classe, int num_lugares){
        int diff = num_lugares;             // variável para armazenar a diferença entre o número de lugares desejados e o número de lugares disponíveis
        boolean finalIndex = false;     // variavel que indica se não existe nenhuma fila vazia
        ArrayList<String> lugares = new ArrayList<>();      // arraylist para armazenar os lugares reservados
        ArrayList<Integer> filasReservadas = new ArrayList<>();     // arraylist para armazenar as filas reservadas

        if(classe == 'T'){
            if(aviao.getDisponibilidadeTuristica() < num_lugares){
                System.out.println("Erro: Lugares insuficientes para efetuar a reserva");       // se o número de lugares disponíveis na classe turística for menor que o número de lugares desejados, é exibida uma mensagem de erro
                return;
            }
            for(int i = 0; i < aviao.getAssentosTuristica().length; i++){
                boolean livre = true;           // variável que indica se a fila está vazia

                for(int j = 0; j < aviao.getAssentosTuristica()[0].length; j++){
                    if(aviao.getAssentosTuristica()[i][j] != 0){        // verifica se os lugares da fila estão ocupados
                        livre = false;
                        diff = num_lugares;
                        filasReservadas.clear();
                        break;
                    }
                }

                if(livre){          // se a fila estiver vazia, a mesma é guardada no arraylist de filas reservadas
                    filasReservadas.add(i);
                    diff = diff - aviao.getAssentosTuristica()[0].length;
                }

                if(livre && diff <= 0){     // se a fila estiver vazia e foi encontrado um número de filas suficiente para a reserva, os lugares são reservados
                    int counter = num_lugares;      
                    for(int k: filasReservadas){
                        for(int l = 0; l < aviao.getAssentosTuristica()[0].length; l++){
                            if (counter > 0){ 
                                aviao.getAssentosTuristica()[k][l] = getSequentialNumber();
                                if(aviao.getAssentosExecutiva() != null){
                                    lugares.add((aviao.getAssentosExecutiva().length+k+1) + "" + letras[l]);
                                }
                                else{
                                    lugares.add((k+1) + "" + letras[l]);
                                }
                                counter--;
                            }
                        }
                    }
                    break;
                }
                if(i == aviao.getAssentosTuristica().length - 1){       // se não foi encontrado um número de filas suficiente para a reserva, finalIndex é alterado para true
                    finalIndex = true;
                }
            }
            if(finalIndex){     // se não foi encontrado um número de filas suficiente para a reserva, reserva os lugares disponiveis
                int counter = num_lugares;
                for(int i = 0; i < aviao.getAssentosTuristica().length; i++){
                    for(int j = 0; j < aviao.getAssentosTuristica()[0].length; j++){
                        if(aviao.getAssentosTuristica()[i][j] == 0){
                            aviao.getAssentosTuristica()[i][j] = getSequentialNumber();
                            lugares.add((aviao.getAssentosExecutiva().length+i+1) + "" + letras[j]);
                            counter--;
                        }
                        if(counter == 0){
                            break;
                        }
                    }
                    if(counter == 0){
                        break;
                    }  
                }
            }

        }
        else if(classe == 'E' && aviao.getAssentosExecutiva() != null){
            if(aviao.getDisponibilidadeExecutiva() < num_lugares){
                System.out.println("Erro: Lugares insuficientes para efetuar a reserva");       // se o número de lugares disponíveis na classe executiva for menor que o número de lugares desejados, é exibida uma mensagem de erro
                return;
            }
            for(int i = 0; i < aviao.getAssentosExecutiva().length; i++){
                boolean livre = true;       // variável que indica se a fila está vazia

                for(int j = 0; j < aviao.getAssentosExecutiva()[0].length; j++){
                    if(aviao.getAssentosExecutiva()[i][j] != 0){        // verifica se os lugares da fila estão ocupados
                        livre = false;
                        diff = num_lugares;
                        filasReservadas.clear();
                        break;
                    }
                }

                if(livre){      // se a fila estiver vazia, a mesma é guardada no arraylist de filas reservadas
                    filasReservadas.add(i);
                    diff = diff - aviao.getAssentosExecutiva()[0].length;
                }

                if(livre && diff <= 0){     // se a fila estiver vazia e foi encontrado um número de filas suficiente para a reserva, os lugares são reservados
                    int counter = num_lugares;
                    for(int k: filasReservadas){
                        for(int l = 0; l < aviao.getAssentosExecutiva()[0].length; l++){
                            if (counter > 0){ 
                                aviao.getAssentosExecutiva()[k][l] = getSequentialNumber();
                                lugares.add((k+1) + "" + letras[l]);
                                counter--;
                            }
                        }
                    }
                    break;
                }
                if(i == aviao.getAssentosExecutiva().length - 1){       // se não foi encontrado um número de filas suficiente para a reserva, finalIndex é alterado para true
                    finalIndex = true;
                }
            }
            if(finalIndex){     // se não foi encontrado um número de filas suficiente para a reserva, reserva os lugares disponiveis
                int counter = num_lugares;
                for(int i = 0; i < aviao.getAssentosExecutiva().length; i++){
                    for(int j = 0; j < aviao.getAssentosExecutiva()[0].length; j++){
                        if(aviao.getAssentosExecutiva()[i][j] == 0){
                            aviao.getAssentosExecutiva()[i][j] = getSequentialNumber();
                            lugares.add((i+1) + "" + letras[j]);
                            counter--;
                        }
                        if(counter == 0){
                            break;
                        }
                    }
                    if(counter == 0){
                        break;
                    }  
                }
            }
        }
        else{
            if(opcao == "R"){       // se a classe for inválida, é exibida uma mensagem de erro
                System.out.println("Erro: Classe \"" + classe + "\" inválida ou não disponível");
                return;
            }
        }

        StringBuilder reserva = new StringBuilder();
        reserva.append(getCodigo() + ":" + getSequentialNumber() + " = ");
        for(int i = 0; i < lugares.size(); i++){
            reserva.append(lugares.get(i));
            if(i != lugares.size()-1){
                reserva.append(" | ");
            }
        }

        if(opcao == "R"){       // print da reserva
            System.out.println(reserva);
        }

        setSequentialNumber(getSequentialNumber() + 1);     // incrementa o sequential number
    }

    public void cancelarReserva(int reservation_number){
        for(int i = 0; i < aviao.getAssentosTuristica().length; i++){       // percorre o array de assentos da classe turística
            for(int j = 0; j < aviao.getAssentosTuristica()[0].length; j++){
                if(aviao.getAssentosTuristica()[i][j] == reservation_number){       // se o número da reserva for encontrado, o assento fica livre
                    aviao.getAssentosTuristica()[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < aviao.getAssentosExecutiva().length; i++){       // percorre o array de assentos da classe executiva
            for(int j = 0; j < aviao.getAssentosExecutiva()[0].length; j++){
                if(aviao.getAssentosExecutiva()[i][j] == reservation_number){       // se o número da reserva for encontrado, o assento fica livre
                    aviao.getAssentosExecutiva()[i][j] = 0;
                }
            }
        }
    }

    public int getSequentialNumber() {
        return sequentialNumber;
    }

    public String getCodigo() {
        return codigo;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setSequentialNumber(int sequentialNumber) {
        this.sequentialNumber = sequentialNumber;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((aviao == null) ? 0 : aviao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Voo other = (Voo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (aviao == null) {
            if (other.aviao != null)
                return false;
        } else if (!aviao.equals(other.aviao))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder vooString = new StringBuilder();
        vooString.append("Código do voo: " + codigo + ". Lugares disponíveis: ");
        if(aviao.getAssentosExecutiva() != null){
            vooString.append(aviao.getTotalTuristica() + " lugares em classe Turística; " + aviao.getTotalExecutiva() + " lugares em classe Executiva.\n");
        }
        else{
            vooString.append(aviao.getTotalTuristica() + " lugares em classe Turística.\nClasse Executiva não disponível neste voo.\n");
        }
        return vooString.toString();
    }
}
