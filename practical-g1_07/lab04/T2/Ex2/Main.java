package lab03.Ex2;

import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Voo> voos = new ArrayList<>();
    public static ArrayList<String> reservasFalhadas = new ArrayList<>();


    public static void menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("H - Ajuda\n" +
        "I filename (must be a txtfile) - Leitura de um ficheiro contendo a informação do voo\n" +
        "M flight_code - Exibe o mapa das reservas de um voo\n" + 
        "F flight_code num_seats_executive num_seats_tourist - Acrescenta um novo voo com código (Opcional: Classe Executiva)\n" + 
        "R flight_code class number_seats - Acrescebta uma nova reserva a um voo (especifique a classe)\n" + 
        "C reservation_code - Cancela uma reserva (formato flight_code:sequential_reservation_number\n" +
        "Q - Quit" );
        System.out.println("---------------------------------------------------");


    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String[] inputArray;
        //menu();
        while(!input.equals("Q")){
            System.out.println("Escolha uma opção: (H para ajuda)");
            input = sc.nextLine();
            inputArray = input.split(" ");

            boolean existeVoo = false;          // variavel para verificar se o voo existe nas opções M, R e C
            switch(inputArray[0]){
                case "H":
                    menu();
                    break;
                case "I":
                    if(inputArray.length != 2){
                        System.out.println("Erro: Número de argumentos inválido");
                        break;
                    }
                    if(!(inputArray[1].endsWith(".txt"))){
                        System.out.println("Erro: Formato de ficheiro inválido");
                        break;
                    }
                    File file = new File(inputArray[1]);            // converte o caminho dado em ficheiro
                    Scanner scFile = new Scanner(file);         // cria um scanner para ler o ficheiro
                    if(!file.exists()){                     // verifica se o ficheiro existe
                        System.out.println("Erro: Ficheiro não encontrado");
                        break;
                    }
                    String firstline = scFile.nextLine();           // lê a primeira linha do ficheiro
                    String[] firstLineSplitted = firstline.split(" ");          // divide a primeira linha do ficheiro em um array de strings
                    if(firstLineSplitted.length != 3 && firstLineSplitted.length != 2){         // verifica se o formato da primeira linha está correto
                        System.out.println("Erro: Formato errado (Correto: codigo voo, numero de lugares executivos, numero de lugares turistas)");
                        break;
                    }
                    firstLineSplitted[0] = firstLineSplitted[0].substring(1);       // remove o caracter ">" do inicio do ficheiro
                    
                    boolean erro = false;               // variavel para verificar se o voo já existe
                    for (Voo voo : voos) {
                        if(voo.getCodigo().equals(firstLineSplitted[0])){
                            System.out.println("Erro: Voo já existe");
                            erro = true;
                            break;
                        }
                    }
                    if(erro){           // se o voo já existir, sai do ciclo
                        break;
                    }
                    if (firstLineSplitted.length == 3){         // se o voo tiver classe executiva
                        voos.add(new Voo(firstLineSplitted[0], new Aviao(firstLineSplitted[1], firstLineSplitted[2])));     // cria um novo voo
                        while(scFile.hasNextLine()){
                            String line = scFile.nextLine();
                            String[] lineArray = line.split(" ");
    
                            if(lineArray.length != 2){              // verifica se o formato da linha está correto
                                System.out.println("Erro: Formato errado (Correto: Classe, Numero de lugares)");
                                break;
                            }
                            if((lineArray[0].equals("T") && Integer.parseInt(lineArray[1]) > voos.get(voos.size()-1).getAviao().getDisponibilidadeTuristica())          // verifica se o numero de lugares é valido
                            || (lineArray[0].equals("E") && Integer.parseInt(lineArray[1]) > voos.get(voos.size()-1).getAviao().getDisponibilidadeExecutiva())){
                                reservasFalhadas.add(line);         // se o numero de lugares não for valido, adiciona a linha ao array de reservas falhadas
                            } else if (lineArray[0].equals("T") || lineArray[0].equals("E")){
                                char classe = lineArray[0].charAt(0);
                                int lugares = Integer.parseInt(lineArray[1]);
                                voos.get(voos.size()-1).adicionarReserva("I", classe, lugares);             // adiciona a reserva ao voo

                            } else {
                                System.out.println("Erro: Formato errado (Correto: Classe (E/T), Numero de lugares)");
                                break;
                            }
                        }
                    } else if(firstLineSplitted.length == 2){                   // se o voo não tiver classe executiva
                        voos.add(new Voo(firstLineSplitted[0], new Aviao(firstLineSplitted[1])));           // cria um novo voo
                        while(scFile.hasNextLine()){
                            String line = scFile.nextLine();
                            String[] lineArray = line.split(" ");
    
                            if(lineArray.length != 2){              // verifica se o formato da linha está correto
                                System.out.println("Erro: Formato errado (Correto: Classe, Numero de lugares)");
                                break;
                            }
                            if(lineArray[0].equals("E") || (lineArray[0].equals("T") && Integer.parseInt(lineArray[1]) > voos.get(voos.size()-1).getAviao().getDisponibilidadeTuristica())){        // verifica se o numero de lugares é valido ou se a classe é executiva
                                reservasFalhadas.add(line);         // se o numero de lugares não for valido ou se tenta-se fazer uma reserva em classe executiva, adiciona a linha ao array de reservas falhadas
                            } else if (lineArray[0].equals("T")){
                                char classe = lineArray[0].charAt(0);
                                int lugares = Integer.parseInt(lineArray[1]);
                                voos.get(voos.size()-1).adicionarReserva("I", classe, lugares);         // adiciona a reserva ao voo

                            } else {
                                System.out.println("Erro: Formato errado (Correto: Classe (E/T), Numero de lugares)"); 
                                break;
                            }
                        }
                    }else{
                        System.out.println("Erro: Formato errado (Correto: codigo voo, numero de lugares executivos, numero de lugares turistas)");
                        break;
                    }

                    System.out.print(voos.get(voos.size()-1).toString());         // imprime o voo criado
                    if(reservasFalhadas.size() > 0){
                        System.out.print("Não foi possível obter lugares para as reservas: ");          // imprime as reservas falhadas se existirem
                        for(String s: reservasFalhadas){
                            System.out.print(s + " ");
                        }
                    System.out.println();
                    reservasFalhadas.clear();
                    }

                    break;
                case "M":
                    if(inputArray.length != 2){
                        System.out.println("Erro: Número de argumentos inválido");      // verifica se o numero de argumentos está correto
                        break;
                    }

                    for(Voo v: voos){
                        if(v.getCodigo().equals(inputArray[1])){            // verifica se o codigo do voo existe na lista de voos
                            v.exibirMapa();         // imprime o mapa do voo
                            existeVoo = true;
                        }
                    }

                    if(!existeVoo){
                        System.out.println("Erro: Voo não existe");         // se o voo não existir, imprime erro
                    }
                    
                    break;
                case "F":
                    for(Voo v: voos){
                        if(v.getCodigo().equals(inputArray[1])){            // verifica se o codigo do voo existe na lista de voos
                            System.out.println("Erro: Voo já existe");          // se o voo já existir, imprime erro
                            break;
                        }
                    }

                    if(inputArray.length == 3){
                        voos.add(new Voo(inputArray[1], new Aviao(inputArray[2])));         // cria um novo voo sem classe executiva se o numero de argumentos for 3
                        
                    } else if(inputArray.length == 4){
                        voos.add(new Voo(inputArray[1], new Aviao(inputArray[2], inputArray[3])));      // cria um novo voo com classe executiva se o numero de argumentos for 4
                    }
                    else {
                        System.out.println("Erro: Número de argumentos inválido");      // se o numero de argumentos for diferente de 3 ou 4, imprime erro
                        break;
                    }
                    
                    System.out.println("Voo " + inputArray[1] + " criado com sucesso");     // imprime mensagem de sucesso

                    break;
                case "R":
                    if(inputArray.length != 4){
                        System.out.println("Erro: Número de argumentos inválido");      // verifica se o numero de argumentos está correto
                        break;
                    }
                    
                    char classe = inputArray[2].charAt(0);          // guarda a classe da reserva
                    int num_lugares = Integer.parseInt(inputArray[3]);      // guarda o numero de lugares da reserva

                    for(Voo v: voos){
                        if(v.getCodigo().equals(inputArray[1])){            // verifica se o codigo do voo existe na lista de voos
                            v.adicionarReserva("R", classe, num_lugares);       // adiciona a reserva ao voo
                            existeVoo = true;
                            break;
                        }
                    }

                    if(!existeVoo){
                        System.out.println("Erro: Voo não existe");         // se o voo não existir, imprime erro
                    }

                    break;
                case "C":
                    if(inputArray.length != 2){
                        System.out.println("Erro: Número de argumentos inválido");      // verifica se o numero de argumentos está correto
                        break;
                    }

                    String flight_code = inputArray[1].split(":")[0];       // guarda o codigo do voo
                    int reservation_number = Integer.parseInt(inputArray[1].split(":")[1]);     // guarda o numero da reserva

                    for(Voo v: voos){
                        if(v.getCodigo().equals(flight_code)){          // verifica se o codigo do voo existe na lista de voos
                            v.cancelarReserva(reservation_number);      // cancela a reserva
                            existeVoo = true;
                            System.out.println("Reserva " + flight_code + ":" + reservation_number + " cancelada com sucesso");     // imprime mensagem de sucesso
                        }
                    }

                    if(!existeVoo){
                        System.out.println("Erro: Voo não existe");     // se o voo não existir, imprime erro
                    }
                    
                    break;
                case "Q":  
                    System.out.println("Encerrando programa...");         // imprime mensagem de encerramento
                    break;
                default:
                    System.out.println("Comando inválido");         // se o comando não for nenhum dos anteriores, imprime erro
                    break;
            }
        }
        sc.close();

    }
    
}
