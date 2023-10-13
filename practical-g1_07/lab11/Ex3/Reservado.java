package lab11.Ex3;

public class Reservado implements Estado {

    // ao estar reservado só pode ser cancelada a reserva e volta para o estado de disponivel
    @Override
    public void cancelReserve(Livro b) { b.setState(new Disponivel()); }

    public String toString() { return "[Reserved]"; }

    
    // resto das operações não são suportadas neste estado
    @Override
    public void register(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void request(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void _return(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void reserve(Livro b) { System.err.println("Operation not available"); }
    
}