
import javax.swing.*;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;


public class FormDetalle extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblIdentificacion;
    private JLabel lblUsername;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JLabel lblFoto;
    private JButton btnGenerarPDF;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnVolver;
    private Usuario usuario;
    private ArrayList<Usuario> usuarios;


    public FormDetalle(Usuario usuario, ArrayList<Usuario> usuarios) {
        this.usuario = usuario;
        this.usuarios = usuarios;

        setContentPane(panelPrincipal);
        setTitle("Detalles del usuario");
        setSize(650, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostrarDatos();

        btnVolver.addActionListener(e -> dispose());


        btnEditar.addActionListener(e -> {
            String telefono = JOptionPane.showInputDialog(
                    this,
                    "Nuevo teléfono:",
                    usuario.getTelefono()
            );

            if (telefono == null) {
                return;
            }

            String correo = JOptionPane.showInputDialog(
                    this,
                    "Nuevo correo:",
                    usuario.getCorreo()
            );

            if (correo == null) {
                return;
            }

            usuario.setTelefono(telefono.trim());
            usuario.setCorreo(correo.trim());

            mostrarDatos();

            JOptionPane.showMessageDialog(
                    this,
                    "Usuario actualizado correctamente"
            );
        });


        btnEliminar.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que deseas eliminar este usuario?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                usuarios.remove(usuario);

                JOptionPane.showMessageDialog(
                        this,
                        "Usuario eliminado correctamente"
                );

                dispose();
            }
        });


        btnGenerarPDF.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            selector.setDialogTitle("Guardar PDF del usuario");
            selector.setSelectedFile(new File("Usuario_" + usuario.getId() + ".pdf"));

            int opcion = selector.showSaveDialog(this);

            if (opcion != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File archivo = selector.getSelectedFile();

            if (!archivo.getName().toLowerCase().endsWith(".pdf")) {
                archivo = new File(archivo.getAbsolutePath() + ".pdf");
            }

            if (archivo.exists()) {
                int confirmar = JOptionPane.showConfirmDialog(
                        this,
                        "El archivo ya existe. ¿Deseas reemplazarlo?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmar != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, new FileOutputStream(archivo));

                documento.open();

                documento.add(new Paragraph("DETALLES DEL USUARIO"));
                documento.add(new Paragraph(" "));
                documento.add(new Paragraph("ID: " + usuario.getId()));
                documento.add(new Paragraph("Tipo de identificación: " + usuario.getTipoIdentificacion()));
                documento.add(new Paragraph("Número de identificación: " + usuario.getNumeroIdentificacion()));
                documento.add(new Paragraph("Primer nombre: " + usuario.getPrimerNombre()));
                documento.add(new Paragraph("Segundo nombre: " + usuario.getSegundoNombre()));
                documento.add(new Paragraph("Primer apellido: " + usuario.getPrimerApellido()));
                documento.add(new Paragraph("Segundo apellido: " + usuario.getSegundoApellido()));
                documento.add(new Paragraph("Nombre de usuario: " + usuario.getUsername()));
                documento.add(new Paragraph("Teléfono: " + usuario.getTelefono()));
                documento.add(new Paragraph("Correo: " + usuario.getCorreo()));

                documento.close();

                JOptionPane.showMessageDialog(
                        this,
                        "PDF generado correctamente"
                );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al generar PDF: " + ex.getMessage()
                );
            }
        });

    }

    private void mostrarDatos() {
        lblIdentificacion.setText(
                "Identificación: " +
                        usuario.getTipoIdentificacion() + " - " +
                        usuario.getNumeroIdentificacion()
        );

        String nombreCompleto =
                usuario.getPrimerNombre() + " " +
                        usuario.getSegundoNombre() + " " +
                        usuario.getPrimerApellido() + " " +
                        usuario.getSegundoApellido();

        lblUsername.setText(
                "Nombre: " + nombreCompleto +
                        " | Usuario: " + usuario.getUsername()
        );

        lblTelefono.setText("Teléfono: " + usuario.getTelefono());
        lblCorreo.setText("Correo: " + usuario.getCorreo());

        String ruta = usuario.getRutaFoto();

        if (ruta != null && !ruta.isEmpty() && new File(ruta).exists()) {
            ImageIcon imagen = new ImageIcon(ruta);
            Image foto = imagen.getImage().getScaledInstance(
                    120, 120, Image.SCALE_SMOOTH
            );
            lblFoto.setIcon(new ImageIcon(foto));
            lblFoto.setText("");
        } else {
            lblFoto.setText("Sin foto");
        }
    }
}
