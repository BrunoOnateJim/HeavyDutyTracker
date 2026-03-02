package calorias;
import java.io.*;

public class ListaEnlazada<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private class Nodo<T> implements Serializable {
        T objeto;
        Nodo<T> siguiente = null;
        public Nodo(T objeto) { this.objeto = objeto; }
    }

    private Nodo<T> cabeza = null;
    private int largo = 0;

    public void insertarFinal(T objeto) {
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

    public T buscarFecha(String fecha) {
        Nodo<T> puntero = cabeza;
        while (puntero != null) {
            Dias d = (Dias) puntero.objeto;
            if (d.getFecha().equalsIgnoreCase(fecha)) return puntero.objeto;
            puntero = puntero.siguiente;
        }
        return null;
    }

    public String mostrarFechas() {
        if (cabeza == null) return "No hay registros.";
        StringBuilder sb = new StringBuilder();
        Nodo<T> puntero = cabeza;
        while (puntero != null) {
            sb.append(((Dias)puntero.objeto).getFecha()).append("\n");
            puntero = puntero.siguiente;
        }
        return sb.toString();
    }
}
