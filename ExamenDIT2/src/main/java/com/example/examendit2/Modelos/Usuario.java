package com.example.examendit2.Modelos;

import java.time.LocalDate;

public class Usuario {

    private String dniUsuario;
    private LocalDate fechaAltaSancion;

    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
        this.fechaAltaSancion = null; // Inicialmente, no hay sanción
    }

    public void sancionar() {
        this.fechaAltaSancion = LocalDate.now();
    }

    public void quitarSancion() {
        this.fechaAltaSancion = null; // Al quitar la sanción, la fecha se establece como nula
    }

    // Getters y setters

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public LocalDate getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    public void setFechaAltaSancion(LocalDate fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }
}
