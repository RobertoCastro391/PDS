package lab05.Ex2;

public class Cake {
    private Shape shape = null;
    private String cakeLayer;
    private int numCakeLayers = 1 ;
    private Cream midLayerCream = new Cream("null");
    private Cream topLayerCream;
    private Topping topping;
    private String message;
    
    
    public Cake(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }
    
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void addCakeLayer() {
        this.numCakeLayers++;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(cakeLayer + " cake with " + numCakeLayers + " layers");
        if (!midLayerCream.getCream().equals("null")) {
            sb.append(" and " + midLayerCream + " cream");
        }

        sb.append(", topped with " + topLayerCream + " cream and " + topping + ".");

        if (message.length() != 0) {
            sb.append(" Message says: '" + message + "'.");
        }

        sb.append("\n");

        return sb.toString();
    }
}