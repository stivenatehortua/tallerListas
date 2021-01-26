package com.tcs.tallerlistas.beans;

public class Excepciones extends Throwable {

    private final String codigo;
    private final String causa;
    private final String error;

    public Excepciones(String codigo, String causa, String error) {
        this.codigo = codigo;
        this.causa = causa;
        this.error = error;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCausa() {
        return causa;
    }

    public String getError() {
        return error;
    }

}
