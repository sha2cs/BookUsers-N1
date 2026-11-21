package claseuser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormMenu extends JFrame{

   private JPanel menu;
    private JButton registro;
    private JButton listado;
    private JButton credito;


    public FormMenu () {
        registro=new JButton("Registrar");
        listado=new JButton("Listado");
        credito=new JButton("Credito");

        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                FormRegistro formRegistro = new FormRegistro ();
                registro.setLocation(30,30);
                registro.setVisible(true);
                registro.setSize(20,20);
            }
        });

        add(listado);
        listado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                FormListado listado = new FormListado();
                listado.setVisible(true);
                listado.setBounds(50,50,120,30);

            }
        });
        add(credito);
        credito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                FormCreditos creditos1 = new FormCreditos();
                credito.setVisible(true);
            }
        });
        setContentPane(menu);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }



    public static void main(String[] args) {
        ArrayList <Claseuser> usuario =new ArrayList <Claseuser>();

        List<Claseuser> lista = new ArrayList<>();

        for (Claseuser c : lista) {
            System.out.println(" " + c.getId());
        }

        JFrame FormMenu = new JFrame();
        FormMenu.setTitle("BookUser . Manuel Montes");
        FormMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FormMenu.setSize(800,600);
        FormMenu.setVisible(true);


       }

}