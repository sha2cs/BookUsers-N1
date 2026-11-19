import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.Normalizer;

public class FormRegistro extends JFrame{
    private ArrayList<Usuario> usuarios;
    private String rutafoto = "";

    private JPanel panelPrincipal;
    private JLabel txtPrimerNombre;
    private JTextField textField1;
    private JLabel txtSegundoNombre;
    private JTextField textField2;
    private JLabel txtPrimerApellido;
    private JTextField textField3;
    private JLabel txtSegundoApellido;
    private JTextField textField4;
    private JComboBox cmbTipoIdentificacion;
    private JTextField txtNumeroIdentificacion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JLabel lblUsername;
    private JLabel lblFoto;
    private JButton btnSeleccionarFoto;
    private JLabel btnCargarFoto;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JScrollPane scrollPaneRegistro;

    public FormRegistro(ArrayList<Usuario> usuarios) {

        this.usuarios = usuarios;

        btnSeleccionarFoto.addActionListener(e -> {

            JFileChooser selector = new JFileChooser();

            int resultado = selector.showOpenDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION){
                rutafoto = selector.getSelectedFile().getAbsolutePath();

                ImageIcon imagen = new ImageIcon(rutafoto);
                Image imagenEscalada = imagen.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);

                lblFoto.setIcon(new ImageIcon(imagenEscalada));

            }
            });






        setContentPane(scrollPaneRegistro);
        setTitle("Registro de usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        DocumentListener escuchador = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) { actualizarUsername(); }

            @Override
            public void removeUpdate(DocumentEvent e) { actualizarUsername(); }

            @Override
            public void changedUpdate(DocumentEvent e) { actualizarUsername(); }
        };
        textField1.getDocument().addDocumentListener(escuchador);
        textField3.getDocument().addDocumentListener(escuchador);

        cmbTipoIdentificacion.addItem("Cédula de ciudadanía");
        cmbTipoIdentificacion.addItem("Tarjeta de identidad");
        cmbTipoIdentificacion.addItem("Pasaporte");

        btnGuardar.addActionListener(e -> {

            String username = generarUsername();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Escribe el primer nombre y el primer apellido.");
                return;
            }

            Usuario nuevo = new Usuario(
                    usuarios.size() + 1,
                    (String) cmbTipoIdentificacion.getSelectedItem(),
                    txtNumeroIdentificacion.getText(),
                    textField1.getText(),
                    textField2.getText(),
                    textField3.getText(),
                    textField4.getText(),
                    username,
                    new String(txtPassword.getPassword()),
                    txtTelefono.getText(),
                    txtCorreo.getText(),
                    rutafoto
            );

            usuarios.add(nuevo);
            JOptionPane.showMessageDialog(this, "Usuario guardado: " + username);
            limpiarFormulario();

        });

        btnLimpiar.addActionListener(e -> limpiarFormulario());

    }

    private void limpiarFormulario() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        txtNumeroIdentificacion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtPassword.setText("");
        cmbTipoIdentificacion.setSelectedIndex(0);
        lblFoto.setIcon(null);
        rutafoto = "";
        actualizarUsername();
    }


// Quita tildes, espacios y símbolos, y pasa todo a minúsculas
    private String limpiar(String texto) {
        String sinTildes = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return sinTildes.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }

    // Revisa si ya existe un usuario con ese username
    private boolean existeUsername(String username) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    // Arma el username: inicial del primer nombre + primer apellido
    private String generarUsername() {
        String nombre = limpiar(textField1.getText());
        String apellido = limpiar(textField3.getText());

        if (nombre.isEmpty() || apellido.isEmpty()) {
            return "";
        }

        String base = nombre.charAt(0) + apellido;
        String username = base;
        int contador = 1;

        while (existeUsername(username)) {
            username = base + contador;
            contador++;
        }
        return username;
    }

    // Muestra el username en la etiqueta del formulario
    private void actualizarUsername() {
        String username = generarUsername();
        lblUsername.setText(username.isEmpty() ? "Se generará automáticamente" : username);
    }
}





