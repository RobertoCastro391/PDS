package ExamePraticoExemploRui;
import java.util.ArrayList;

public class PacoteServicos implements Servico {
    private String name;
    private String description;
    private ArrayList<Servico> servicos = new ArrayList<>();
    ArrayList<TipoServico> servicosdiferentes = new ArrayList<>();
    
    private int count = 0; 

    public PacoteServicos(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(Servico servico) {
        count++;
        TipoServico tipo = servico.type();

        if (!servicosdiferentes.contains(tipo)) {
            servicosdiferentes.add(tipo);
        }

        servicos.add(servico);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double price() {
        
        double preco = 0;

        for (Servico servico : servicos) {
            preco += servico.price();
        }
        
        if (servicos.size() > 3) {
            return preco - (preco * 0.1);
        }
        else {
           switch (servicos.size()) {
            case 1:
                return preco  - (preco * 0.03);
            case 2:
                return preco - (preco * 0.06);
            case 3:
                return preco - (preco * 0.09); 
            }
        }
        return preco;
    }

    @Override
    public TipoServico type() {
        return TipoServico.PACOTESERVICOS;
    }

    @Override
    public String toString() {

        for (TipoServico servico : servicosdiferentes) {
            return servico.toString();
        }
        
        int desconto = 0;

        if (count > 3) {
            desconto = 10;
        }
        else {
            switch (count) {
                case 1:
                    desconto = 3;
                    break;
                case 2:
                    desconto = 6;
                    break;
                case 3:
                    desconto = 9;
                    break;
            }
        }
        return null;
    }
}