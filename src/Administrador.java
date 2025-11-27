public class Administrador extends persona {
    
    String contraseña;

    public Administrador(int tipoAcceso, String nombre, String idPersona, String contraseña) {
        super(tipoAcceso, nombre, idPersona);
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
