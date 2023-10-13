package ExamePraticoExemploRui;

public class Alojamento implements Servico {
    
    private String nome;
    private String descrisao;
    private double price;
    private int ocupacaoMaxima;

    public Alojamento(String nome, String descrisao, double price, int ocupacaoMaxima) {
        this.nome = nome;
        this.descrisao = descrisao;
        this.price = price;
        this.ocupacaoMaxima = ocupacaoMaxima;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOcupacaoMaxima(int ocupacaoMaxima) {
        this.ocupacaoMaxima = ocupacaoMaxima;
    }

    public int getOcupacaoMaxima() {
        return ocupacaoMaxima;
    }

    @Override
    public String name() {
        return nome;
    }
    @Override
    public String description() {
        return descrisao;
    }
    @Override
    public double price() {
        return price;
    }
    @Override
    public TipoServico type() {
        return TipoServico.ALOJAMENTO;
    }

    @Override
    public String toString() {
        return "Alojamento [nome=" + nome + ", descrisao=" + descrisao + ", price=" + price + ", ocupacao Maxima="
                + ocupacaoMaxima + "]";
    }
}
