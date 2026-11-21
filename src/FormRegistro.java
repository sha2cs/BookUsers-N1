import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.ArrayList;

public class FormRegistro extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox<String> cmbTipoId;
    private JTextField txtNumeroId, txtPrimerNombre, txtSegundoNombre,
            txtPrimerApellido, txtSegundoApellido, txtTelefono, txtCorreo;
    private JPasswordField txtPassword;
    private JLabel lblUsername, lblFoto;
    private JButton btnCargarFoto, btnGuardar;
    private String rutaFoto = "";
    private ArrayList<Usuario> usuarios;

    private static final String[] TIPOS = {
            "11 - Registro civil de nacimiento", "12 - Tarjeta de identidad",
            "13 - Cédula de ciudadanía", "21 - Tarjeta de extranjería",
            "22 - Cédula de extranjería", "41 - Pasaporte",
            "42 - Documento de identificación extranjero",
            "47 - Permiso Especial de Permanencia (PEP)", "91 - NUIP"};

    public FormRegistro(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        setTitle("BookUsers - Registro");

        cmbTipoId = new JComboBox<>(TIPOS);
        txtNumeroId = new JTextField();
        txtPrimerNombre = new JTextField();
        txtSegundoNombre = new JTextField();
        txtPrimerApellido = new JTextField();
        txtSegundoApellido = new JTextField();
        txtPassword = new JPasswordField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        lblUsername = new JLabel("-");
        lblFoto = new JLabel("Sin foto", SwingConstants.CENTER);
        lblFoto.setPreferredSize(new Dimension(120, 120));
        lblFoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        btnCargarFoto = new JButton("Cargar foto");
        btnGuardar = new JButton("Guardar");

        JPanel campos = new JPanel(new GridLayout(0, 2, 6, 6));
        campos.add(new JLabel("Tipo de identificación:")); campos.add(cmbTipoId);
        campos.add(new JLabel("Número:")); campos.add(txtNumeroId);
        campos.add(new JLabel("Primer nombre:")); campos.add(txtPrimerNombre);
        campos.add(new JLabel("Segundo nombre:")); campos.add(txtSegundoNombre);
        campos.add(new JLabel("Primer apellido:")); campos.add(txtPrimerApellido);
        campos.add(new JLabel("Segundo apellido:")); campos.add(txtSegundoApellido);
        campos.add(new JLabel("Username:")); campos.add(lblUsername);
        campos.add(new JLabel("Contraseña:")); campos.add(txtPassword);
        campos.add(new JLabel("Teléfono:")); campos.add(txtTelefono);
        campos.add(new JLabel("Correo:")); campos.add(txtCorreo);

        JPanel foto = new JPanel(new BorderLayout(6, 6));
        foto.add(lblFoto, BorderLayout.CENTER);
        foto.add(btnCargarFoto, BorderLayout.SOUTH);

        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelPrincipal.add(campos, BorderLayout.CENTER);
        panelPrincipal.add(foto, BorderLayout.EAST);
        panelPrincipal.add(btnGuardar, BorderLayout.SOUTH);
        setContentPane(panelPrincipal);

        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualizarUsername(); }
            public void removeUpdate(DocumentEvent e) { actualizarUsername(); }
            public void changedUpdate(DocumentEvent e) { actualizarUsername(); }
        };
        txtPrimerNombre.getDocument().addDocumentListener(dl);
        txtPrimerApellido.getDocument().addDocumentListener(dl);
        txtSegundoApellido.getDocument().addDocumentListener(dl);

        btnCargarFoto.addActionListener(e -> cargarFoto());
        btnGuardar.addActionListener(e -> guardar());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(650, 430);
        setLocationRelativeTo(null);
    }

    private void actualizarUsername() {
        String u = Util.generarUsername(txtPrimerNombre.getText(),
                txtPrimerApellido.getText(), txtSegundoApellido.getText());
        lblUsername.setText(u.isEmpty() ? "-" : u);
    }

    private void cargarFoto() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Imágenes (png, jpg)", "png", "jpg", "jpeg"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String ruta = fc.getSelectedFile().getAbsolutePath();
            ImageIcon icono = Util.cargarIcono(ruta, 120, 120);
            if (icono == null) {
                JOptionPane.showMessageDialog(this, "No se pudo leer la imagen.");
                return;
            }
            rutaFoto = ruta;
            lblFoto.setText("");
            lblFoto.setIcon(icono);
        }
    }

    private void guardar() {
        String tipo = cmbTipoId.getSelectedItem().toString();
        String codigo = tipo.split(" - ")[0];
        String numero = txtNumeroId.getText().trim();
        String pn = txtPrimerNombre.getText().trim();
        String pa = txtPrimerApellido.getText().trim();
        String pass = new String(txtPassword.getPassword());
        String tel = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (numero.isEmpty() || pn.isEmpty() || pa.isEmpty() || pass.isEmpty()
                || tel.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios.");
            return;
        }
        boolean alfanumerico = codigo.equals("41") || codigo.equals("42");
        if (!alfanumerico && !numero.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de identificación solo debe tener dígitos.");
            return;
        }
        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(this, "El correo debe contener @.");
            return;
        }

        Usuario u = new Usuario(Usuario.nuevoId(), tipo, numero, pn,
                txtSegundoNombre.getText().trim(), pa,
                txtSegundoApellido.getText().trim(), lblUsername.getText(),
                pass, tel, correo, rutaFoto);
        usuarios.add(u);
        JOptionPane.showMessageDialog(this, "Usuario guardado. Username: " + u.getUsername());
        limpiar();
    }

    private void limpiar() {
        txtNumeroId.setText(""); txtPrimerNombre.setText(""); txtSegundoNombre.setText("");
        txtPrimerApellido.setText(""); txtSegundoApellido.setText(""); txtPassword.setText("");
        txtTelefono.setText(""); txtCorreo.setText("");
        cmbTipoId.setSelectedIndex(0);
        rutaFoto = "";
        lblFoto.setIcon(null);
        lblFoto.setText("Sin foto");
    }
}

