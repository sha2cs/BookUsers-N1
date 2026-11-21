public class Usuario {
    // Contador que solo crece: nunca se calcula con size()
    private static int contadorId = 1;
    public static int nuevoId() { return contadorId++; }

    private int id;
    private String tipoIdentificacion, numeroIdentificacion;
    private String primerNombre, segundoNombre, primerApellido, segundoApellido;
    private String username, password, telefono, correo, rutaFoto;

    public Usuario(int id, String tipoIdentificacion, String numeroIdentificacion,
                   String primerNombre, String segundoNombre, String primerApellido,
                   String segundoApellido, String username, String password,
                   String telefono, String correo, String rutaFoto) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.correo = correo;
        this.rutaFoto = rutaFoto;
    }

    public int getId() { return id; }
    public String getTipoIdentificacion() { return tipoIdentificacion; }
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public String getPrimerNombre() { return primerNombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getPrimerApellido() { return primerApellido; }
    public String getSegundoApellido() { return segundoApellido; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getRutaFoto() { return rutaFoto; }

    public void setTipoIdentificacion(String v) { tipoIdentificacion = v; }
    public void setNumeroIdentificacion(String v) { numeroIdentificacion = v; }
    public void setPrimerNombre(String v) { primerNombre = v; }
    public void setSegundoNombre(String v) { segundoNombre = v; }
    public void setPrimerApellido(String v) { primerApellido = v; }
    public void setSegundoApellido(String v) { segundoApellido = v; }
    public void setUsername(String v) { username = v; }
    public void setPassword(String v) { password = v; }
    public void setTelefono(String v) { telefono = v; }
    public void setCorreo(String v) { correo = v; }
    public void setRutaFoto(String v) { rutaFoto = v; }

    public String getNombreCompleto() {
        return (primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido)
                .trim().replaceAll("\\s+", " ");
    }

    @Override
    public String toString() {
        return id + " | " + username + " | " + getNombreCompleto();
    }
}
