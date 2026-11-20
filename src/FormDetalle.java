import   com.sha2cs.generatepdf.DocumentoPDF;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com .sha2cs.inputfile.*;
import java.io.File;





public class FormDetalle extends JFrame {
    private JLabel lblFotoDetalle;
    private JLabel lblDatosUsuario;
    private JButton btnGenerarPdf;
    private JButton btnCerrar;
    private JPanel panelDetalle;
    private Usuario usuario;

    public FormDetalle(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Detalle de Usuario");
        setContentPane(panelDetalle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrarDatosUsuario();

        setSize(500, 400);
        setLocationRelativeTo(null);


        btnGenerarPdf.addActionListener(e -> exportarPdf());
        btnCerrar.addActionListener(e -> dispose());
    }

    private void mostrarDatosUsuario() {
        if (usuario == null) {
            return;
        }

        String texto = "<html>"
                + "<b>ID:</b> " + usuario.getId() + "<br>"
                + "<b>Tipo de identificación:</b> " + usuario.getTipoIdentificacion() + "<br>"
                + "<b>Nombre:</b> " + usuario.getPrimerNombre() + " " + usuario.getSegundoNombre() + "<br>"
                + "<b>Apellido:</b> " + usuario.getPrimerApellido() + " " + usuario.getSegundoApellido() + "<br>"
                + "<b>Usuario:</b> " + usuario.getUsername() + "<br>"
                + "<b>Teléfono:</b> " + usuario.getTelefono() + "<br>"
                + "<b>Email:</b> " + usuario.getEmail();


        lblDatosUsuario.setText(texto);
        String ruta = usuario.getRutaFoto(); // ajusta al getter exacto en Usuario.java
        System.out.println("RUTA FOTO: " + ruta); // <- esto es para probar

        if (ruta != null && !ruta.isBlank()) {
            File archivoFoto = new File(ruta);
            if (archivoFoto.exists()) {
                lblFotoDetalle.setText("");
                InputFile.mostrar(lblFotoDetalle, archivoFoto);

                // Ahora sí escala a 120x120
                if (lblFotoDetalle.getIcon() instanceof javax.swing.ImageIcon icon) {
                    java.awt.Image imgEscalada = icon.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    lblFotoDetalle.setIcon(new javax.swing.ImageIcon(imgEscalada));
                }
            } else {
                lblFotoDetalle.setIcon(null);
                lblFotoDetalle.setText("Sin foto - no existe: " + ruta);
            }
        } else {
            lblFotoDetalle.setIcon(null);
            lblFotoDetalle.setText("Sin foto - ruta vacía");
        }
    }

        private void exportarPdf () {
            try {
                if (usuario == null) {
                    JOptionPane.showMessageDialog(this, "No hay un usuario seleccionado.");
                    return;
                }

                DocumentoPDF pdf = new DocumentoPDF("Detalle de Usuario")
                        .campo("ID", usuario.getId())
                        .campo("Tipo de identificación", usuario.getTipoIdentificacion())
                        .campo("Primer nombre", usuario.getPrimerNombre())
                        .campo("Segundo nombre", usuario.getSegundoNombre())
                        .campo("Primer apellido", usuario.getPrimerApellido())
                        .campo("Segundo apellido", usuario.getSegundoApellido())
                        .campo("Usuario", usuario.getUsername())
                        .campo("Teléfono", usuario.getTelefono())
                        .campo("Email", usuario.getEmail());

                String nombreArchivo = "usuario_" + usuario.getUsername() + ".pdf";
                pdf.guardar(nombreArchivo);
                JOptionPane.showMessageDialog(this, "PDF generado correctamente: " + nombreArchivo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + ex.getMessage());
            }
        }
    }
