package lab11.Ex3;

public class Disponivel implements Estado {

    // ao estar disponível pode ser requisitado por alguem e passa para o estado de emprestado
    @Override
    public void request(Livro b) { b.setState(new Emprestado()); }
    
    // ao estar disponível pode ser reservado por alguem e passa para o estado de reservado
    @Override
    public void reserve(Livro b) { b.setState(new Reservado()); }

    public String toString() { return "[Available]"; }


    // resto das operações não são suportadas neste estado  
    @Override
    public void register(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void _return(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void cancelReserve(Livro b) { System.err.println("Operation not available"); }
    
}