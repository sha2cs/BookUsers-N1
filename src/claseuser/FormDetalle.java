package claseuser;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class FormDetalle extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lbFoto;
    private JLabel lblId;
    private JLabel lblTipoId;
    private JLabel lblNumeroId;
    private JLabel lblNombreCompleto;
    private JLabel lblUsername;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JButton btnGenerarPdf;
    private JButton btnCerrar;

    private Claseuser usuario;


    public FormDetalle(Claseuser usuario) {
        this.usuario = usuario;

        setContentPane(panelPrincipal);
        setTitle("BookUsers · Detalle de Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 520);
        setLocationRelativeTo(null);

        mostrarDatosUsuario();
        configurarEventos();
    }

    private void mostrarDatosUsuario() {
        String ruta = usuario.getRutaFoto();
        if (ruta != null && !ruta.isEmpty() && new File(ruta).exists()) {
            ImageIcon iconoOriginal = new ImageIcon(ruta);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            lbFoto.setIcon(new ImageIcon(imagenEscalada));
            lbFoto.setText("");
        } else {
            lbFoto.setIcon(null);
            lbFoto.setText("Sin foto disponible");
        }


        lblId.setText(String.valueOf(usuario.getId()));
        lblTipoId.setText(usuario.getTipoIdentificacion());
        lblNumeroId.setText(usuario.getNumeroIdentificacion());

        String nombreCompleto = usuario.getPrimerNombre() + " " +
                (usuario.getSegundoNombre().isEmpty() ? "" : usuario.getSegundoNombre() + " ") +
                usuario.getPrimerApellido() +
                (usuario.getSegundoApellido().isEmpty() ? "" : " " + usuario.getSegundoApellido());

        lblNombreCompleto.setText(nombreCompleto.trim());
        lblUsername.setText(usuario.getUsername());
        lblTelefono.setText(usuario.getTelefono());
        lblCorreo.setText(usuario.getCorreo());
    }

    private void configurarEventos() {
        btnGenerarPdf.addActionListener(e -> generarPdfUsuario());

        if (btnCerrar != null) {
            btnCerrar.addActionListener(e -> dispose());
        }
    }

    private void generarPdfUsuario() {
        String nombreArchivo = "usuario_" + usuario.getUsername() + ".pdf";
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            // Título del documento
            documento.add(new Paragraph("FICHA DE USUARIO - BOOKUSERS"));
            documento.add(new Paragraph("--------------------------------------------------"));
            documento.add(new Paragraph(" "));


            String ruta = usuario.getRutaFoto();
            if (ruta != null && !ruta.isEmpty() && new File(ruta).exists()) {
                com.lowagie.text.Image imagenPdf = com.lowagie.text.Image.getInstance(ruta);
                imagenPdf.scaleToFit(120, 120);
                documento.add(imagenPdf);
                documento.add(new Paragraph(" "));
            }


            documento.add(new Paragraph("ID: " + usuario.getId()));
            documento.add(new Paragraph("Tipo de identificación: " + usuario.getTipoIdentificacion()));
            documento.add(new Paragraph("Número de identificación: " + usuario.getNumeroIdentificacion()));
            documento.add(new Paragraph("Nombre completo: " + lblNombreCompleto.getText()));
            documento.add(new Paragraph("Username: " + usuario.getUsername()));
            documento.add(new Paragraph("Teléfono: " + usuario.getTelefono()));
            documento.add(new Paragraph("Correo electrónico: " + usuario.getCorreo()));

            documento.close();

            JOptionPane.showMessageDialog(
                    this,
                    "PDF generado correctamente:\n" + new File(nombreArchivo).getAbsolutePath(),
                    "PDF Exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al generar el PDF: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
