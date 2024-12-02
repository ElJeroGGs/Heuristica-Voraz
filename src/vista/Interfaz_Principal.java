package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import modelo.ciudad;

public class Interfaz_Principal extends JFrame {

    private JComboBox<String> listaEstados;
    private JButton botonBuscar;
    private control.control_principal control;
    private MapaPanel mapaPanel;
    private ciudad[] ciudades;
    private DefaultListModel<String> listaCiudadesModel;
    private JList<String> listaCiudades;

    public void setCiudades(ciudad[] ciudades) {
        this.ciudades = ciudades;
    }

    public Interfaz_Principal() {
        setTitle("Mapa de México");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
       

       

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        // Crear el panel superior con la lista de estados y el botón
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        // Lista de estados
// Lista de estados
String[] estados = {"Ciudad de México","Guadalajara", "Ciudad Juarez", "Tijuana", "Zapopan", "Monterrey", "Chihuahua", "Merida", "San Luis Potosi", "Aguascalientes", "Hermosillo", "Saltillo", "Mexicali", "Culiacan", "Acapulco de Juarez"};
listaEstados = new JComboBox<>(estados);

        
        panelSuperior.add(listaEstados);

        // Botón de buscar
        botonBuscar = new JButton("Buscar");
        panelSuperior.add(botonBuscar);

        // Añadir el panel superior al panel principal
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Crear el panel del mapa
        mapaPanel = new MapaPanel();
        panelPrincipal.add(mapaPanel, BorderLayout.CENTER);

        // Añadir el panel principal al frame
        add(panelPrincipal);

         // Crear el panel de la lista de ciudades recorridas
         listaCiudadesModel = new DefaultListModel<>();
         listaCiudades = new JList<>(listaCiudadesModel);
         JScrollPane scrollPane = new JScrollPane(listaCiudades);
         scrollPane.setPreferredSize(new Dimension(200, 0));
         panelPrincipal.add(scrollPane, BorderLayout.EAST);
 
         // Añadir el panel principal al frame
         add(panelPrincipal);

        // Añadir el listener al botón de buscar
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estadoSeleccionado = (String) listaEstados.getSelectedItem();
                control.buscarRuta(estadoSeleccionado);
            }
        });
    }

    

    public void setControlador(control.control_principal controlador) {
        this.control = controlador;
    }

    public void mostrarRuta(String[] ruta) {
        java.util.List<ciudad> rutaCiudades = new java.util.ArrayList<>();
        for (String nombreCiudad : ruta) {
            int indiceCiudad = -1;
            for (int i = 0; i < ciudades.length; i++) {
                if (ciudades[i].getNombre().equals(nombreCiudad)) {
                    indiceCiudad = i;
                    break;
                }
            }
            ciudad ciudad = ciudades[indiceCiudad];
            rutaCiudades.add(ciudad);
        }

        mapaPanel.setRuta(rutaCiudades);
    }

    public void borraRecorrido() {
            listaCiudadesModel.clear();
    }


    class MapaPanel extends JPanel {
        private java.util.List<ciudad> ruta;
        private int currentIndex = 0;
        private Timer timer;

        public MapaPanel() {
            this.ruta = new java.util.ArrayList<>();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    System.out.println("Coordenadas: (" + x + ", " + y + ")");
                    JOptionPane.showMessageDialog(null, "Coordenadas: (" + x + ", " + y + ")");
                }
            });
        }

        public void setRuta(java.util.List<ciudad> ruta) {
            this.ruta = ruta;
            this.currentIndex = 0;
            if (timer != null) {
                timer.stop();
            }
            timer = new Timer(750, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex < ruta.size() - 1) {
                        currentIndex++;
                        listaCiudadesModel.addElement(ruta.get(currentIndex).getNombre());
                        repaint();
                    } else {
                        timer.stop();
                    }
                }
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar el mapa (ejemplo)
            g.drawImage(new ImageIcon("src\\vista\\images\\mapa mexico-01.png").getImage(), 0, 0, this);

 // Convertir Graphics a Graphics2D
 Graphics2D g2d = (Graphics2D) g;

 // Establecer el grosor de la línea
 g2d.setStroke(new BasicStroke(2)); // Cambia el valor para ajustar el grosor

            // Dibujar la ruta progresivamente
            g2d.setColor(Color.RED);
            for (int i = 0; i < currentIndex; i++) {
                ciudad estado1 = ruta.get(i);
                ciudad estado2 = ruta.get(i + 1);
                g2d.drawLine(estado1.getCoordenadas()[0], estado1.getCoordenadas()[1], estado2.getCoordenadas()[0], estado2.getCoordenadas()[1]);
            }
        }
    }


    public void limpia() {
   borraRecorrido();
   mapaPanel.repaint();
    }
}
