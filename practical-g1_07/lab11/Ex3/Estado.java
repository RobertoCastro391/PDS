package lab11.Ex3;

public interface Estado {

    public void register(Livro b);
	public void request(Livro b);
	public void _return(Livro b);
    public void reserve(Livro b);
	public void cancelReserve(Livro b);
	public String toString();

}