import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormListado extends JFrame {
    private JPanel panelPrincipal;
    private JList<Usuario> lstUsuarios;
    private DefaultListModel<Usuario> modelo;
    private JButton btnVerDetalle, btnEliminar, btnRefrescar;
    private ArrayList<Usuario> usuarios;

    public FormListado(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        setTitle("BookUsers - Listado");

        modelo = new DefaultListModel<>();
        lstUsuarios = new JList<>(modelo);
        btnVerDetalle = new JButton("Ver detalle");
        btnEliminar = new JButton("Eliminar");
        btnRefrescar = new JButton("Refrescar");

        JPanel botones = new JPanel(new GridLayout(1, 3, 6, 6));
        botones.add(btnVerDetalle); botones.add(btnEliminar); botones.add(btnRefrescar);

        panelPrincipal = new JPanel(new BorderLayout(8, 8));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(new JScrollPane(lstUsuarios), BorderLayout.CENTER);
        panelPrincipal.add(botones, BorderLayout.SOUTH);
        setContentPane(panelPrincipal);

        btnVerDetalle.addActionListener(e -> {
            int i = lstUsuarios.getSelectedIndex();
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un usuario.");
                return;
            }
            new FormDetalle(modelo.getElementAt(i)).setVisible(true);
        });
        btnEliminar.addActionListener(e -> eliminar());
        btnRefrescar.addActionListener(e -> cargarModelo());

        cargarModelo();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
    }

    private void cargarModelo() {
        modelo.clear();
        for (Usuario u : usuarios) modelo.addElement(u);
    }

    private void eliminar() {
        int i = lstUsuarios.getSelectedIndex();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario.");
            return;
        }
        Usuario u = modelo.getElementAt(i);
        int r = JOptionPane.showConfirmDialog(this, "¿Eliminar a " + u.getNombreCompleto() + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            usuarios.remove(u);
            cargarModelo();
        }
    }
}

