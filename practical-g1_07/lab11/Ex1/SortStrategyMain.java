package lab11.Ex1;

import java.util.ArrayList;

public class SortStrategyMain {
    public static void main(String[] args) {
        SortStrategy QuickSortstrategy = new QuickSort();
        SortStrategy InsertionSortstrategy = new InsertionSort();
        SortStrategy BubbleSortstrategy = new BubbleSort();

        Telemovel t1 = new Telemovel("Iphone", "13 Pro Max", "A15 Bionic", 1000.0, 16, 256, 16);
        Telemovel t2 = new Telemovel("Samsung", "Galaxy S10+", "2.7 GHz, 2.3 GHz, 1.9 GHz", 600.0, 8, 128, 12);
        Telemovel t3 = new Telemovel("Xiaomi", "Mi 11", "Qualcomm Snapdragon 888", 800.0, 8, 128, 12);
        Telemovel t4 = new Telemovel("Huawei", "P40 Pro", "Kirin 990 5G", 700.0, 8, 128, 12);
        Telemovel t5 = new Telemovel("OnePlus", "9 Pro", "Qualcomm Snapdragon 888", 900.0, 8, 128, 12);
        Telemovel t6 = new Telemovel("Google", "Pixel 5", "Qualcomm Snapdragon 765G", 700.0, 8, 128, 12);
        Telemovel t7 = new Telemovel("Sony", "Xperia 1 III", "Qualcomm Snapdragon 888", 1200.0, 12, 256, 12);
        Telemovel t8 = new Telemovel("LG", "Wing", "Qualcomm Snapdragon 765G", 1000.0, 8, 128, 12);
        

        ArrayList<Telemovel> listTelemoveis1 = new ArrayList<Telemovel>();
        ArrayList<Telemovel> listTelemoveis2 = new ArrayList<Telemovel>();
        ArrayList<Telemovel> listTelemoveis3 = new ArrayList<Telemovel>();

        listTelemoveis1.add(t1);
        listTelemoveis1.add(t6);
        listTelemoveis1.add(t7);

        listTelemoveis2.add(t3);
        listTelemoveis2.add(t5);
        listTelemoveis2.add(t8);

        listTelemoveis3.add(t2);
        listTelemoveis3.add(t4);

        RevistaEletronica revista1 = new RevistaEletronica("Revista de Eletrónica Aveiro", QuickSortstrategy, listTelemoveis1);
        RevistaEletronica revista2 = new RevistaEletronica("Revista de Eletrónica Lisboa", InsertionSortstrategy, listTelemoveis2);
        RevistaEletronica revista3 = new RevistaEletronica("Revista de Eletrónica Porto", BubbleSortstrategy, listTelemoveis3);

        System.out.println("----------QuickSortSort-----------------------------------------");
        
        System.out.println("\t Marca: ");
        revista1.sort("marca");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Modelo: ");
        revista1.sort("modelo");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Processador: ");
        revista1.sort("processador");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);
            
        System.out.println("\t Preço: ");
        revista1.sort("preço");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Memoria RAM: ");
        revista1.sort("memoriaRAM");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Memoria: ");
        revista1.sort("memoriaArmazenamento");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Câmara: ");
        revista1.sort("camara");
        for (Telemovel tel: listTelemoveis1)
            System.out.println("\t\t\t" + tel);
        
        System.out.println("----------------------------------------------------------");

        System.out.println("----------InsertionSort-----------------------------------------");
        System.out.println("\t Nome: ");
        
        System.out.println("\t Marca: ");
        revista2.sort("marca");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Modelo: ");
        revista2.sort("modelo");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Processador: ");
        revista2.sort("processador");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);
            
        System.out.println("\t Preço: ");
        revista2.sort("preço");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Memoria RAM: ");
        revista2.sort("memoriaRAM");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Memoria: ");
        revista2.sort("memoriaArmazenamento");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Câmara: ");
        revista2.sort("camara");
        for (Telemovel tel: listTelemoveis2)
            System.out.println("\t\t\t" + tel);

        System.out.println("----------------------------------------------------------");

        System.out.println("----------BubbleSort-----------------------------------------");
        System.out.println("\t Marca: ");
        revista3.sort("marca");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Modelo: ");
        revista3.sort("modelo");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Processador: ");
        revista3.sort("processador");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);
            
        System.out.println("\t Preço: ");
        revista3.sort("preço");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Memoria RAM: ");
        revista3.sort("memoriaRAM");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Memoria: ");
        revista3.sort("memoriaArmazenamento");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);

        System.out.println("\t Câmara: ");
        revista3.sort("camara");
        for (Telemovel tel: listTelemoveis3)
            System.out.println("\t\t\t" + tel);
        System.out.println("----------------------------------------------------------");
    }
}