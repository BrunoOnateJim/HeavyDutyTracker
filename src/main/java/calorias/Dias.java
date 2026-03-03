package calorias;
import java.io.Serializable;

public class Dias implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fecha;
    private ListaEnlazada<Comidas> listaComidas;
    private double calT;
    private double proT;
    private double carbT;
    private double grasT;

    public Dias(String fecha, ListaEnlazada<Comidas> listacomidas, double calT, double proT, double carbT, double grasT){
        this.fecha = fecha;
        this.listaComidas = listacomidas;
        this.calT = calT;
        this.proT = proT;
        this.carbT = carbT;
        this.grasT = grasT;
    }

    public String getFecha(){
        return fecha;
    }

    @Override
    public String toString(){
        return "Fecha: "+fecha+"\n Calorias totales: "+calT+"\n Proteinas totales: "+proT+"\n Carbohidratos totales: "+carbT+"\n Grasa totales: "+grasT;
    }
}
