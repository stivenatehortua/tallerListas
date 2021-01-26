package com.tcs.tallerlistas.beans;

public class Estudiante {

    private String id;
    private String nombre;
    private String edad;
    private String grado;
    private String aprobado;

    public Estudiante(String id, String nombre, String edad, String grado, String aprobado) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
        this.aprobado = aprobado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", grado='" + grado + '\'' +
                ", aprobado='" + aprobado + '\'' +
                '}';
    }
}
