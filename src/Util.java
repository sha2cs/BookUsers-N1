import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.Normalizer;

public class Util {
    private static String limpiar(String s) {
        String n = Normalizer.normalize(s.trim(), Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return n.toLowerCase().replace(" ", "");
    }

    // primera letra 1er apellido + primera letra 2do apellido + primer nombre
    public static String generarUsername(String nombre, String ap1, String ap2) {
        String n = limpiar(nombre), a1 = limpiar(ap1), a2 = limpiar(ap2);
        if (n.isEmpty() || a1.isEmpty()) return "";
        return a1.substring(0, 1) + (a2.isEmpty() ? "" : a2.substring(0, 1)) + n;
    }

    // Devuelve la imagen escalada a w x h, o null si no se puede leer
    public static ImageIcon cargarIcono(String ruta, int w, int h) {
        try {
            if (ruta == null || ruta.isEmpty()) return null;
            BufferedImage img = ImageIO.read(new File(ruta));
            if (img == null) return null;
            return new ImageIcon(img.getScaledInstance(w, h, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            return null;
        }
    }
}
