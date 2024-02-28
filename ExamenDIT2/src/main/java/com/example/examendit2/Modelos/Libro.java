package com.example.examendit2.Modelos;

import java.time.LocalDate;
import java.util.Objects;
 public class Libro {

        private int idLibro;
        private String titulo;
        private String isbn;
        private String autor;
        private String tematica;
        private LocalDate fechaEdicion;

        public Libro(int idLibro, String titulo, String isbn, String autor, String tematica, LocalDate fechaEdicion) {
            this.idLibro = idLibro;
            this.titulo = titulo;
            this.isbn = isbn;
            this.autor = autor;
            this.tematica = tematica;
            this.fechaEdicion = fechaEdicion;
        }

        public Libro(int idLibro,String titulo, String isbn) {
            this.idLibro = idLibro;
            this.titulo = titulo;
            this.isbn = isbn;
        }


        // Getters y setters

        public int getIdLibro() {
            return idLibro;
        }

        public void setIdLibro(int idLibro) {
            this.idLibro = idLibro;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getTematica() {
            return tematica;
        }

        public void setTematica(String tematica) {
            this.tematica = tematica;
        }

        public LocalDate getFechaEdicion() {
            return fechaEdicion;
        }

        public void setFechaEdicion(LocalDate fechaEdicion) {
            this.fechaEdicion = fechaEdicion;
        }

        // Equals y hashCode para comparar objetos Libro

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Libro libro = (Libro) o;
            return idLibro == libro.idLibro && Objects.equals(isbn, libro.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idLibro, isbn);
        }
    }


