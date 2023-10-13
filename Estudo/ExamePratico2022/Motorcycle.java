public class Motorcycle implements Product {
    private String code;
    private String descricion;
    private double point;

    public Motorcycle(String code, String descricion, double point) {
        this.code = code;
        this.descricion = descricion;
        this.point = point;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return descricion;
    }

    @Override
    public double points() {
        return point;
    }

    @Override
    public String toString() {
        return "Motorcycle [code=" + code + ", descricion=" + descricion + ", point=" + point + "]";
    }
}