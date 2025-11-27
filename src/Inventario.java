import javax.swing.*;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // ALERTA DE BAJAS UNIDADES
    public void alertarBajos() {
        StringBuilder alertas = new StringBuilder();

        for (Producto p : productos) {
            if (p.getCantidad() > 0 && p.getCantidad() <= 5) {
                alertas.append("⚠ Producto con pocas unidades:\n")
                        .append(p.getName())
                        .append(" | Unidades: ").append(p.getCantidad())
                        .append("\n\n");
            }
        }

        if (alertas.length() > 0) {
            JOptionPane.showMessageDialog(null, alertas.toString(), "ALERTA DE INVENTARIO", JOptionPane.WARNING_MESSAGE);
        }
    }

    // REGISTRAR PRODUCTO (usa constructor con cantidad)
    public void registrarProducto() {

        String id = JOptionPane.showInputDialog("ID del producto:");
        if (id == null || id.isBlank()) return;

        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        if (nombre == null || nombre.isBlank()) return;

        double precio = 0;
        boolean validoP = false;

        while (!validoP) {
            String inp = JOptionPane.showInputDialog("Precio del producto:");
            if (inp == null) return;
            try {
                precio = Double.parseDouble(inp);
                validoP = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Precio inválido.");
            }
        }

        int cant = 0;
        boolean validoC = false;

        while (!validoC) {
            String inp = JOptionPane.showInputDialog("Cantidad inicial del producto:");
            if (inp == null) return;
            try {
                cant = Integer.parseInt(inp);
                if (cant < 0) throw new Exception();
                validoC = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida.");
            }
        }

        productos.add(new Producto(id, nombre, precio, cant));
        JOptionPane.showMessageDialog(null, "Producto registrado con éxito.");
        alertarBajos(); // alerta después de registrar
    }

    public Producto buscarPorID(String id) {
        for (Producto p : productos) {
            if (p.getIdef().equals(id)) return p;
        }
        return null;
    }

    // REALIZAR VENTA: comprueba unidades y actualiza cantidad; crea Venta y muestra
    public void realizarVenta() {

        alertarBajos(); // alerta ANTES de cualquier venta

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en inventario.");
            return;
        }

        StringBuilder lista = new StringBuilder("Productos disponibles:\n\n");
        for (Producto p : productos) {
            lista.append("- ").append(p.getIdef())
                    .append(" | ").append(p.getName())
                    .append(" | $").append(p.getPrice())
                    .append(" | Unidades: ").append(p.getCantidad())
                    .append("\n");
        }

        String id = JOptionPane.showInputDialog(lista + "\nID del producto a vender:");
        if (id == null) return;

        Producto elegido = buscarPorID(id);
        if (elegido == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        int unidadesSolicitadas = 0;
        boolean validoU = false;

        while (!validoU) {
            String inp = JOptionPane.showInputDialog("Unidades a vender:");
            if (inp == null) return;

            try {
                unidadesSolicitadas = Integer.parseInt(inp);

                if (unidadesSolicitadas <= 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a 0.");
                    continue;
                }

                if (unidadesSolicitadas > elegido.getCantidad()) {
                    JOptionPane.showMessageDialog(null, "Unidades insuficientes.");
                    continue;
                }

                validoU = true;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }

        // RESTAR DEL INVENTARIO
        elegido.setCantidad(elegido.getCantidad() - unidadesSolicitadas);

        // CALCULAR TOTAL
        double total = unidadesSolicitadas * elegido.getPrice();

        // CREAR VENTA (precioUnitario, cantidad)
        Venta venta = new Venta(elegido.getPrice(), unidadesSolicitadas);

        // Mostrar info de la venta (usa el método que ya tienes)
        venta.ejecutarVenta(elegido);

        alertarBajos(); // alerta DESPUÉS de vender
    }
}
