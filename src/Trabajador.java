import java.util.ArrayList;

public class Trabajador extends persona{
    private ArrayList<Trabajador> Trabajadores=new ArrayList<>();
    
    private int horas;
    private boolean asistencia;
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public boolean isAsistencia() {
        return asistencia;
    }
    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
    public Trabajador(int tipoAcceso, String nombre, String idPersona, int horas, boolean asistencia) {
        super(tipoAcceso, nombre, idPersona);
        this.horas = horas;
        this.asistencia = asistencia;
    }
}