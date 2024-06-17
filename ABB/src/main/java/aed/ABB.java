package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private int size;
    private Nodo root;

    private class Nodo {
        // Agregar atributos privados del Nodo
        Nodo parent;
        Nodo left;
        Nodo right;
        T key;

        // Crear Constructor del nodo

        public Nodo(T elem, Nodo parent){
            this.key = elem;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }
    }

    public ABB() {
        this.size = 0;
        this.root = null;
    }

    public int cardinal() {
        return this.size;
    }

    public T minimo() {
        if (root == null) {
            throw new NoSuchElementException("El ABB está vacío.");
        }
        return minimo(root).key;
    }

    private Nodo minimo(Nodo nodo) {
        while (nodo.left != null) {
            nodo = nodo.left;
        }
        return nodo;
    }
    public T maximo(){
        if (root == null) {
            throw new NoSuchElementException("El ABB está vacío.");
        }
        Nodo actual = root;
        while(actual.right != null)
            actual = actual.right;
        return actual.key;

    }

    public void insertar(T elem){
       
        if(this.root == null){
            this.root = new Nodo(elem, null);
            size++;
        }else{
            Nodo lastNodo = buscar(this.root, elem);
            
            if(elem.compareTo(lastNodo.key) < 0){
                lastNodo.left = new Nodo(elem, lastNodo);
            }else if(elem.compareTo(lastNodo.key) > 0){
                lastNodo.right = new Nodo(elem, lastNodo);
            }else{
                return;
            }
            size++;
        }
    }

    private Nodo buscar(Nodo nodo, T elem){

        if (nodo == null || elem == null) {
            return null;
        }
        int cmp = elem.compareTo(nodo.key);
        if (cmp < 0) {
            return nodo.left!=null? buscar(nodo.left, elem) : nodo;
        } else if (cmp > 0) {
            return nodo.right!=null? buscar(nodo.right, elem) : nodo;
        } else {
            return nodo;
        }
    }
    public boolean pertenece(T elem){
        if(this.root == null){
            return false;
        }
        Nodo lastNodo = buscar(this.root, elem);
        return elem.compareTo(lastNodo.key) == 0;
      
    }

    public void eliminar(T elem){
        Nodo lastNodo = buscar(this.root, elem);
        if(lastNodo == null || elem.compareTo(lastNodo.key) != 0 ){
            return;
        }else{
            eliminarNodo(lastNodo);
            size--;
           
        }
    }
    private void eliminarNodo(Nodo nodo){
        if(nodo.left == null && nodo.right == null){
            Nodo parent = nodo.parent;
            if(parent == null)
                this.root = null;
            else if(parent.left == nodo)
                parent.left = null;
            else
                parent.right = null;
        }
        else if(nodo.left != null && nodo.right != null){

            Nodo sucesor = sucesor(nodo);
            nodo.key = sucesor.key;
            this.eliminarNodo(sucesor);
            
        }
        else{
            Nodo son = (nodo.left!=null)? nodo.left: nodo.right;
            Nodo parent = nodo.parent;
            if(parent == null)
                this.root = son;
            else if(parent.left == nodo)
                parent.left = son;
            else
                parent.right = son;

            son.parent = nodo.parent;
        }
    }
    private Nodo sucesor(Nodo nodo) {
        if (nodo.right != null) {
            return minimo(nodo.right);
        }
        Nodo parent = nodo.parent;
        while (parent != null && nodo == parent.right) {
            nodo = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        Iterador<T> iter = this.iterador();
        while (iter.haySiguiente()) {
            sb.append(iter.siguiente());
            if (iter.haySiguiente()) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual = minimo(root);

        public boolean haySiguiente() {            
            return _actual != null;
        }
    
        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException();
            }
            T key = _actual.key;
            _actual = sucesor(_actual);
            return key;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
