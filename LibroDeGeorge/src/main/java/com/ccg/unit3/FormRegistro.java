package com.ccg.unit3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
public class FormRegistro {
    private ArrayList<Usuario> usuarios;
    private FormMenu menu;
    private JPanel panelPrincipal;
    private JComboBox cmbTipoId;
    private JTextField txtNumeroId;
    private JTextField txtSegundoApellido;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerNombre;
    private JPasswordField txtPassword;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JButton btnCargarFoto;
    private JButton btnGuardar;
    private JLabel lblUsername;
    private JLabel lblFoto;
    public FormRegistro(ArrayList<Usuario>usuarios, FormMenu menu){

        this.usuarios = usuarios;
        this.menu = menu;

        DocumentListener listener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                generarUsername();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                generarUsername();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                generarUsername();

            }
        };

        txtSegundoApellido.getDocument().addDocumentListener(listener);
        txtSegundoNombre.getDocument().addDocumentListener(listener);
        txtPrimerNombre.getDocument().addDocumentListener(listener);
    }
    private void generarUsername() {

        String nombre = txtPrimerNombre.getText().trim();
        String apellido1 = txtPrimerApellido.getText().trim();
        String apellido2 = txtSegundoApellido.getText().trim();

        btnGuardar.addActionListener(e -> {
            guardarUsuario();
        });

        String username = "";

        if (!apellido1.isEmpty()) {
            username += apellido1.substring(0, 1);
        }

        if (!apellido2.isEmpty()) {
            username += apellido2.substring(0, 1);
        }

        username += nombre;

        username = java.text.Normalizer.normalize(
                username, java.text.Normalizer.Form.NFD);

        username = username.replaceAll("\\p{M}", "");
        username = username.toLowerCase().replaceAll("\\s+", "");

        lblUsername.setText(username);
    }

    private void guardarUsuario() {

        String nombre = txtPrimerNombre.getText().trim();
        String apellido = txtPrimerApellido.getText().trim();
        String numeroId = txtNumeroId.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (nombre.isEmpty() || apellido.isEmpty() ||
        numeroId.isEmpty() || telefono.isEmpty() ||
        correo.isEmpty() || password.isEmpty()) {
        }

        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El correo debe contener @."
            );
            return;
        }
        int id = menu.GenerarId();

        Usuario nuevoUsuario = new Usuario(
                id,
                cmbTipoId.getSelectedItem().toString(),
                numeroId,
                nombre,
                txtSegundoNombre.getText().trim(),
                apellido,
                txtSegundoApellido.getText().trim(),
                lblUsername.getText(),
                password,
                telefono,
                correo,
                ""
        );
    }
    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
