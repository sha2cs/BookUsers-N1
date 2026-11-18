import javax.swing.*;
import java.util.ArrayList;

public class FormRegistro extends  javax.swing.JFrame {
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
    private JPanel panelExterno;


    private ArrayList<Usuario> listaUsuarios;

    public FormRegistro(ArrayList<Usuario> listaUsuarios) {
        setTitle("Registrar Usuario");
        setContentPane(panelExterno);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 700);

        setLocationRelativeTo(null);
        setVisible(true);

        {
            cmbTipoIdentificacion.addItem("11 - Registro civil de Nacimiento");
            cmbTipoIdentificacion.addItem("12 - Tarjeta de Identidad");
            cmbTipoIdentificacion.addItem("13 - Cedula de Ciudadania");
            cmbTipoIdentificacion.addItem("21 - Tarjeta de Extranjeria");
            cmbTipoIdentificacion.addItem("22 - Cedula de Extranjeria");
            cmbTipoIdentificacion.addItem("41 - Pasaporte");
            cmbTipoIdentificacion.addItem("42 - Documento de Identificacion Extranjero");
            cmbTipoIdentificacion.addItem("47 - Permiso Especial de Permanencia");
            cmbTipoIdentificacion.addItem("91 - NUIP");
            cmbTipoIdentificacion.insertItemAt("",0);


        }
    }}