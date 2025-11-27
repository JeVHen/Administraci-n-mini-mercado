import javax.swing.*;
import java.util.ArrayList;

public class principal {

    public static void main(String args[]) {

        ArrayList<Administrador> administradores = new ArrayList<>();
        ArrayList<cliente> clientes = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        Inventario inventario = new Inventario(productos);

        // Admin inicial
        administradores.add(new Administrador(
                1,
                "admin",
                "0001",
                "1234"
        ));

        while (true) {

            inventario.alertarBajos(); // alerta en cada ciclo

            String opc = JOptionPane.showInputDialog(
                    "===== SISTEMA DE TIENDA =====\n" +
                    "1. Administrador\n" +
                    "2. Trabajador\n" +
                    "3. Salir\n" +
                    "Seleccione opción:"
            );

            if (opc == null) break;

            switch (opc) {
                case "1":
                    loginAdmin(administradores, clientes, inventario, trabajadores);
                    break;
                case "2":
                    menuTrabajador(clientes, inventario);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    /*para hacerle inicio al admin con el log in */

    public static void loginAdmin(ArrayList<Administrador> admins, ArrayList<cliente> clientes,Inventario inventario, ArrayList<Trabajador> trabajadores) {

        String id = JOptionPane.showInputDialog("Digite ID de administrador:");
        if (id == null) return;

        String pass = JOptionPane.showInputDialog("Digite contraseña:");
        if (pass == null) return;

        for (Administrador a : admins) {
            if (a.getIdPersona().equals(id) && a.getContraseña().equals(pass)) {
                menuAdmin(admins, clientes, inventario, trabajadores);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Datos incorrectos");
    }

/*menú para los administradores */

    public static void menuAdmin(ArrayList<Administrador> admins, ArrayList<cliente> clientes,
                                 Inventario inventario, ArrayList<Trabajador> trabajadores) {

        while (true) {

            inventario.alertarBajos();

            String op = JOptionPane.showInputDialog(
                    "===== ADMINISTRADOR =====\n" +
                    "1. Registrar Trabajador\n" +
                    "2. Registrar Producto\n" +
                    "3. Registrar Administrador\n" +
                    "4. Mostrar Productos\n" +
                    "5. Mostrar Trabajadores\n" +
                    "6. Volver"
            );

            if (op == null) return;

            switch (op) {

                /*registramos trabajador */
                
                case "1":
                    String nombT = JOptionPane.showInputDialog("Nombre del trabajador:");
                    if (nombT == null || nombT.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nombre inválido.");
                        break;
                    }

                    String idT = JOptionPane.showInputDialog("ID del trabajador:");
                    if (idT == null || idT.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ID inválido.");
                        break;
                    }

                    int horas = 0;
                    boolean validoH = false;
                    while (!validoH) {
                        String h = JOptionPane.showInputDialog("Horas trabajadas:");
                        if (h == null) return;
                        try {
                            horas = Integer.parseInt(h);
                            validoH = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                        }
                    }

                    boolean asistencia = JOptionPane.showConfirmDialog(
                            null, "¿Asistió hoy?", "Asistencia", JOptionPane.YES_NO_OPTION
                    ) == JOptionPane.YES_OPTION;

                    trabajadores.add(new Trabajador(2, nombT, idT, horas, asistencia));
                    JOptionPane.showMessageDialog(null, "Trabajador registrado correctamente.");
                    break;

                /*regitrar producto */

                case "2":
                    inventario.registrarProducto();
                    break;

                /*regstarr administrador */
                
                case "3":
                    String nombA = JOptionPane.showInputDialog("Nombre del administrador:");
                    if (nombA == null || nombA.trim().isEmpty()) break;

                    String idA = JOptionPane.showInputDialog("ID del administrador:");
                    if (idA == null || idA.trim().isEmpty()) break;

                    String contra = JOptionPane.showInputDialog("Contraseña:");
                    if (contra == null || contra.trim().isEmpty()) break;

                    admins.add(new Administrador(1, nombA, idA, contra));
                    JOptionPane.showMessageDialog(null, "Administrador registrado correctamente.");
                    break;

                /*mostrar prodcutos */

                case "4":
                    if (inventario.getProductos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay productos registrados.");
                        break;
                    }
//jeje
/*de qué te ries */
//nada

                    String listaP = "PRODUCTOS REGISTRADOS:\n\n";

                    for (Producto p : inventario.getProductos()) {

                    listaP = listaP + "- ID: " + p.getIdef()
                    + " | Nombre: " + p.getName()
                    + " | Precio: $" + p.getPrice()
                    + " | Cantidad: " + p.getCantidad()
                    + "\n";
                    }

JOptionPane.showMessageDialog(null, listaP);

                    JOptionPane.showMessageDialog(null, listaP.toString());
                    break;

                //mostrar trabajadores
                
                case "5":
                    if (trabajadores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay trabajadores registrados.");
                        break;
                    }

                    StringBuilder listaT = new StringBuilder("TRABAJADORES REGISTRADOS:\n\n");

                    String listaT = "";

                    for (Trabajador t : trabajadores) {

                        listaT = listaT + "Nombre: " + t.getNombre() + "\n";
                        listaT = listaT + "ID: " + t.getIdPersona() + "\n";
                        listaT = listaT + "Horas: " + t.getHoras() + "\n";
                        if (t.isAsistencia()) {
                            listaT = listaT + "Asistencia: Sí\n";
                        }else{
                            listaT = listaT + "Asistencia: No\n";
                        }
                        listaT = listaT + "-------------------------------------\n";
                    }


                    JOptionPane.showMessageDialog(null, listaT.toString());
                    break;

                case "6":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    //menú para trabajador
    
    public static void menuTrabajador(ArrayList<cliente> clientes, Inventario inventario) {

        while (true) {

            inventario.alertarBajos();

            String op = JOptionPane.showInputDialog(
                    "===== TRABAJADOR =====\n" +
                    "1. Registrar Cliente\n" +
                    "2. Venta\n" +
                    "3. Volver"
            );

            if (op == null) return;

            switch (op) {

                case "1":
                    String n = JOptionPane.showInputDialog("Nombre cliente:");
                    if (n == null || n.trim().isEmpty()) break;

                    String id = JOptionPane.showInputDialog("ID:");
                    if (id == null || id.trim().isEmpty()) break;

                    clientes.add(new cliente(3, n, id));
                    JOptionPane.showMessageDialog(null, "Cliente registrado.");
                    break;

                case "2":
                    inventario.realizarVenta();
                    break;

                case "3":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
