package com.example.examendit2.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.examendit2.Modelos.Prestamo.buscarPrestamo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una biblioteca con libros, préstamos y usuarios.
 */
public class Biblioteca {

    /** Lista de libros en la biblioteca. */
    private List<Libro> libros;

    /** Lista de préstamos realizados en la biblioteca. */
    private List<Prestamo> prestamos;

    /** Lista de usuarios registrados en la biblioteca. */
    private List<Usuario> usuarios;

    /**
     * Constructor por defecto de la clase Biblioteca.
     * Inicializa las listas de libros, préstamos y usuarios.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
        prestamos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    /**
     * Realiza el alta de un nuevo libro en la biblioteca.
     *
     * @param idLibro Identificador único del libro.
     * @param titulo Título del libro.
     * @param isbn ISBN del libro.
     * @param autor Autor del libro.
     * @param tematica Temática del libro.
     * @param fechaEdicion Fecha de edición del libro.
     * @return true si el alta es exitosa, false si ya existe un libro con el mismo Id o ISBN.
     */
    public boolean altaLibro(int idLibro, String titulo, String isbn, String autor, String tematica, LocalDate fechaEdicion) {
        Libro nuevoLibro = new Libro(idLibro, titulo, isbn, autor, tematica, fechaEdicion);

        if (buscarLibroPorId(idLibro) == null && buscarLibroPorIsbn(isbn) == null) {
            libros.add(nuevoLibro);
            return true; // Alta exitosa
        } else {
            return false; // Id o ISBN ya existen
        }
    }


    /**
     * Busca un libro en la biblioteca por su número de ISBN.
     *
     * @param isbn Número de ISBN del libro a buscar.
     * @return El libro con el ISBN proporcionado, o null si no se encuentra.
     */
    private Libro buscarLibroPorIsbn(String isbn) {
        return libros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    /**
     * Realiza la baja de un libro de la biblioteca.
     *
     * @param idLibro Identificador único del libro a dar de baja.
     */
    public void bajaLibro(int idLibro) {
        libros.removeIf(libro -> libro.getIdLibro() == idLibro);
    }

    /**
     * Realiza el préstamo de un libro a un usuario.
     *
     * @param idLibro Identificador único del libro a prestar.
     * @param dniUsuario DNI del usuario al que se presta el libro.
     * @return true si el préstamo es exitoso, false si el libro o el usuario no existen.
     */
    public boolean prestar(int idLibro, String dniUsuario) {
        Libro libro = buscarLibroPorId(idLibro);
        Usuario usuario = buscarUsuarioPorDni(dniUsuario);

        if (libro != null && usuario != null) {
            Prestamo nuevoPrestamo = new Prestamo(idLibro, dniUsuario);
            prestamos.add(nuevoPrestamo);

            if (!usuarios.contains(usuario)) {
                usuarios.add(usuario);
            }

            return true; // Préstamo exitoso
        } else {
            return false; // Préstamo fallido
        }
    }

    /**
     * Realiza la devolución de un libro por parte de un usuario.
     *
     * @param idLibro Identificador único del libro a devolver.
     * @param dniUsuario DNI del usuario que realiza la devolución.
     * @return true si la devolución es exitosa, false si el préstamo no existe.
     */
    public boolean devolver(int idLibro, String dniUsuario) {
        Prestamo prestamo = buscarPrestamo(prestamos, idLibro, dniUsuario);
        LocalDate fechaDevolucion = LocalDate.parse("2022-02-28");

        if (prestamo != null) {
            prestamo.devolverPrestamo(fechaDevolucion);
            return true; // Devolución exitosa
        } else {
            return false; // Devolución fallida
        }
    }

    private Libro buscarLibroPorId(int idLibro) {
        return libros.stream().filter(libro -> libro.getIdLibro() == idLibro).findFirst().orElse(null);
    }

    private Usuario buscarUsuarioPorDni(String dniUsuario) {
        return usuarios.stream().filter(usuario -> usuario.getDniUsuario().equals(dniUsuario)).findFirst().orElse(null);
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}

