import java.util.ArrayList;

public class Administrador extends persona{
    private ArrayList<Administrador> ADMINISTRADORES= new ArrayList<>();
    Administrador a=new Administrador(1, "pepe", "1987", "123Admin");

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
