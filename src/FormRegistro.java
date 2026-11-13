import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
            this.usuarios = usuarios;

        setContentPane(scrollPaneRegistro);
        setTitle("Registro de usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);

    }
}
