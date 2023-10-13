import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class GerirVoos {
    static HashMap<String, Voo> voos = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        while (true){
            System.out.print("Insere uma opcao (H para apresentar outras opcoes): ");
            op=sc.nextLine();
            op=op.toUpperCase();
            if (op.equals("H")){
                menu();
            } else if (op.charAt(0)=='I'){
                String filename=op.split(" ")[1];
                newVoo(filename);
            } else if (op.charAt(0)=='M'){
                String flightCode=op.split(" ")[1];
                mapReservas(flightCode);
            } else if (op.charAt(0)=='F'){
                createVoo(op);
            } else if (op.charAt(0)=='R'){
                makeReserva(op);
            } else if (op.charAt(0)=='C'){
                String reservationCode=op.split(" ")[1];
                cancelReserva(reservationCode);
            } else if (op.equals("Q")){
                break;
            } else{
                System.out.println("Opcao invalida");
                break;
            }
        }
        sc.close();
    }

    public static void menu(){
        System.out.println("------MENU------");
        System.out.println("H) apresenta as opcoes do Menu");
        System.out.println("I 'filename'): Le um ficheiro de texto contento informacao sobre um voo");
        System.out.println("M 'flight_code'): Exibe o mapa das reservas de um voo");
        System.out.println("F 'flight_code num_seats_executive num_seats_tourist') acrescenta um novo voo, com codigo e lugares");
        System.out.println("R 'flight_code class number_seats') acrescenta uma nova reserva a um voo, com indicacao do codigo do voo, da classe (T/E), e do numero de lugares.");
        System.out.println("C 'reservation_code') cancela uma reserva.");
        System.out.println("Q) termina o programa.");
    }

    public static void newVoo(String filename){
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String firstLine=myReader.nextLine();
            String[] details = firstLine.split(" ");
            String vooCode=details[0];
            vooCode = vooCode.replace(">", "");
            String configTur, configExec;
            Aviao plane;
            if (details.length>2){
                configExec=details[1].toUpperCase();
                configTur=details[2].toUpperCase();
                plane = new Aviao(configExec, configTur);
            } else{
                configTur=details[1].toUpperCase();
                plane = new Aviao(configTur);
            }
            Voo flight = new Voo(vooCode, plane);
            voos.put(vooCode, flight);
            System.out.println(flight);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] detailsReserva = data.split(" ");
                String classReserva=detailsReserva[0].toUpperCase();
                int nLugares=Integer.parseInt(detailsReserva[1]);
                Classe cR=Classe.Turistica;
                switch(classReserva){
                    case "T": cR=Classe.Turistica; break;
                    case "E": cR=Classe.Executiva; break;
                    default: break;
                }
                Reserva reservation = new Reserva(cR, nLugares);
                flight.addReserva(reservation);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void mapReservas(String codeVoo){
        Voo flight = voos.get(codeVoo);
        int sizePlane = flight.getAviao().getN_filas();
        int largePlane = flight.getAviao().getN_lugT();
        if (flight.getAviao().getN_filasE()>0){
            if (flight.getAviao().getN_lugE()>largePlane){
                largePlane=flight.getAviao().getN_lugE();
            }
        }

        String valores[][] = new String[largePlane][sizePlane];
        for (int index:flight.getMapaReservas().keySet()){
            for (int size=0; size<flight.getMapaReservas().get(index).size(); size++){
                valores[size][index]=flight.getMapaReservas().get(index).get(size).toString();
            }
        }

        char[] letters = new char[26];
        for (int i=0; i<letters.length; i++){
            letters[i]=(char)(i+65);
        }
        

        for (int i=0; i<=largePlane; i++){
            for (int j=0; j<=sizePlane; j++){
                if (i==0){
                    if (j==0){
                        System.out.print(" ");
                    } else{
                        System.out.printf("%3s", j);
                    }
                } else{
                    if (j==0){
                        System.out.print(letters[i-1]);
                    } else{
                        if (valores[i-1][j-1]==null){
                            System.out.print("   ");
                        } else{
                            System.out.printf("%3s", valores[i-1][j-1]);
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void createVoo(String detalhes){
        String[] details = detalhes.split(" ");
        String vooCode=details[1];
        String configTur, configExec;
        Aviao plane;
        if (details.length>3){
            configExec=details[2];
            configTur=details[3];
            plane = new Aviao(configExec, configTur);
        } else{
            configTur=details[2];
            plane = new Aviao(configTur);
        }
        Voo flight = new Voo(vooCode, plane);
        voos.put(vooCode, flight);
    }

    public static void makeReserva(String detalhes){
        String[] details = detalhes.split(" ");
        String vooCode=details[1];
        String classReserva=details[2].toUpperCase();
        int nLugares=Integer.parseInt(details[3]);
        Classe cR=Classe.Turistica;
        switch(classReserva){
            case "T": cR=Classe.Turistica; break;
            case "E": cR=Classe.Executiva; break;
            default: break;
        }
        Reserva reservation = new Reserva(cR, nLugares);
        voos.get(vooCode).addReserva(reservation);

    }

    public static void cancelReserva(String code){
        String vooCode=code.split(":")[0];
        int nReserva=Integer.parseInt(code.split(":")[1]);
        voos.get(vooCode).cancelaReserva(nReserva);

    }

}
