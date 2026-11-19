import javax.swing.*;
import java.util.ArrayList;

public class FormListado extends JFrame {



    private JPanel panelPrincipal;
    private JList ListaUsuarios;
    private ArrayList<Usuario> usuarios;
    private JButton btnVerDetalle;





        public FormListado(ArrayList<Usuario> Usuarios) {
            this.ListaUsuarios = ListaUsuarios;
            setTitle("BookUsers - Listado de Usuarios");
            setContentPane(panelPrincipal);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ventanas secundarias usan DISPOSE
            setSize(400, 300);
            setLocationRelativeTo(null);
        }}

