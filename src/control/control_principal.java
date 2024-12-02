package control;

import modelo.ciudad;
import modelo.heuristicavoraz;
import vista.Interfaz_Principal;

public class control_principal {

 private heuristicavoraz heuristica;
 private ciudad[] ciudades;
 private Interfaz_Principal interfaz;

public control_principal(heuristicavoraz heuristica, ciudad[] ciudades, Interfaz_Principal interfaz) {
    this.heuristica = heuristica;
    this.ciudades = ciudades;
    this.interfaz = interfaz;
}

public void iniciar() {
    interfaz.setVisible(true);
    interfaz.setControlador(this);
    interfaz.setCiudades(ciudades);

}

public void buscarRuta(String nombreCiudad) {
    String[] ruta = heuristica.rutaMasCorta(nombreCiudad);
    interfaz.limpia();
    interfaz.borraRecorrido();
    
    interfaz.mostrarRuta(ruta);


}
}
