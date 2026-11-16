import javax.swing.*;

public class FormRegistro {
    private JPanel panelPrincipal;
    private JComboBox cmbTipoIdentificacion;
    private JTextField txtNúmeroIdentificacion;
    private JTextField txtPrimerNombre;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JPasswordField txtPassword;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JButton btnFoto;
    private JLabel lblRutaFoto;
    private JTextField txtUsername;

    public FormRegistro() {
        cmbTipoIdentificacion.addItem("C.C. - Cedula de Ciudadania");
        cmbTipoIdentificacion.addItem("T.I. - Tarjeta de Identidad");
        cmbTipoIdentificacion.addItem("C.E. - Cedula de Extranjeria");
        cmbTipoIdentificacion.addItem("Pasaporte");


    }
}