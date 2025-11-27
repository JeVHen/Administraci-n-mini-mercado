import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Menu {

    static ArrayList<Trabajador> trabajadores = new ArrayList<>();

    public static void main(String[] args) {
        menuAdministrador();
    }

    public static void menuAdministrador() {
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "===== MENÚ ADMINISTRADOR =====\n" +
                    "1. Registrar trabajador\n" +
                    "2. Ver trabajadores\n" +
                    "3. Salir\n\n" +
                    "Seleccione una opción:"
            ));

            switch (opcion) {
                case 1 -> registrarTrabajador();
                case 2 -> mostrarTrabajadores();
                case 3 -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    // ----------------------------------------------------
    // REGSTRAR TRABAJADOR
    // ----------------------------------------------------
    public static void registrarTrabajador() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del trabajador:");
            String id = JOptionPane.showInputDialog("ID del trabajador:");

            int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas trabajadas:"));

            int asis = JOptionPane.showConfirmDialog(null, "¿Asistió hoy?", "Asistencia",
                    JOptionPane.YES_NO_OPTION);

            boolean asistencia = (asis == JOptionPane.YES_OPTION);

            Trabajador t = new Trabajador(2, nombre, id, horas, asistencia);
            trabajadores.add(t);

            JOptionPane.showMessageDialog(null, "Trabajador registrado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar trabajador.");
        }
    }

    // MOSTRAR TRABAJADORs
    
    public static void mostrarTrabajadores() {
        if (trabajadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay trabajadores registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder("===== TRABAJADORES REGISTRADOS =====\n");

        for (Trabajador t : trabajadores) {
            lista.append("Nombre: ").append(t.getNombre()).append("\n")
                    .append("ID: ").append(t.getIdPersona()).append("\n")
                    .append("Horas: ").append(t.getHoras()).append("\n")
                    .append("Aistencia: ").append(t.isAsistencia() ? "Sí" : "No").append("\n")
                    .append("-------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
