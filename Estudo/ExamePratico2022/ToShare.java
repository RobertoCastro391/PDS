import java.util.ArrayList;
import java.util.HashMap;

public class ToShare implements ToShareInterface {
    ArrayList<Product> AllProducts;
    ArrayList<Product> AvailableProducts;
    HashMap<Product, Client> SharedProducts;

    public ToShare() {
        AllProducts = new ArrayList<Product>();
        AvailableProducts = new ArrayList<Product>();
        SharedProducts = new HashMap<Product, Client>();
    }

    @Override
    public boolean add(Product p) {
        AllProducts.add(p);
        AvailableProducts.add(p);
        return true;
    }

    @Override
    public Product remove(String code) {
        for (Product p : AllProducts) {
            if (p.code().equals(code)) {
                AllProducts.remove(p);
                AvailableProducts.remove(p);
                return p;
            }
        }
        return null;
    }

    @Override
    public Product remove(Product p) {
        AllProducts.remove(p);
        AvailableProducts.remove(p);
        return p;
    }

    @Override
    public boolean share(String code, Client user) {
        for (Product p : AllProducts) {
            if (p.code().equals(code)) {
                AvailableProducts.remove(p);
                SharedProducts.put(p, user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean share(Product p, Client user) {
        AvailableProducts.remove(p);
        SharedProducts.put(p, user);
        return true;
    }

    @Override
    public boolean giveBack(String code) {
        for (Product p : AllProducts) {
            if (p.code().equals(code)) {
                AvailableProducts.add(p);
                SharedProducts.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean giveBack(Product p) {
        AvailableProducts.add(p);
        SharedProducts.remove(p);
        return true;
    }

    public int totalProducts() {
        return AllProducts.size();
    }

    public ArrayList<Product> getProducts() {
        return AllProducts;
    }

    public String sharedProducts(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total: " + SharedProducts.size() + "\n");
        for (Product p : SharedProducts.keySet()) {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }
}