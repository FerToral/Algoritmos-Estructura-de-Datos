package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        // Completar
        T valor;
        Nodo ant;
        Nodo sig;

        Nodo(T v){
            this.valor = v;
            this.ant = null;
            this.sig = null;
        }
    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(this.primero == null){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else{
            nuevo.sig = primero;
            primero = nuevo;
        }
        
        this.longitud++;

    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(this.primero == null){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else{
            nuevo.ant = this.ultimo;
            this.ultimo.sig = nuevo;
            this.ultimo = nuevo;
        }
        this.longitud++;
    }

    public T obtener(int i) {
        Iterador<T> it = this.iterador();
        int j=0;
        T valor = null;
        while(it.haySiguiente()){
            valor = it.siguiente();
            if(j==i)
                return valor;
            j++;
        }
        return null;

    }


    public void eliminar(int i) {
        Iterador<T> it = this.iterador();
        Nodo actual = primero;
        Nodo prev = primero;

        for(int j=0; it.haySiguiente() && j<i; j++){
            it.siguiente();
            prev = actual;
            actual = actual.sig;
        }
        if(i==0){
            primero = actual.sig;
            if(primero != null)
                primero.ant = null;

        }
        if(i == this.longitud-1){
            Nodo siguiente = actual.sig;
            prev.sig = siguiente;
        
        }
        else{
            Nodo siguiente = actual.sig;
            prev.sig = siguiente;
            siguiente.ant = actual.ant;
            
        }
        this.longitud--;

    }

    public void modificarPosicion(int indice, T elem) {
        Iterador<T> it = this.iterador();
        Nodo actual = primero;

        int j = 0;
       while(it.haySiguiente() && j<=indice){
        it.siguiente();
        if(j == indice)
            actual.valor = elem;
        actual = actual.sig;
       
        j++;
       }
    }

    public ListaEnlazada<T> copiar() {
        return new ListaEnlazada<T>(this);
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Iterador<T> it = lista.iterador();
        while (it.haySiguiente()) {
            this.agregarAtras(it.siguiente());
        }
    }
    
    @Override
    public String toString() {
        Iterador<T> it = this.iterador();
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (it.haySiguiente()) {
            sb.append(it.siguiente());
            if (it.haySiguiente()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        private Nodo actual = primero;
        private Nodo previo = null;

        public boolean haySiguiente() {
	        return this.actual != null;
        }
        
        public boolean hayAnterior() {
	        return this.previo != null;
        }

        public T siguiente() {
            if (this.actual == null) {
                throw new NoSuchElementException("No hay siguiente elemento");
            }
            T valor = this.actual.valor;
            this.previo = this.actual;
            this.actual = this.actual.sig;
            return valor;
        }

        
        public T anterior() {
            if (this.previo == null) {
                throw new NoSuchElementException("No hay elemento anterior");
            }
            this.actual = this.previo;
            this.previo = this.actual.ant;
            return this.actual.valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
