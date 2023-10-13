package lab11.Ex1;

public class Telemovel {
    private String marca;
    private String modelo;
    private String processador;
    private Double preco;
    private Integer MemoriaRAM;
    private Integer MemoriaArmazenamento;
    private Integer camara;
    
    public Telemovel(String marca, String modelo, String processador, Double preco, Integer memoriaRAM, Integer memoriaArmazenamento, Integer camara) {
        this.marca = marca;
        this.modelo = modelo;
        this.processador = processador;
        this.preco = preco;
        MemoriaRAM = memoriaRAM;
        MemoriaArmazenamento = memoriaArmazenamento;
        this.camara = camara;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getMemoriaRAM() {
        return MemoriaRAM;
    }

    public void setMemoriaRAM(Integer memoriaRAM) {
        MemoriaRAM = memoriaRAM;
    }

    public Integer getMemoriaArmazenamento() {
        return MemoriaArmazenamento;
    }

    public void setMemoriaArmazenamento(Integer memoriaArmazenamento) {
        MemoriaArmazenamento = memoriaArmazenamento;
    }

    public Integer getCamara() {
        return camara;
    }

    public void setCamara(Integer camara) {
        this.camara = camara;
    }

    public String getPropriedades(String propriedade) {
        switch(propriedade) {
            case "marca":
                return getMarca();

            case "modelo":
                return getModelo();
            
            case "processador":
                return getProcessador();
            
            case "preço":
                return getPreco().toString();
            
            case "memoriaRAM":
                return getMemoriaRAM().toString();
            
            case "memoriaArmazenamento":
                return getMemoriaArmazenamento().toString();
            
            case "camara":
                return getCamara().toString();

            default:
                return "Propriedade inválida";
        }
    }

    @Override
    public String toString() {
        return "Telemovel [marca=" + marca + ", modelo=" + modelo + ", processador=" + processador + ", preco=" + preco
                + ", MemoriaRAM=" + MemoriaRAM + ", MemoriaArmazenamento=" + MemoriaArmazenamento + ", camara=" + camara
                + "]";
    }
}