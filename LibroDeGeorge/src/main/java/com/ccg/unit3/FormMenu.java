package com.ccg.unit3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMenu {

    private JPanel Menu;
    private JButton btnRegistrar;
    private JButton btnListado;

    public FormMenu() {
        btnListado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormMenu");
        frame.setContentPane(new FormMenu().Menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
