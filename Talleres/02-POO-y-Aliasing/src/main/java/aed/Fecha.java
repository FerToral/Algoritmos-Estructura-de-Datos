package aed;

public class Fecha {
    private int dia;
    private int mes;
    public Fecha(int dia, int mes) {
       this.dia = dia;
       this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(this.dia+"/"+this.mes);

        return sbuffer.toString();
       
    }

    @Override
    public boolean equals(Object otra) {
        if( this == otra) return true;
        if( otra == null || this.getClass() != otra.getClass()) return false;

        Fecha otraFecha = (Fecha) otra;
        return this.dia == otraFecha.dia && this.mes == otraFecha.mes; 

    }

    public void incrementarDia() {
        int diasEnMes = this.diasEnMes(this.mes);
        if(this.dia < diasEnMes){
            this.dia++;
        }
        else{
            this.dia = 1;
            this.mes++;
            if(this.mes > 12){
                this.mes = 1;
        
            }
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
