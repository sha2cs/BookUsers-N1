import javax.swing.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





public class FormListado extends JFrame {


    private JPanel panelPrincipal;
    private JList<String> ListaUsuarios;
    private ArrayList<Usuario> usuarios;
    private JButton btnVerDetalle;


    public FormListado(ArrayList<Usuario> Usuarios) {
        this.usuarios = Usuarios;
        setTitle("BookUsers - Listado de Usuarios");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ventanas secundarias usan DISPOSE
        setSize(400, 300);
        setLocationRelativeTo(null);

        cargarUsuarios();
        configurarEventos();

    }


    private void cargarUsuarios() {


                DefaultListModel<String> modelo = new DefaultListModel<>();
                if (usuarios != null) {


                    for (Usuario usuario : usuarios) {
                        String elemento = usuario.getId() + " - "
                                + usuario.getPrimerNombre() + " "
                                + usuario.getPrimerApellido()
                                + " (" + usuario.getUsername() + ")";
                        modelo.addElement(elemento);


                    }
                }
                ListaUsuarios.setModel(modelo);


            }
            private void configurarEventos() {
                btnVerDetalle.addActionListener(e -> {
                    int indice = ListaUsuarios.getSelectedIndex();
                    if (indice < 0 || usuarios == null || indice >= usuarios.size()) {
                        JOptionPane.showMessageDialog(this, "Selecciona un usuario de la lista.");
                        return;
                    }
                    Usuario usuarioSeleccionado = usuarios.get(indice);
                    new FormDetalle(usuarioSeleccionado).setVisible(true);
                });
        }}

