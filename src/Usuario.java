public class Usuario {
    private int id;
    private String tipoIdentificacion;
    private String primerNombre;
    private String sedundoNombre;
    private String primerApellido;
    private String sedundoApellido;
    private String username;
    private String password;
    private String telefono;
    private String email;
    private String rutaFoto;

    public Usuario(int id, String tipoIdentificacion, String primerNombre, String sedundoApellido, String primerApellido, String sedundoNombre, String username, String password, String telefono, String email, String rutaFoto) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.primerNombre = primerNombre;
        this.sedundoApellido = sedundoApellido;
        this.primerApellido = primerApellido;
        this.sedundoNombre = sedundoNombre;
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
        this.rutaFoto = rutaFoto;
    }

    private String generarUsername(){
        String pa = limpiar(primerApellido);
        String sa = limpiar(sedundoApellido);
        String pn = limpiar(primerNombre);

        String letra1 = pa.isEmpty() ? "" : pa.substring(0, 1);
        String letra2 = sa.isEmpty() ? "" : sa.substring(0, 1);

        return letra1 + letra2 + pn;

    }

    public int getId() {
        return id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSedundoNombre() {
        return sedundoNombre;
    }

    public String getSedundoApellido() {
        return sedundoApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
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

    public String getRutaFoto() {
        return rutaFoto;
    }

    public String getEmail() {
        return email;
    }

    private String limpiar(String texto){
        if (texto == null) return "";
        texto = texto.trim().toLowerCase();
        texto = texto.replace("ñ" ,"n");
        texto = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        texto = texto.replaceAll("[^a-z0-9]","");
        return texto;
 }
}

