package com.example.examendit2.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.examendit2.Modelos.Prestamo.buscarPrestamo;

public class Biblioteca {

    private List<Libro> libros;
    private List<Prestamo> prestamos;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        prestamos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public boolean altaLibro(int idLibro, String titulo, String isbn, String autor, String tematica, LocalDate fechaEdicion) {
        Libro nuevoLibro = new Libro(idLibro, titulo, isbn, autor, tematica, fechaEdicion);

        // Verificar si ya existe un libro con el mismo Id o ISBN
        if (buscarLibroPorId(idLibro) == null && buscarLibroPorIsbn(isbn) == null) {
            libros.add(nuevoLibro);
            return true; // Alta exitosa
        } else {
            return false; // Id o ISBN ya existen
        }
    }
    private Libro buscarLibroPorIsbn(String isbn) {
        return libros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public void bajaLibro(int idLibro) {
        libros.removeIf(libro -> libro.getIdLibro() == idLibro);
    }

    public boolean prestar(int idLibro, String dniUsuario) {
        Libro libro = buscarLibroPorId(idLibro);
        Usuario usuario = buscarUsuarioPorDni(dniUsuario);

        if (libro != null && usuario != null) {
            Prestamo nuevoPrestamo = new Prestamo(idLibro, dniUsuario);
            prestamos.add(nuevoPrestamo);

            // Si es el primer préstamo del usuario, crea el usuario
            if (!usuarios.contains(usuario)) {
                usuarios.add(usuario);
            }

            return true; // Préstamo exitoso
        } else {
            return false; // Préstamo fallido
        }
    }

    public boolean devolver(int idLibro, String dniUsuario) {

        Prestamo prestamo = buscarPrestamo(prestamos,idLibro, dniUsuario);
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

}

