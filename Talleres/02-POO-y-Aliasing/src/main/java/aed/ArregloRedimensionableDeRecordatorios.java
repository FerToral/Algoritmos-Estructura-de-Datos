package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] recordatorios;
    private int longitud;
    
 

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[10];
        this.longitud = 0;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = new Recordatorio[vector.longitud()];
        for(int i=0; i< vector.longitud; i++ ){
            this.recordatorios[i] = vector.obtener(i);
        }
        this.longitud = vector.longitud();
    }
   
    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        if( longitud == this.recordatorios.length){
            redimencionarRecordatorios(this.longitud*2);
        }
        recordatorios[longitud] = new Recordatorio(i.mensaje(), i.fecha(), i.horario());
        longitud++;
    }

    public Recordatorio obtener(int i) {
        if (i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
         
        return new Recordatorio(recordatorios[i].mensaje(), recordatorios[i].fecha(), recordatorios[i].horario()); 
      
    }

    public void quitarAtras() {
        if (longitud > 0) {
            longitud--;
            recordatorios[longitud] = null; 
        }
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        recordatorios[indice] = new Recordatorio(valor.mensaje(), valor.fecha(), valor.horario());

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }

    private void redimencionarRecordatorios(int nuevaLongitud) {
        Recordatorio[] nuevoArreglo = new Recordatorio[nuevaLongitud];
        for (int i = 0; i < longitud(); i++) {
            nuevoArreglo[i] = this.obtener(i);
        }
        this.recordatorios = nuevoArreglo;
    }

}
