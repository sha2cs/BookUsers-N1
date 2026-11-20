
import javax.swing.*;

public class FormCreditos extends JFrame {

    private JPanel panelPrincipal;
    private JButton btnVolver;

    public FormCreditos() {
        setContentPane(panelPrincipal);
        setTitle("Créditos - BookUsers");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnVolver.addActionListener(e -> dispose());
    }

}
