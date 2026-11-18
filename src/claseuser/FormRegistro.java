package claseuser;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;

public class FormRegistro extends JFrame {

    private JPanel panelPrincipal;
    private JComboBox<String> opciones;
    private JTextField numeroid;
    private JTextField pnombre;
    private JTextField snombre;
    private JTextField papellido;
    private JTextField sapellido;
    private JLabel user;
    private JPasswordField contrasenna;
    private JTextField telefonoo;
    private JTextField correoo;
    private JButton ok;
    private JLabel foto;
    private JButton btnGuardar;

    private ArrayList<Usuario> usuarios;
    private String rutaFotoSeleccionada = "";

    private static int contadorId = 1;

    // Constructor que recibe la lista única desde FormMenu
    public FormRegistro(ArrayList<Claseuser> usuario) {
        this.usuarios = usuario;

        setContentPane(panelPrincipal);
        setTitle("BookUsers · Registro de Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(520, 650);
        setLocationRelativeTo(null);

        cargarTiposIdentificacion();
        configurarEventos();
    }

    private void cargarTiposIdentificacion() {
        opciones.addItem("11 - Registro civil de nacimiento");
        opciones.addItem("12 - Tarjeta de identidad");
        opciones.addItem("13 - Cédula de ciudadanía");
        opciones.addItem("21 - Tarjeta de extranjería");
        opciones.addItem("22 - Cédula de extranjería");
        opciones.addItem("41 - Pasaporte");
        opciones.addItem("42 - Documento de identificación extranjero");
        opciones.addItem("47 - Permiso Especial de Permanencia (PEP)");
        opciones.addItem("91 - NUIP");
    }

    private void configurarEventos() {
        // 1. Actualizar el username cada vez que cambie nombre o apellidos
        DocumentListener listenerUsername = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { actualizarUsername(); }
            @Override
            public void removeUpdate(DocumentEvent e) { actualizarUsername(); }
            @Override
            public void changedUpdate(DocumentEvent e) { actualizarUsername(); }
        };

        pnombre.getDocument().addDocumentListener(listenerUsername);
        papellido.getDocument().addDocumentListener(listenerUsername);
        sapellido.getDocument().addDocumentListener(listenerUsername);

        // 2. Botón para cargar y escalar la foto
        ok.addActionListener(e -> seleccionarFoto());

        // 3. Botón para validar y guardar el usuario
        btnGuardar.addActionListener(e -> guardarUsuario());
    }

    private void actualizarUsername() {
        String pNombre = limpiarTexto(pnombre.getText());
        String pApellido = limpiarTexto(papellido.getText());
        String sApellido = limpiarTexto(sapellido.getText());

        String inicial1 = pApellido.isEmpty() ? "" : pApellido.substring(0, 1);
        String inicial2 = sApellido.isEmpty() ? "" : sApellido.substring(0, 1);

        user.setText(inicial1 + inicial2 + pNombre);
    }

    // Quita tildes, reemplaza ñ por n, pasa a minúsculas y elimina espacios
    private String limpiarTexto(String texto) {
        if (texto == null) return "";
        String limpio = texto.trim().toLowerCase();
        limpio = limpio.replace("ñ", "n");
        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD);
        limpio = limpio.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        limpio = limpio.replaceAll("\\s+", "");
        return limpio;
    }

    private void seleccionarFoto() {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (.jpg, .png)", "jpg", "jpeg", "png");
        selector.setFileFilter(filtro);

        int resultado = selector.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = selector.getSelectedFile();
            rutaFotoSeleccionada = archivo.getAbsolutePath();

            // Escalar imagen a 120x120 px para que quepa en el JLabel
            ImageIcon iconoOriginal = new ImageIcon(rutaFotoSeleccionada);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(imagenEscalada));
            foto.setText("");
        }
    }

    private void guardarUsuario() {
        String tipoId = (String) opciones.getSelectedItem();
        String numeroId = numeroid.getText().trim();
        String pNombre = pnombre.getText().trim();
        String sNombre = snombre.getText().trim();
        String pApellido = papellido.getText().trim();
        String sApellido = sapellido.getText().trim();
        String username = user.getText();
        String password = new String(contrasenna.getPassword()).trim();
        String telefono = telefonoo.getText().trim();
        String correo = correoo.getText().trim();

        // Validación de campos obligatorios
        if (numeroId.isEmpty() || pNombre.isEmpty() || pApellido.isEmpty() ||
                password.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos obligatorios.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de solo dígitos (excepto 41 - Pasaporte y 42 - Documento extranjero)
        boolean permiteLetras = tipoId.startsWith("41") || tipoId.startsWith("42");
        if (!permiteLetras && !numeroId.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de identificación solo debe contener dígitos para este tipo de documento.", "Identificación inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación básica del correo
        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico debe contener el símbolo '@'.", "Correo inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Crear objeto Usuario con ID único asignado por el programa
        Claseuser nuevo = Claseuser (
                contadorId++,
                tipoId,
                numeroId,
                pnombre,
                snombre,
                pApellido,
                sApellido,
                username,
                password,
                telefono,
                correo,
                rutaFotoSeleccionada
        );

        usuarios.add(nuevo);
        JOptionPane.showMessageDialog(this, "Usuario registrado con éxito. ID asignado: " + nuevo.getId(), "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        opciones.setSelectedIndex(0);
        numeroid.setText("");
        pnombre.setText("");
        snombre.setText("");
        papellido.setText("");
        sapellido.setText("");
        user.setText("");
        contrasenna.setText("");
        telefonoo.setText("");
        correoo.setText("");
        foto.setIcon(null);
        foto.setText("Sin foto");
        rutaFotoSeleccionada = "";
    }
}
