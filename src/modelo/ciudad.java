package modelo;

public class ciudad {

    private String nombre;
    private String[] vecinos;
    private int[] distancias;
    private int indice;
    private int[] coordenadas;

    public ciudad(String nombre, String[] vecinos, int[] distancias, int indice, int[] coordenadas) {
        this.nombre = nombre;
        this.vecinos = vecinos;
        this.distancias = distancias;
        this.indice = indice;
        this.coordenadas = coordenadas;
    }


    public String getNombre() {
        return nombre;
    }

    public String[] getVecinos() {
        return vecinos;
    }

    public int getIndice(){
        return this.indice;
    }

    public int[] getDistancias() {
        return distancias;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    

}
