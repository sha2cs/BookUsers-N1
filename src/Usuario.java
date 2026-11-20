
public class Usuario {

    private int id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String username;
    private String password;
    private String telefono;
    private String correo;
    private String rutaFoto;

    public Usuario(int id, String tipoIdentificacion, String numeroIdentificacion,
                   String primerNombre, String segundoNombre, String primerApellido,
                   String segundoApellido, String password, String telefono,
                   String correo, String rutaFoto) {

        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.password = password;
        this.telefono = telefono;
        this.correo = correo;
        this.rutaFoto = rutaFoto;

        this.username = generarUsername();
    }

    public String generarUsername() {
        String nombre = primerNombre.toLowerCase().trim();
        String apellido1 = primerApellido.toLowerCase().trim();
        String apellido2 = segundoApellido.toLowerCase().trim();

        nombre = nombre.replace("á", "a").replace("é", "e")
                .replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace("ñ", "n")
                .replace(" ", "");

        apellido1 = apellido1.replace("á", "a").replace("é", "e")
                .replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace("ñ", "n");

        apellido2 = apellido2.replace("á", "a").replace("é", "e")
                .replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace("ñ", "n");

        String usuario = "";

        if (!apellido1.isEmpty()) {
            usuario = apellido1.substring(0, 1);
        }

        if (!apellido2.isEmpty()) {
            usuario = usuario + apellido2.substring(0, 1);
        }

        usuario = usuario + nombre;

        return usuario;
    }

    public int getId() {
        return id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        this.username = generarUsername();
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        this.username = generarUsername();
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        this.username = generarUsername();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    @Override
    public String toString() {
        return primerNombre + " " + primerApellido + " - " + numeroIdentificacion;
    }
}
