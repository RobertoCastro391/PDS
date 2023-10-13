package lab11.Ex3;

public class Emprestado implements Estado {

    // ao estar emprestado só pode ser devolvido e passa para o estado de disponível
    @Override
    public void _return(Livro b) { b.setState(new Disponivel()); }

    public String toString(){ return "[Borrowed]"; }
    

    // resto das operações não são suportadas neste estado
    @Override
    public void register(Livro b) { System.err.println("Operation not available"); }
    
    @Override
    public void request(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void reserve(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void cancelReserve(Livro b) { System.err.println("Operation not available"); }
    
}