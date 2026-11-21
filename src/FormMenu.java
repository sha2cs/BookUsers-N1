import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormMenu extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnRegistrar, btnListado, btnCreditos;
    // La única lista de toda la aplicación
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public FormMenu() {
        setTitle("BookUsers · Nombre Apellido y Nombre Apellido"); // <-- pon sus nombres
        panelPrincipal = new JPanel(new GridLayout(3, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        btnRegistrar = new JButton("Registrar usuario");
        btnListado = new JButton("Ver listado");
        btnCreditos = new JButton("Créditos");
        panelPrincipal.add(btnRegistrar);
        panelPrincipal.add(btnListado);
        panelPrincipal.add(btnCreditos);
        setContentPane(panelPrincipal);

        btnRegistrar.addActionListener(e -> new FormRegistro(usuarios).setVisible(true));
        btnListado.addActionListener(e -> new FormListado(usuarios).setVisible(true));
        btnCreditos.addActionListener(e -> new FormCreditos().setVisible(true));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMenu().setVisible(true));
    }
}

