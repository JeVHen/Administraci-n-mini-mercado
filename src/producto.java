class Producto{
    private String idef;
    private String name;
    private double price;
    private boolean disponibilidad;
    public String getIdef() {
        return idef;
    }
    public void setIdef(String idef) {
        this.idef = idef;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public Producto(String idef, String name, double price, boolean disponibilidad) {
        this.idef = idef;
        this.name = name;
        this.price = price;
        this.disponibilidad = disponibilidad;
    } 
}