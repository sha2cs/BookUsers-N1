package claseuser;
import javax.swing.*;
import java.util.ArrayList;

public class FormListado extends JFrame {
    private JPanel panelPrincipal;
    private JList<Claseuser> lstUsuarios;
    private JButton btnVerDetalle;
    private JButton btnCerrar;

    private ArrayList<Claseuser> usuarios;
    private DefaultListModel<Claseuser> modeloLista;

    public FormListado(ArrayList<Claseuser> usuarios) {
        this.usuarios = usuarios;

        setContentPane(panelPrincipal);
        setTitle("BookUsers · Listado de Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        cargarUsuariosEnLista();
        configurarEventos();
    }

    private void cargarUsuariosEnLista() {
        modeloLista = new DefaultListModel<>();
        for (Claseuser u : usuarios) {
            modeloLista.addElement(u);
        }
        lstUsuarios.setModel(modeloLista);
    }

    private void configurarEventos() {
        btnVerDetalle.addActionListener(e -> abrirDetalleUsuario());

        if (btnCerrar != null) {
            btnCerrar.addActionListener(e -> dispose());
        }
    }

    private void abrirDetalleUsuario() {
        int indiceSeleccionado = lstUsuarios.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor selecciona un usuario de la lista para ver su detalle.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }


        Claseuser usuarioSeleccionado = lstUsuarios.getSelectedValue();
        FormDetalle ventanaDetalle = new FormDetalle(usuarioSeleccionado);
        ventanaDetalle.setVisible(true);
    }
}
