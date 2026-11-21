import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class FormDetalle extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblFoto;
    private JTextArea txtInfo;
    private JButton btnGenerarPdf;
    private Usuario usuario;

    public FormDetalle(Usuario usuario) {
        this.usuario = usuario;
        setTitle("BookUsers - Detalle");

        lblFoto = new JLabel("Sin foto", SwingConstants.CENTER);
        lblFoto.setPreferredSize(new Dimension(120, 120));
        ImageIcon icono = Util.cargarIcono(usuario.getRutaFoto(), 120, 120);
        if (icono != null) { lblFoto.setText(""); lblFoto.setIcon(icono); }

        txtInfo = new JTextArea(textoInfo());
        txtInfo.setEditable(false);
        btnGenerarPdf = new JButton("Generar PDF");

        panelPrincipal = new JPanel(new BorderLayout(8, 8));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(lblFoto, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(txtInfo), BorderLayout.CENTER);
        panelPrincipal.add(btnGenerarPdf, BorderLayout.SOUTH);
        setContentPane(panelPrincipal);

        btnGenerarPdf.addActionListener(e -> generarPdf());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(420, 480);
        setLocationRelativeTo(null);
    }

    // Toda la información, SIN la contraseña
    private String textoInfo() {
        return "ID: " + usuario.getId()
                + "\nTipo de identificación: " + usuario.getTipoIdentificacion()
                + "\nNúmero: " + usuario.getNumeroIdentificacion()
                + "\nPrimer nombre: " + usuario.getPrimerNombre()
                + "\nSegundo nombre: " + usuario.getSegundoNombre()
                + "\nPrimer apellido: " + usuario.getPrimerApellido()
                + "\nSegundo apellido: " + usuario.getSegundoApellido()
                + "\nUsername: " + usuario.getUsername()
                + "\nTeléfono: " + usuario.getTelefono()
                + "\nCorreo: " + usuario.getCorreo();
    }

    private void generarPdf() {
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("usuario_" + usuario.getUsername() + ".pdf"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File destino = fc.getSelectedFile();
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(destino));
            doc.open();
            doc.add(new Paragraph("BookUsers - " + usuario.getNombreCompleto()));
            doc.add(new Paragraph(" "));
            try {
                com.lowagie.text.Image foto = com.lowagie.text.Image.getInstance(usuario.getRutaFoto());
                foto.scaleToFit(120, 120);
                doc.add(foto);
            } catch (Exception ex) {
                doc.add(new Paragraph("(Foto no disponible)"));
            }
            doc.add(new Paragraph(" "));
            for (String linea : textoInfo().split("\n")) doc.add(new Paragraph(linea));
            doc.close();
            JOptionPane.showMessageDialog(this, "PDF generado en:\n" + destino.getAbsolutePath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se pudo generar el PDF: " + ex.getMessage());
        }
    }
}

