package com.ccg.unit3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormMenu {

    private JPanel PanelPrincipal;
    private JButton btnRegistrar;
    private JButton btnListado;
    private JButton btnCreditos;
    private ArrayList<Usuario> Usuarios = new ArrayList<>();

    public FormMenu() {
        btnListado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormRegistro registro = new FormRegistro();

                JFrame ventana = new JFrame("BookUsers - Registrar usuario");

                ventana.setContentPane(registro.getPanelPrincipal());
                ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventana.setSize(600, 700);
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BookUsers. George Cardozo Castellar");
        frame.setContentPane(new FormMenu().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setResizable(false);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
