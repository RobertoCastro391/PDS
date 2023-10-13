package ExamePraticoExemploRui;

public class Transporte implements Servico {

    private String nome;
    private String descrisao;
    private double price;

    public Transporte(String nome, String descrisao, double price) {
        this.nome = nome;
        this.descrisao = descrisao;
        this.price = price;
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
        return TipoServico.TRANSPORTE;
    }

    @Override
    public String toString() {
        return "Transporte [nome=" + nome + ", descrisao=" + descrisao + ", price=" + price + "]";
    }
}