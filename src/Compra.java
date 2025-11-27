import javax.swing.*;

public class Compra {

    private Producto producto;
    private cliente cliente;
    private int cantidad;
    private double total;

    public Compra(Producto producto, cliente cliente, int cantidad) {
        this.producto = producto;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.total = producto.getPrice() * cantidad;
    }

    public void imprimirRecibo() {

        String recibo =
                "********** RECIBO DE COMPRA **********\n" +
                "Cliente: " + cliente.getNombre() + "\n" +
                "ID Cliente: " + cliente.getIdPersona() + "\n" +
                "--------------------------------------\n" +
                "Producto: " + producto.getName() + "\n" +
                "ID Producto: " + producto.getIdef() + "\n" +
                "Precio unidad: $" + producto.getPrice() + "\n" +
                "Cantidad: " + cantidad + "\n" +
                "--------------------------------------\n" +
                "TOTAL A PAGAR: $" + total + "\n" +
                "--------------------------------------\n" +
                "Puntos Ganados: " + (cantidad * 10) + "\n" +
                "Puntos Totales: " + cliente.getPuntosCliente() + "\n" +
                "****************************************";

        JOptionPane.showMessageDialog(null, recibo, "Recibo", JOptionPane.INFORMATION_MESSAGE);
    }

    public double getTotal() {
        return total;
    }
}
