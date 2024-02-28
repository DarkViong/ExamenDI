package com.example.examendit2.Modelos;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa un préstamo de un libro a un usuario en una biblioteca.
 */
public class Prestamo {

    /** Identificador único del libro prestado. */
    private int idLibro;

    /** DNI del usuario que ha realizado el préstamo. */
    private String dniUsuario;

    /** Fecha de devolución del libro prestado. */
    private LocalDate fechaDevolucion;

    /**
     * Constructor para crear un objeto Prestamo.
     *
     * @param idLibro Identificador único del libro a prestar.
     * @param dniUsuario DNI del usuario que realiza el préstamo.
     * @throws IllegalArgumentException Si el ID de libro es inválido o el DNI de usuario es nulo o vacío.
     */
    public Prestamo(int idLibro, String dniUsuario) {
        if (idLibro <= 0 || dniUsuario == null || dniUsuario.isEmpty()) {
            throw new IllegalArgumentException("ID de libro inválido o DNI de usuario nulo o vacío");
        }

        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = null;
    }

    /**
     * Busca un préstamo en la lista de préstamos.
     *
     * @param prestamos Lista de préstamos donde buscar.
     * @param idLibro Identificador único del libro del préstamo.
     * @param dniUsuario DNI del usuario del préstamo.
     * @return El préstamo encontrado o null si no existe.
     */
    public static Prestamo buscarPrestamo(List<Prestamo> prestamos, int idLibro, String dniUsuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro() == idLibro && prestamo.getDniUsuario().equals(dniUsuario)) {
                return prestamo;
            }
        }
        return null;
    }

    /**
     * Devuelve el libro prestado y registra la fecha de devolución.
     *
     * @param fechaDevolucion Fecha en la que se devuelve el libro. Si es null, se usará la fecha actual.
     * @throws IllegalStateException Si la devolución está fuera de la fecha permitida.
     */
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

    /**
     * Verifica si la fecha de devolución está dentro de la fecha permitida.
     *
     * @param fechaDevolucion Fecha de devolución a verificar.
     * @return true si la fecha de devolución es válida, false en caso contrario.
     */
    public boolean estaEnFechaDevolucion(LocalDate fechaDevolucion) {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(this.fechaDevolucion) || fechaActual.isEqual(this.fechaDevolucion);
    }

    // Getters y setters

    /**
     * Obtiene el identificador único del libro prestado.
     *
     * @return El identificador único del libro prestado.
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el identificador único del libro prestado.
     *
     * @param idLibro El nuevo identificador único del libro prestado.
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Obtiene el DNI del usuario que ha realizado el préstamo.
     *
     * @return El DNI del usuario que ha realizado el préstamo.
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario que ha realizado el préstamo.
     *
     * @param dniUsuario El nuevo DNI del usuario que ha realizado el préstamo.
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Obtiene la fecha de devolución del libro prestado.
     *
     * @return La fecha de devolución del libro prestado.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece la fecha de devolución del libro prestado.
     *
     * @param fechaDevolucion La nueva fecha de devolución del libro prestado.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
