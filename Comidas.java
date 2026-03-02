
public class Comidas {
    private String nombre;
    private double calorias;
    private double proteinas;
    private double carbohidratos;
    private double grasa;

    public Comidas(String nombre, double calorias, double proteinas, double carbohidratos, double grasa){
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasa = grasa;
    }

    public String getNombre(){
        return nombre;
    }
    public double getCalorias(){
        return calorias;
    }
    public double getProteinas(){
        return proteinas;
    }
    public double getCarbohidratos(){
        return carbohidratos;
    }
    public double getGrasa(){
        return grasa;
    }

    public String toString(){
        return "Nombre: " + nombre + "\nCalorias: " + calorias + "\nProteinas: " + proteinas + "\nCarbohidratos: " + carbohidratos + "\nGrasa: " + grasa;
    }
}
