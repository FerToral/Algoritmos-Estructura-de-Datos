package aed;

public class Horario {

    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(this.hora+":"+this.minutos);

        return sbuffer.toString();

    }

    @Override
    public boolean equals(Object otro) {
        if( this == otro) return true;
        if( otro == null || this.getClass() != otro.getClass()) return false;

        Horario otroHorario = (Horario) otro;
        return this.hora == otroHorario.hora && this.minutos == otroHorario.minutos; 
    }

}
