
import javax.swing.*;
import java.util.ArrayList;

public class FormListado extends JFrame {
    private JPanel panelPrincipal;
    private JList listaUsuarios;
    private JButton btnVerDetalle;
    private JButton btnVolver;
    private ArrayList<Usuario> usuarios;
    private DefaultListModel<String> modeloLista;

    public FormListado(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        setContentPane(panelPrincipal);
        setTitle("Listado de usuarios");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modeloLista = new DefaultListModel<>();
        listaUsuarios.setModel(modeloLista);

        cargarUsuarios();

        btnVolver.addActionListener(e -> dispose());

        btnVerDetalle.addActionListener(e -> {
            int posicion = listaUsuarios.getSelectedIndex();

            if (posicion == -1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Selecciona un usuario primero"
                );
                return;
            }

            Usuario seleccionado = usuarios.get(posicion);

            FormDetalle detalle = new FormDetalle(seleccionado, usuarios);
            detalle.setVisible(true);
        });

    }

    private void cargarUsuarios() {
        modeloLista.clear();
        for (Usuario usuario : usuarios) {
            modeloLista.addElement(
                    usuario.getId() + " - " +
                            usuario.getPrimerNombre() + " " +
                            usuario.getPrimerApellido() + " - " +
                            usuario.getUsername()
            );
        }
    }
}
