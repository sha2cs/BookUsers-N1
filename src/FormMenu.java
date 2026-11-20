import javax.swing.*;
import java.util.ArrayList;

public class FormMenu extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnRegistro;
    private JButton btnListado;
    private JButton btnCreditos;
    private JLabel lblTitulo;

    private ArrayList<Usuario> usuarios = new ArrayList<>();

 public FormMenu () {
     setContentPane(panelPrincipal);
     setTitle("BookUsers - Daurith Barva Sergio Fierro");

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(400, 500);
     setLocationRelativeTo(null);

     btnRegistro.addActionListener(e -> {
         FormRegistro ventana = new FormRegistro(usuarios);
         ventana.setVisible(true);
     });

     btnListado.addActionListener(e -> {
         FormListado ventana = new FormListado(usuarios);
         ventana.setVisible(true);
     });

 }

 public static void main(String[] args){
     FormMenu ventana = new FormMenu();
     ventana.setVisible(true);

 }
}

