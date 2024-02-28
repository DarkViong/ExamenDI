package com.example.examendit2.Pantallas;
import com.example.examendit2.Utils.LoaderScreen;
import com.example.examendit2.Modelos.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
/**
 * Controlador para la interfaz de la biblioteca.
 */
public class BibliotecaController{

    @FXML
    private TableView<Libro> tablaLibros;
    @FXML
    private TableColumn<Libro, String> idAutor;

    @FXML
    private TableColumn<Libro, LocalDate> idFechaEdicion;

    @FXML
    private TableColumn<Libro, String> idISBN;

    @FXML
    private TableColumn<Libro, Integer> idLibro;

    @FXML
    private TableColumn<Libro, String> idTematica;

    @FXML
    private TableColumn<Libro, String> idTitulo;

    private final ObservableList<Libro> libros = FXCollections.observableArrayList();
    /**
     * Obtiene la lista observable de libros.
     *
     * @return La lista observable de libros.
     */
    public ObservableList<Libro> getDispositivos() {
        return libros;
    }
    /**
     * Inicializa la interfaz de la biblioteca.
     */
    @FXML
    public void initialize() {
        // vincular la lista a la tabla
        tablaLibros.setItems(libros);

        // configurar las columnas
        idLibro.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        idISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        idAutor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        idFechaEdicion.setCellValueFactory(new PropertyValueFactory<>("fechaCompra"));
        idTematica.setCellValueFactory(new PropertyValueFactory<>("Tematica"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        idFechaEdicion.setCellFactory(column -> new TableCell<Libro, LocalDate>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(dateFormat.format(item));
                }
            }
        });
    }
    /**
     * Maneja el evento de añadir libros.
     *
     * @param event El evento de añadir libros.
     */
    @FXML
    public void añadirLibros(ActionEvent event) {
        // Llamar a la ventana de añadir dispositivo
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Esto hará que la ventana de alta sea modal
            Object controller = LoaderScreen.loadScreen("/com/example/practicafinaldi/pantallaAnyadirDispositivo.fxml", stage);

            stage.setOnHidden(e -> {
                if (Objects.nonNull(((LibroController)controller).getLibro())) {
                    Libro nuevoDispositivo = ((LibroController)controller).getLibro();
                    libros.add(nuevoDispositivo);
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
