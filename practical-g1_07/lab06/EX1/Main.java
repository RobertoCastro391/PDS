package lab06.EX1;

public class Main {
    
    public static void main(String[] args) {
        
        Database database = new Database();
        Adapter empregados = new Adapter(database);


        // criar empregados da Sweets   
        System.out.println("------------ EMPLOYEE/DATABASE SYSTEM ------------");
        Employee empl1 = new Employee("Tiago Gomes", 1, 4000);
        Employee empl2 = new Employee("Roberto Castro", 2, 3100);
        Employee empl3 = new Employee("Sara Almeida", 3, 1500);
        Database db = new Database();


        System.out.println("Before we add the employees...");
        System.out.println(db);
        System.out.println("Let's add all of them.");
        
        // adicionar empregados da Sweets 
        empregados.insere(empl1);
        empregados.insere(empl2);
        empregados.insere(empl3);

        // criar empregados do Petiscos
        Empregado empr1 = new Empregado("João", "Nuno", 100, 1400);
        Empregado empr2 = new Empregado("Diana", "Miranda", 530, 1100);
        Empregado empr3 = new Empregado("Marta", "Inácio", 45, 3000);
        
        // adicionar empregados do Petiscos
        empregados.insere(empr1);
        empregados.insere(empr2);
        empregados.insere(empr3);

        //New Company
        System.out.println("Current Staff:");
        empregados.printEmployees();

        empregados.remove(45);
        empregados.remove(3);
        System.out.println("\nNew current Staff without Marta Inácio and Sara Almeida because they were fired:");
        empregados.printEmployees();

        System.out.println("\nIs there a worker with code 0 in the company? " + empregados.isEmpregado(0) );
        System.out.println("Is Diana Miranda a worker in the company? " + empregados.isEmpregado(empr2.codigo()));

        Empregado empr4 = new Empregado("Rafaela", "Abrunhosa", 694, 1111111.11);
        empregados.insere(empr4);
        System.out.println("\n" + empr4.nome() + " has joined the company with " + empr4.salario() + " sallary!");
        

    }
}