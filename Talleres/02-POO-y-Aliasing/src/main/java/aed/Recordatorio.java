package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha.dia(), fecha.mes()); // Para evitar el aliasing, creamos una nueva instancia de Fecha
        this.horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return new Horario(horario.hora(), horario.minutos());
    }

    public Fecha fecha() {
        return new Fecha(fecha.dia(), fecha.mes());
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(this.mensaje)
               .append(" @ ")
               .append(this.fecha.toString() + " ")
               .append(this.horario.toString());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro) return true;
        if(otro == null || this.getClass() != otro.getClass()) return false;

        Recordatorio otroRecord = (Recordatorio) otro;

        return this.mensaje == otroRecord.mensaje
               && fecha.equals(otroRecord.fecha)
               && horario.equals(otroRecord.horario);

    }

}
