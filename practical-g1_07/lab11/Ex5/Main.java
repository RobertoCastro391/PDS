package lab11.Ex5;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Tem de usar argumentos!");
            System.out.println("java Main [-option] path \n\t Option:\n\t\t-r: Inclui o tamanho dos subdiretórios dentro do diretório");
            System.exit(0);
        }

        if (args.length == 1){
            new Visitor().Walker(args[0], false);
        }
        else if (args.length == 2) {
            if (args[0].equals("-r")){
                new Visitor().Walker(args[1], true);
            }
            else {
                System.err.println("Tem de usar argumentos!");
                System.out.println("java Main [-option] path \n\t Option:\n\t\t-r: Inclui o tamanho dos subdiretórios dentro do diretório");
                System.exit(0);
            }
        }
        else {
            System.err.println("Tem de usar argumentos!");
            System.out.println("java Main [-option] path \n\t Option:\n\t\t-r: Inclui o tamanho dos subdiretórios dentro do diretório");
            System.exit(0);
        }
    }
    
}
