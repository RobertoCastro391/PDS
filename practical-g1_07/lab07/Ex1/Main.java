package lab07.Ex1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EmployeeInterface employee1 = new Employee("MARIA");
        TeamMember employee2 = new TeamMember(new Employee("RUI"));
        TeamMember employee3 = new TeamMember(new Employee("JOANA"));
        Manager employee4 = new Manager(new Employee("MATILDE"));
        Manager employee5 = new Manager(new Employee("FILIPE"));
        TeamLeader employee6 = new TeamLeader(new Employee("MATEUS"));

        System.out.println("------------------------------------------------------\n");
        employee1.work();                   //nao tem trabalho atribuido
        employee1.start(new Date());        //começou um trabalho
        employee1.start(new Date());        //tem outro trabalho

        employee3.start(new Date());        //começou um trabalho
        employee3.terminate(new Date());    //terminou trabalho

        employee1.work();                   //esta a trabalhar
        employee1.terminate(new Date());    //terminou trabalho

        employee2.colaborate();
        employee6.plan();

        System.out.println("\n------------------------------------------------------\n");
        EmployeeInterface employees[] = {employee2, employee3, employee4, employee5,employee6};
        for (EmployeeInterface e: employees) {
            System.out.printf("---------------------%s---------------------\n", e.getNome());
            e.start(new Date());
            e.work();

            // For last role added, do additional operation
            if (e instanceof TeamMember) {
                TeamMember ee = (TeamMember) e;
                ee.colaborate();
            }
            if (e instanceof TeamLeader) {
                TeamLeader ee = (TeamLeader) e;
                ee.plan();
            }
            if (e instanceof Manager) {
                Manager ee = (Manager) e;
                ee.manage();
            }
            e.terminate(new Date());
            System.out.printf("---------------------Terimou %s-------------\n", e.getNome());
            System.out.println();
        }
        System.out.println("------------------------------------------------------");

    }
}