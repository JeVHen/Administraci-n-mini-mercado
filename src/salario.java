public class salario {
    
    private int cantidadSalario;
    private Trabajador trabajador;

    public salario(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public int getCantidadSalario() {
        return cantidadSalario;
    }

    public void setCantidadSalario(int cantidadSalario) {
        this.cantidadSalario = cantidadSalario;
    }

        public void calcular() {
        int horas = trabajador.getHoras();
        boolean asistencia = trabajador.isAsistencia();

        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Asistencia: " + asistencia);

        cantidadSalario = horas * 10000;
    }
}