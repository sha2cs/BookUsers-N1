import javax.swing.*;
import java.awt.*;

public class FormCreditos extends JFrame {
    private JPanel panelPrincipal;

    public FormCreditos() {
        setTitle("BookUsers - Créditos");
        panelPrincipal = new JPanel(new GridLayout(2, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        // <-- cambien estos datos por los de ustedes
        panelPrincipal.add(new JLabel("<html><b>Nombre Apellido</b><br>Código: 0000000<br>correo1@universidad.edu.co</html>"));
        panelPrincipal.add(new JLabel("<html><b>Nombre Apellido</b><br>Código: 0000000<br>correo2@universidad.edu.co</html>"));
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(380, 260);
        setLocationRelativeTo(null);
    }
}