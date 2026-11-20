import javax.swing.*;
import java.util.ArrayList;
import com.sha2cs.inputfile.*;



public class FormRegistro extends  javax.swing.JFrame {
    private JComboBox cmbTipoIdentificacion;
    private JTextField txtNumeroIdentificacion;
    private JTextField txtPrimerNombre;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JPasswordField txtPassword;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JButton btnFoto;
    private JLabel lblRutaFoto;
    private JPanel panelExterno;
    private JButton btnGuardar;
    private JLabel lblUsername;


    private ArrayList<Usuario> listaUsuarios;
    private String rutaFoto = "";
    private static int contadorId = 1;

    public FormRegistro(ArrayList<Usuario> listaUsuarios){
    this.listaUsuarios= listaUsuarios;
        setTitle("Registrar Usuario");
        setContentPane(panelExterno);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 700);

        setLocationRelativeTo(null);
        cargarTiposIdentificacion();
        configurarUsernameEnVivo();
        configurarEventos();
        setVisible(true);
    }


    private void cargarTiposIdentificacion() {

        cmbTipoIdentificacion.removeAllItems();



            cmbTipoIdentificacion.addItem("11 - Registro civil de Nacimiento");
            cmbTipoIdentificacion.addItem("12 - Tarjeta de Identidad");
            cmbTipoIdentificacion.addItem("13 - Cedula de Ciudadania");
            cmbTipoIdentificacion.addItem("21 - Tarjeta de Extranjeria");
            cmbTipoIdentificacion.addItem("22 - Cedula de Extranjeria");
            cmbTipoIdentificacion.addItem("41 - Pasaporte");
            cmbTipoIdentificacion.addItem("42 - Documento de Identificacion Extranjero");
            cmbTipoIdentificacion.addItem("47 - Permiso Especial de Permanencia");
            cmbTipoIdentificacion.addItem("91 - NUIP");
}
private void configurarUsernameEnVivo(){
    }
    private void configurarEventos() {
        btnFoto.addActionListener(e -> {

            java.io.File foto = InputFile.elegir(this);
            if (foto != null)
                rutaFoto = foto.getAbsolutePath();
            if (lblRutaFoto != null) {
                lblRutaFoto.setText(rutaFoto);
            }
        });






    btnGuardar.addActionListener(e -> {
        Usuario nuevoUsuario = new Usuario(
                contadorId++,
                String.valueOf(cmbTipoIdentificacion.getSelectedItem()),
                txtNumeroIdentificacion.getText().trim(),
                txtPrimerNombre.getText().trim(),
                txtSegundoNombre.getText().trim(),
                txtPrimerApellido.getText().trim(),
                txtSegundoApellido.getText().trim(),
                lblUsername.getText().trim(),
                new String(txtPassword.getPassword()),
                txtTelefono.getText().trim(),
                txtCorreo.getText().trim(),
                rutaFoto
        );

        listaUsuarios.add(nuevoUsuario);
        JOptionPane.showMessageDialog(this, "Usuario guardado correctamente.");
        dispose();
    });
}




}






