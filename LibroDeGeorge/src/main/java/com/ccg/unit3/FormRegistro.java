package com.ccg.unit3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class FormRegistro {
    private JPanel panelPrincipal;
    private JComboBox cmbTipoId;
    private JTextField txtNumeroId;
    private JTextField txtSegundoApellido;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoNombre;
    private JTextField txtPrimerNombre;
    private JPasswordField txtPassword;
    private JTextField txtTeléfono;
    private JTextField TxtCorreo;
    private JButton btnCargarFoto;
    private JButton btnGuardar;
    private JLabel lblUsername;
    private JLabel lblFoto;
    public FormRegistro(){

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
    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
