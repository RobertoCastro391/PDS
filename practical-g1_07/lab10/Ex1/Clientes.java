package lab10.Ex1;
import java.util.ArrayList;

public abstract class Clientes {

    protected String nome;
    protected ArrayList<Produto> produtosLeilao; 

    public abstract void update(Produto p, boolean novaLicitacao);

    public void receberNotificacoes(Produto p) {
        p.attach(this);
    }

    public Clientes(String nome) {
        this.nome = nome;
        this.produtosLeilao = new ArrayList<Produto>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }

    

}