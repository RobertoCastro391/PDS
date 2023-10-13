package lab11.Ex1;

import java.util.ArrayList;

public class RevistaEletronica {
    private String nome;
    private final SortStrategy strategy_type;
    private ArrayList<Telemovel> listTelemoveis = new ArrayList<Telemovel>();

    public RevistaEletronica(String nome, SortStrategy strategy_type, ArrayList<Telemovel> listTelemoveis) {
        this.nome = nome;
        this.strategy_type = strategy_type;
        this.listTelemoveis = listTelemoveis;
    }

    public void sort(String propriedade) {
        strategy_type.sort(this.listTelemoveis, propriedade);
     }
}
