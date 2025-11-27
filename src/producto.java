public class Producto {
    private String idef;
    private String name;
    private double price;
    private int cantidad;           // NUEVO
    private boolean disponibilidad;

    // Constructor nuevo (con cantidad)
    public Producto(String idef, String name, double price, int cantidad) {
        this.idef = idef;
        this.name = name;
        this.price = price;
        this.cantidad = Math.max(0, cantidad);
        this.disponibilidad = this.cantidad > 0;
    }

    // Constructor antiguo (por compatibilidad) -> mantiene comportamiento anterior
    public Producto(String idef, String name, double price, boolean disponibilidad) {
        this.idef = idef;
        this.name = name;
        this.price = price;
        this.disponibilidad = disponibilidad;
        this.cantidad = disponibilidad ? 1 : 0; // si se usaba disponibilidad, asumimos 1 unidad si true
    }

    // Getters y setters
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

    // Nuevo getter/setter de cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = Math.max(0, cantidad);
        this.disponibilidad = this.cantidad > 0;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
        if (!disponibilidad) this.cantidad = 0;
        else if (this.cantidad == 0) this.cantidad = 1; // si lo activan y no hay cantidad, dejamos 1 por compatibilidad
    }
}
