package claseuser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FormMenu {
    public static void main(String[] args) {
        private static ArrayList<Claseuser> usuario = new ArrayList<>();
        private static int contadorId = 1;
        List<Claseuser> lista = new ArrayList<>();
        lista.add(new Claseuser(lista.size()+1));

        JFrame FormMenu = new JFrame();
        FormMenu.setTitle("BookUser . Manuel Montes");
        FormMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FormMenu.setSize(800,600);
        FormMenu.setVisible(true);

        


    }
}
