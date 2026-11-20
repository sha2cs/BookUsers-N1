package com.ccg.unit3;

public class Usuario {
    private int id;
    private String TipodeIdentificacion;
    private String NumerodeIdentificacion;
    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private String Username;
    private String Contraseña;
    private String Telefono;
    private String Correo;
    private String RutaFoto;

    public Usuario(int id, String tipodeIdentificacion, String numerodeIdentificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String username, String contraseña, String telefono, String correo, String rutaFoto) {
        this.id = id;
        this.TipodeIdentificacion = tipodeIdentificacion;
        this.NumerodeIdentificacion = numerodeIdentificacion;
        this.PrimerNombre = primerNombre;
        this.SegundoNombre = segundoNombre;
        this.PrimerApellido = primerApellido;
        this.SegundoApellido = segundoApellido;
        this.Username = username;
        this.Contraseña = contraseña;
        this.Telefono = telefono;
        this.Correo = correo;
        this.RutaFoto = rutaFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipodeIdentificacion() {
        return TipodeIdentificacion;
    }

    public void setTipodeIdentificacion(String tipodeIdentificacion) {
        TipodeIdentificacion = tipodeIdentificacion;
    }

    public String getNumerodeIdentificacion() {
        return NumerodeIdentificacion;
    }

    public void setNumerodeIdentificacion(String numerodeIdentificacion) {
        NumerodeIdentificacion = numerodeIdentificacion;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getRutaFoto() {
        return RutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        RutaFoto = rutaFoto;
    }

    @Override
    public String toString() {
        return id + "-" + PrimerNombre + " " + PrimerApellido;
    }


}
