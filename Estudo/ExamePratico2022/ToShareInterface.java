public interface ToShareInterface {
    public boolean add(Product p);
    public Product remove(String code);
    public Product remove(Product p);
    public boolean share(String code, Client user);
    public boolean share(Product p, Client user);
    public boolean giveBack(String code);
    public boolean giveBack(Product p);
}