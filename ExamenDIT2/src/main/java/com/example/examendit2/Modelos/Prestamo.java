package com.example.examendit2.Modelos;

import java.time.LocalDate;
import java.util.List;

public class Prestamo {

    private int idLibro;
    private String dniUsuario;
    private LocalDate fechaDevolucion;

    public Prestamo(int idLibro, String dniUsuario) {
        if (idLibro <= 0 || dniUsuario == null || dniUsuario.isEmpty()) {
            throw new IllegalArgumentException("ID de libro inválido o DNI de usuario nulo o vacío");
        }

        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = null;
    }

    public static Prestamo buscarPrestamo(List<Prestamo> prestamos, int idLibro, String dniUsuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro() == idLibro && prestamo.getDniUsuario().equals(dniUsuario)) {
                return prestamo;
            }
        }
        return null;
    }
    public void devolverPrestamo(LocalDate fechaDevolucion) {
        if (fechaDevolucion == null) {
            fechaDevolucion = LocalDate.now();
        }
        // Verificar si la devolución está dentro de la fecha permitida
        if (estaEnFechaDevolucion(fechaDevolucion)) {
            this.fechaDevolucion = fechaDevolucion;
        } else {
            // Manejar el caso de devolución fuera de fecha
            throw new IllegalStateException("Devolución fuera de la fecha permitida");
        }
    }

    // Getters y setters

    public int getIdLibro() {
        return idLibro;
    }

    public boolean estaEnFechaDevolucion(LocalDate fechaDevolucion) {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(this.fechaDevolucion) || fechaActual.isEqual(this.fechaDevolucion);
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
