package com.example.examendit2.Modelos;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa un libro en una biblioteca.
 */
public class Libro {

    /** Identificador único del libro. */
    private int idLibro;

    /** Título del libro. */
    private String titulo;

    /** ISBN del libro. */
    private String isbn;

    /** Autor del libro. */
    private String autor;

    /** Temática del libro. */
    private String tematica;

    /** Fecha de edición del libro. */
    private LocalDate fechaEdicion;

    /**
     * Constructor para crear un objeto Libro con información completa.
     *
     * @param idLibro Identificador único del libro.
     * @param titulo Título del libro.
     * @param isbn ISBN del libro.
     * @param autor Autor del libro.
     * @param tematica Temática del libro.
     * @param fechaEdicion Fecha de edición del libro.
     */
    public Libro(int idLibro, String titulo, String isbn, String autor, String tematica, LocalDate fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Constructor para crear un objeto Libro con información básica.
     *
     * @param idLibro Identificador único del libro.
     * @param titulo Título del libro.
     * @param isbn ISBN del libro.
     */
    public Libro(int idLibro, String titulo, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    /**
     * Obtiene el identificador único del libro.
     *
     * @return El identificador único del libro.
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param idLibro El nuevo identificador único del libro.
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn El nuevo ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor El nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la temática del libro.
     *
     * @return La temática del libro.
     */
    public String getTematica() {
        return tematica;
    }

    /**
     * Establece la temática del libro.
     *
     * @param tematica La nueva temática del libro.
     */
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    /**
     * Obtiene la fecha de edición del libro.
     *
     * @return La fecha de edición del libro.
     */
    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Establece la fecha de edición del libro.
     *
     * @param fechaEdicion La nueva fecha de edición del libro.
     */
    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Compara este objeto Libro con otro objeto para determinar si son iguales.
     *
     * @param o El objeto con el que se va a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return idLibro == libro.idLibro && Objects.equals(isbn, libro.isbn);
    }

    /**
     * Calcula un código hash para este objeto Libro.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idLibro, isbn);
    }
}
