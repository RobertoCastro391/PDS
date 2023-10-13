package lab11.Ex3;

public class Inventario implements Estado {

    // qd o livro é registado no ent passa de inventario para o estado de disponivel 
    @Override 
    public void register(Livro b) { b.setState(new Disponivel()); }

    public String toString() { return "[Inventory]"; }

    
    // resto das operações não são suportadas neste estado
    @Override
    public void request(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void _return(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void reserve(Livro b) { System.err.println("Operation not available"); }

    @Override
    public void cancelReserve(Livro b) { System.err.println("Operation not available"); }
    
}