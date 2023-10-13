import java.io.FileReader;
import java.util.Scanner;

public class ReadProduct extends ToShare {
    
    public static void ReadProducts(String file) { 
        
        try {
			Scanner sc = new Scanner(new FileReader(file));

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
                System.out.println(line);
                // if (line[0].equals("Car")) {
                //     Car c = new Car(line[1], line[2], Integer.parseInt(line[3]));
                //     AllProducts.add(c);
                //     AvailableProducts.add(c);
                // } else if (line[0].equals("Van")) {
                //     Van v = new Van(line[1], line[2], Integer.parseInt(line[3]));
                //     AllProducts.add(v);
                //     AvailableProducts.add(v);
                // } else if (line[0].equals("Motorcycle")) {
                //     Motorcycle m = new Motorcycle(line[1], line[2], Integer.parseInt(line[3]));
                //     AllProducts.add(m);
                //     AvailableProducts.add(m);
                // }
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
