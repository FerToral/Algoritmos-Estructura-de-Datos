package aed;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

public class ABBBordesTests {
    private ArrayList<Integer> recorrer(ABB<Integer> arbol) {
        ArrayList<Integer> valores = new ArrayList<>();
        Iterador<Integer> iterador = arbol.iterador();
        while (iterador.haySiguiente()) {
            assertTrue(valores.size() < arbol.cardinal(), "El iterador debe terminar");
            valores.add(iterador.siguiente());
        }
        assertThrows(NoSuchElementException.class, iterador::siguiente);
        return valores;
    }

    @Test
    public void conjuntoVacioTieneIteradorVacioYRepresentacion() {
        ABB<Integer> arbol = new ABB<>();
        assertFalse(arbol.iterador().haySiguiente());
        assertEquals("{}", arbol.toString());
        assertTrue(recorrer(arbol).isEmpty());
    }

    @Test
    public void eliminarUltimoElementoPermiteVolverAIterar() {
        ABB<Integer> arbol = new ABB<>();
        arbol.insertar(7);
        arbol.eliminar(7);
        assertEquals(0, arbol.cardinal());
        assertTrue(recorrer(arbol).isEmpty());
        arbol.insertar(9);
        assertEquals("{9}", arbol.toString());
    }

    @Test
    public void eliminarRaizConSucesorQueTieneHijoDerecho() {
        ABB<Integer> arbol = new ABB<>();
        for (int valor : new int[]{20, 10, 30, 25, 27, 40}) arbol.insertar(valor);
        arbol.eliminar(20);
        assertEquals(5, arbol.cardinal());
        assertEquals("{10,25,27,30,40}", arbol.toString());
        assertEquals(5, recorrer(arbol).size());
    }

    @Test
    public void duplicadosYEliminacionesInexistentesNoCambianCardinal() {
        ABB<Integer> arbol = new ABB<>();
        arbol.eliminar(1);
        arbol.insertar(3);
        arbol.insertar(3);
        arbol.eliminar(7);
        assertEquals(1, arbol.cardinal());
        assertEquals("{3}", arbol.toString());
    }

    @Test
    public void operacionesReproduciblesCoincidenConTreeSet() {
        ABB<Integer> arbol = new ABB<>();
        TreeSet<Integer> referencia = new TreeSet<>();
        Random azar = new Random(2024);
        for (int i = 0; i < 2000; i++) {
            int valor = azar.nextInt(101) - 50;
            if (azar.nextBoolean()) {
                arbol.insertar(valor);
                referencia.add(valor);
            } else {
                arbol.eliminar(valor);
                referencia.remove(valor);
            }
            assertEquals(referencia.size(), arbol.cardinal());
            assertEquals(referencia.contains(valor), arbol.pertenece(valor));
            assertEquals(new ArrayList<>(referencia), recorrer(arbol));
            if (!referencia.isEmpty()) {
                assertEquals(referencia.first(), arbol.minimo());
                assertEquals(referencia.last(), arbol.maximo());
            }
        }
    }
}
