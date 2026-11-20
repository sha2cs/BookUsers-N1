package claseuser;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FormCreditos extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblFoto1;
    private JLabel lblFoto2;
    private JButton btnCerrar;

    // Constructor sin parámetros (según arquitectura de la sección 2)
    public FormCreditos() {
        setContentPane(panelPrincipal);
        setTitle("BookUsers · Créditos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(480, 360);
        setLocationRelativeTo(null);

        cargarFotosIntegrantes();
        configurarEventos();
    }

    private void cargarFotosIntegrantes() {
        // Opcional: Si guardas fotos dentro de una carpeta de recursos (ej. /img/integrante1.jpg)
        // Si no vas a poner fotos, puedes dejar estos métodos comentados o eliminar los JLabel
        escalarFotoRecurso("/img/integrante1.jpg", lblFoto1);
        escalarFotoRecurso("/img/integrante2.jpg", lblFoto2);
    }

    private void escalarFotoRecurso(String rutaRecurso, JLabel etiquetaDestino) {
        if (etiquetaDestino == null) return;

        URL urlImagen = getClass().getResource(rutaRecurso);
        if (urlImagen != null) {
            ImageIcon iconoOriginal = new ImageIcon(urlImagen);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            etiquetaDestino.setIcon(new ImageIcon(imagenEscalada));
            etiquetaDestino.setText("");
        }
    }

    private void configurarEventos() {
        if (btnCerrar != null) {
            btnCerrar.addActionListener(e -> dispose());
        }
    }
}
