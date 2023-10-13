package lab11.Ex3;

public class Main {
    
    public static void main(String[] args) {
        
        // criar biblioteca
        Biblioteca LeitolinoLivraria = new Biblioteca();

        // criar 3 livros
        Livro b1 = new Livro("Anti-Stress Java", "Omodionah", 555555555, 2021);
        Livro b2 = new Livro("A Guerra de Padrões", "George Omel", 123456789, 1948);
        Livro b3 = new Livro("I Dare you", "Khumatk", 219537190, 1985);
        Livro b4 = new Livro("A Vida de João Nuno", "João Nuno", 218737190, 2021);

        // adicionar os 3 livros à nossa biblioteca
        LeitolinoLivraria.addBook(b1);
        LeitolinoLivraria.addBook(b2);
        LeitolinoLivraria.addBook(b3);
        LeitolinoLivraria.addBook(b4);

        // fazer as operações
        LeitolinoLivraria.operation();

    }
}