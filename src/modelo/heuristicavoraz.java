package modelo;

public class heuristicavoraz {

    private ciudad[] ciudades;
    private int[][] distancias;

    public heuristicavoraz(ciudad[] ciudades, int[][] distancias) {
        this.ciudades = ciudades;
        this.distancias = distancias;
    }

    public String[] rutaMasCorta(String nombreCiudad) {
        // Obtenemos el indice de la ciudad
        int indiceCiudad = -1;
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i].getNombre().equals(nombreCiudad)) {
                indiceCiudad = i;
                break;
            }
        }

        if (indiceCiudad == -1) {
            return new String[0]; // Ciudad no encontrada
        }

        boolean[] visitados = new boolean[ciudades.length];
        int[] rutaMasCorta = new int[ciudades.length];
        rutaMasCorta[0] = indiceCiudad;
        visitados[indiceCiudad] = true;

        int indiceActual = indiceCiudad;

        for (int i = 1; i < ciudades.length; i++) {
            int siguienteIndice = -1;
            int distanciaMinima = Integer.MAX_VALUE;

            for (int j = 0; j < ciudades.length; j++) {
                if (!visitados[j] && distancias[indiceActual][j] < distanciaMinima) {
                    distanciaMinima = distancias[indiceActual][j];
                    siguienteIndice = j;
                }
            }

            if (siguienteIndice == -1) {
                break; // No hay más ciudades por visitar
            }

            rutaMasCorta[i] = siguienteIndice;
            visitados[siguienteIndice] = true;
            indiceActual = siguienteIndice;
        }

        // Convertimos los índices de las ciudades a nombres de ciudades
        String[] ruta = new String[ciudades.length];
        for (int i = 0; i < rutaMasCorta.length; i++) {
            ruta[i] = ciudades[rutaMasCorta[i]].getNombre();
        }

        return ruta;
    }
}
