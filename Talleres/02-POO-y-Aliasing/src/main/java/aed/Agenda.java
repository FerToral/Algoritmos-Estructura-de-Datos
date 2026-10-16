package aed;

public class Agenda {
    private Fecha fechaDiaDeHoy;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaDiaDeHoy = new Fecha(fechaActual);
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(fechaDiaDeHoy.toString()).append("\n");
        sbuffer.append("=====\n");
        for(int i=0; i<recordatorios.longitud(); i++){
            if(fechaDiaDeHoy.equals(this.recordatorios.obtener(i).fecha())){
                sbuffer.append(this.recordatorios.obtener(i).toString()).append("\n");
            }
        }

        return sbuffer.toString();

    }

    public void incrementarDia() {
        this.fechaDiaDeHoy.incrementarDia();

    }

    public Fecha fechaActual() {
        return new Fecha(this.fechaDiaDeHoy);
    }

}
