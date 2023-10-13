package lab03.Ex2;

import java.util.Arrays;

public class Aviao {
    private int disponibilidadeTuristica;   
    private int disponibilidadeExecutiva;
    private int[][] assentosTuristica;
    private int[][] assentosExecutiva;


    public Aviao(String assentosE, String assentosT){


        int numFilasExecutivo = Integer.parseInt(String.valueOf(assentosE.split("x")[0]));
        int numColunasExecutivo = Integer.parseInt(String.valueOf(assentosE.split("x")[1]));


        this.assentosExecutiva = new int[numFilasExecutivo][numColunasExecutivo];

        for (int[] row : this.assentosExecutiva){
            Arrays.fill(row, 0);
        }
        
        int numFilasTuristica = Integer.parseInt(String.valueOf(assentosT.split("x")[0]));
        int numColunasTuristica = Integer.parseInt(String.valueOf(assentosT.split("x")[1]));

        this.assentosTuristica = new int[numFilasTuristica][numColunasTuristica];

        for (int[] row : this.assentosTuristica){
            Arrays.fill(row, 0);
        }
        
        this.disponibilidadeExecutiva = getTotalExecutiva();
        this.disponibilidadeTuristica = getTotalTuristica();
    }

    public Aviao(String assentosT){
        int numFilasTuristica = Integer.parseInt(String.valueOf(assentosT.split("x")[0]));
        int numColunasTuristica = Integer.parseInt(String.valueOf(assentosT.split("x")[1]));
        
        this.assentosTuristica = new int[numFilasTuristica][numColunasTuristica];

        for (int[] row : this.assentosTuristica){
            Arrays.fill(row, 0);
        }

        this.disponibilidadeTuristica = getTotalTuristica() ;
    }

    public int getTotalTuristica() {
        return assentosTuristica.length * assentosTuristica[0].length;
    }

    public int getTotalExecutiva() {
        return assentosExecutiva.length * assentosExecutiva[0].length;
    }

    public int[][] getAssentosTuristica() {
        return assentosTuristica;
    }

    public int[][] getAssentosExecutiva() {
        return assentosExecutiva;
    }


    public int getDisponibilidadeTuristica() {
        disponibilidadeTuristica = 0;
        for(int i = 0; i < assentosTuristica.length; i++){
            for(int j = 0; j < assentosTuristica[0].length; j++){
                if(assentosTuristica[i][j] == 0){
                    disponibilidadeTuristica++;
                }
            }
        }
        return disponibilidadeTuristica;
    }

    public int getDisponibilidadeExecutiva(){
        disponibilidadeExecutiva = 0;
        for(int i = 0; i < assentosExecutiva.length; i++){
            for(int j = 0; j < assentosExecutiva[0].length; j++){
                if(assentosExecutiva[i][j] == 0){
                    disponibilidadeExecutiva++;
                }
            }
        }
        return disponibilidadeExecutiva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + disponibilidadeTuristica;
        result = prime * result + disponibilidadeExecutiva;
        result = prime * result + Arrays.deepHashCode(assentosTuristica);
        result = prime * result + Arrays.deepHashCode(assentosExecutiva);
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
        Aviao other = (Aviao) obj;
        if (disponibilidadeTuristica != other.disponibilidadeTuristica)
            return false;
        if (disponibilidadeExecutiva != other.disponibilidadeExecutiva)
            return false;
        if (!Arrays.deepEquals(assentosTuristica, other.assentosTuristica))
            return false;
        if (!Arrays.deepEquals(assentosExecutiva, other.assentosExecutiva))
            return false;
        return true;
    }

}