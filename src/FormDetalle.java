
import javax.swing.*;
import java.awt.Image;

public class FormDetalle extends JFrame {

    private JPanel panel1;
    private JLabel lblFoto;
    private JLabel lblIdentificacion;
    private JLabel lblNombreCompleto;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JLabel txtUsername;
    private JLabel cmbTipoIdentificacion;
    private JLabel btnVerDetalle;

    private Usuario usuario;

    public FormDetalle(Usuario usuario) {
        this.usuario = usuario;

        setContentPane(panel1);
        setTitle("Detalle del Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cargarDatos();
        cargarFoto();

        pack();
        setLocationRelativeTo(null);
    }

    private void cargarDatos() {
        if (usuario == null) {
            return;
        }

        lblIdentificacion.setText(usuario.getNumeroIdentificacion());

        lblNombreCompleto.setText(
                usuario.getPrimerNombre() + " " +
                        usuario.getSegundoNombre() + " " +
                        usuario.getPrimerApellido() + " " +
                        usuario.getSegundoApellido()
        );

        lblTelefono.setText(usuario.getTelefono());
        lblCorreo.setText(usuario.getCorreo());
        txtUsername.setText(usuario.getUsername());
        cmbTipoIdentificacion.setText(usuario.getTipoIdentificacion());
    }

    private void cargarFoto() {
        if (usuario != null &&
                usuario.getRutaFoto() != null &&
                !usuario.getRutaFoto().isEmpty()) {

            ImageIcon imagen = new ImageIcon(usuario.getRutaFoto());

            Image foto = imagen.getImage().getScaledInstance(
                    120, 120, Image.SCALE_SMOOTH);

            lblFoto.setIcon(new ImageIcon(foto));
        }
    }
}
