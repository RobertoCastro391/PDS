public class Jeep implements Product {
    private String code;
    private String descricion;
    private double point;

    public Jeep(OldJeep oldj) {
        String[] data = oldj.getData().split(";");
        this.code = data[0];
        this.descricion = data[1];
        this.point = Double.parseDouble(data[2]);
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
        return "Jeep [code=" + code + ", descricion=" + descricion + ", point=" + point + "]";
    }
}