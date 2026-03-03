package calorias;
import java.io.*;

public class ListaEnlazada<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private class Nodo<T> implements Serializable {
        private static final long serialVersionUID = 1L;
        T objeto;
        Nodo<T> siguiente = null;
        public Nodo(T objeto) { this.objeto = objeto; }
    }

    private Nodo<T> cabeza = null;
    private int largo = 0;

    public double getTotalCalorias() {
        double total = 0;
        Nodo<T> puntero = cabeza;
        while (puntero != null) {
            if (puntero.objeto instanceof Comidas) {
                total += ((Comidas) puntero.objeto).getCalorias();
            }
            puntero = puntero.siguiente;
        }
        return total;
    }

    public double getTotalProteinas() {
        double total = 0;
        Nodo<T> puntero = cabeza;
        while (puntero != null) {
            if (puntero.objeto instanceof Comidas) {
                total += ((Comidas) puntero.objeto).getProteinas();
            }
            puntero = puntero.siguiente;
        }
        return total;
    }

    public double getTotalCarbohidratos() {
        double total = 0;
        Nodo<T> puntero = cabeza;
        while (puntero != null) {
            if (puntero.objeto instanceof Comidas) {
                total += ((Comidas) puntero.objeto).getCarbohidratos();
            }
            puntero = puntero.siguiente;
        }
        return total;
    }

    public double getTotalGrasas() {
        double total = 0;
        Nodo<T> puntero = cabeza;
        while (puntero != null) {
            if (puntero.objeto instanceof Comidas) {
                total += ((Comidas) puntero.objeto).getGrasa();
            }
            puntero = puntero.siguiente;
        }
        return total;
    }

    public void insertar(T objeto) {
        Nodo<T> nodoA = new Nodo<>(objeto);
        if (cabeza == null) {
            cabeza = nodoA;
        } else {
            Nodo<T> puntero = cabeza;
            while (puntero.siguiente != null) puntero = puntero.siguiente;
            puntero.siguiente = nodoA;
        }
        largo++;
    }

    public void reiniciar() {
        cabeza = null;
        largo = 0;
    }
}
