import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.io.File;
import java.awt.Image;

public class FormRegistro {
    private JPanel panelPrincipal;
    private JComboBox cmbTipoId;
    private JTextField txtNumeroId;
    private JTextField txtPrimerNombre;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JLabel lblUsername;
    private JButton btnCargarFoto;
    private JLabel lblFoto;
    private JButton btnGuardar;
    private ArrayList<Usuario> usuarios;
    private FormMenu menu;

    public FormRegistro(ArrayList<Usuario> usuarios, FormMenu menu) {
        this.usuarios = usuarios;
        this.menu = menu;
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizarUsername();
            }

            public void removeUpdate(DocumentEvent e) {
                actualizarUsername();
            }

            public void changedUpdate(DocumentEvent e) {
                actualizarUsername();
            }
        };

        txtPrimerNombre.getDocument().addDocumentListener(listener);
        txtPrimerApellido.getDocument().addDocumentListener(listener);
        txtSegundoApellido.getDocument().addDocumentListener(listener);
        cmbTipoId.addItem("11 - Registro civil de nacimiento");
        cmbTipoId.addItem("12 - Tarjeta de identidad");
        cmbTipoId.addItem("13 - Cédula de ciudadanía");
        cmbTipoId.addItem("21 - Tarjeta de extranjería");
        cmbTipoId.addItem("22 - Cédula de extranjería");
        cmbTipoId.addItem("41 - Pasaporte");
        cmbTipoId.addItem("42 - Documento de identificación extranjero");
        cmbTipoId.addItem("47 - Permiso Especial de Permanencia (PEP)");
        cmbTipoId.addItem("91 - NUIP");
        btnGuardar.addActionListener(e -> guardarUsuario());
        btnCargarFoto.addActionListener(e -> cargarFoto());
        JFrame ventana = new JFrame("BookUsers - Registro");
        ventana.setContentPane(panelPrincipal);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack();
        ventana.setSize(580, 480);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    private void guardarUsuario() {
        String numeroId = txtNumeroId.getText().trim();
        String primerNombre = txtPrimerNombre.getText().trim();
        String segundoNombre = txtSegundoNombre.getText().trim();
        String primerApellido = txtPrimerApellido.getText().trim();
        String segundoApellido = txtSegundoApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (numeroId.isEmpty() || primerNombre.isEmpty() ||
                primerApellido.isEmpty() || telefono.isEmpty() ||
                correo.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Complete los campos obligatorios");
            return;
        }

        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(null, "El correo debe contener @");
            return;
        }

        String tipoId = cmbTipoId.getSelectedItem().toString();

        int id = menu.obtenerSiguienteId();

        Usuario nuevoUsuario = new Usuario(
                id,
                tipoId,
                numeroId,
                primerNombre,
                segundoNombre,
                primerApellido,
                segundoApellido,
                password,
                telefono,
                correo,
                rutaFoto
        );

        usuarios.add(nuevoUsuario);
        lblUsername.setText(nuevoUsuario.getUsername());

        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
    }
    private void actualizarUsername() {
        String nombre = txtPrimerNombre.getText().trim().toLowerCase();
        String apellido1 = txtPrimerApellido.getText().trim().toLowerCase();
        String apellido2 = txtSegundoApellido.getText().trim().toLowerCase();

        if (nombre.isEmpty() || apellido1.isEmpty()) {
            lblUsername.setText("");
            return;
        }

        String username = apellido1.substring(0, 1);

        if (!apellido2.isEmpty()) {
            username += apellido2.substring(0, 1);
        }

        username += nombre;
        username = username.replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                .replace("ñ", "n")
                .replace(" ", "");

        lblUsername.setText(username);
    }
    private String rutaFoto = "";

    private void cargarFoto() {
        JFileChooser selector = new JFileChooser();

        int resultado = selector.showOpenDialog(panelPrincipal);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = selector.getSelectedFile();
            rutaFoto = archivo.getAbsolutePath();

            ImageIcon imagen = new ImageIcon(rutaFoto);
            Image foto = imagen.getImage().getScaledInstance(
                    100, 100, Image.SCALE_SMOOTH
            );

            lblFoto.setText("");
            lblFoto.setIcon(new ImageIcon(foto));
        }
    }
}