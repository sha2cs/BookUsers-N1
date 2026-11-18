import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormMenu extends javax.swing.JFrame {
    // Declaración de componentes
    private JPanel panelPrincipal;
    private JLabel LblTitulo;
    private JButton btnRegistrar;
    private JButton btnListado;
    private JButton btnCreditos;

    // Lista de usuarios
    private ArrayList<Usuario> listaUsuarios;

    // Constructor
    public FormMenu() {
        // 1. Inicializar la lista
        listaUsuarios = new ArrayList<>();

        // 2. Configuración de la ventana
        setTitle("BookUsers - Menu principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Inicializar y configurar componentes
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1)); // Ejemplo de diseño
        setContentPane(panelPrincipal);

        LblTitulo = new JLabel("Menú de Usuarios");
        btnRegistrar = new JButton("Registrar");
        btnListado = new JButton("Listado");
        btnCreditos = new JButton("Créditos");

        // Agregar componentes al panel
        panelPrincipal.add(LblTitulo);
        panelPrincipal.add(btnRegistrar);
        panelPrincipal.add(btnListado);
        panelPrincipal.add(btnCreditos);

        // Configurar acciones de los botones
        btnRegistrar.addActionListener(e -> {
            FormRegistro formReg = new FormRegistro(listaUsuarios);
            formReg.setVisible(true);
        });

        // Ajustar tamaño y visibilidad
        pack();
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
    }

    // Método para obtener el panel (si es necesario)
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    // El método main DEBE estar dentro de la clase
    public static void main(String[] args) {
        // Ejecutar la interfaz en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new FormMenu();
        });
    }
}

