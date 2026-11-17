package claseuser;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FormRegistro {
    private JComboBox opciones;
    private JTextField numeroid;
    private JTextField pnombre;
    private JTextField snombre;
    private JTextField papellido;
    private JTextField sapellido;
    private JPasswordField contrasenna;
    private JTextField telefono;
    private JButton ok;
    private JLabel user;
    private JTextField correo;
    private JLabel foto;

    public FormRegistro() {
        this.opciones = new JComboBox();
        this.contrasenna = new JPasswordField();
        this.telefono = new JTextField();
        this.sapellido = new JTextField();
        this.snombre = new JTextField();
        this.papellido = new JTextField();
        this.pnombre = new JTextField();
        this.numeroid = new JTextField();
        this.ok = new JButton("Registrar");
        this.user = new JLabel("Usuario:");
        this.foto = new JLabel("Foto:");
        this.correo = new JTextField();
    }

    public static void main (String[] args) {
        JFrame FormMenu = new JFrame("BookUsers . Manuel Montes");
        FormMenu.setSize(300,200);
        FormMenu.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        JFrame FormRegistro = new JFrame("Registro de Usuarios");
        FormRegistro.setSize(300,200);
        FormRegistro.setLocationRelativeTo(FormMenu);

        FormRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton registrar = new JButton("Registrar");
        registrar.addActionListener(e -> FormRegistro.setVisible(true));

        FormRegistro.add(registrar);
        FormMenu.setVisible(true);

        String[] tipo = {"11 RC", "12 TI", "13 CC", "21 TE", "22 CE","41 PP","42 DIE","47 PEP","91 NUIP"};
        JComboBox<String> opciones= new JComboBox(tipo);


    }

}
