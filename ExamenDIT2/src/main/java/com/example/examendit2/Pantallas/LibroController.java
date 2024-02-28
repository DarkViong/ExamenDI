package com.example.examendit2.Pantallas;

import com.example.examendit2.Modelos.Libro;
import com.example.examendit2.Modelos.TipoTematica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 * Controlador para la interfaz de añadir/modificar libro.
 */
public class LibroController {

    private Libro libro;
    // TEXTFIELDS
    @FXML
    private TextField fechaEdicionText;
    @FXML
    private TextField idText;
    @FXML
    private TextField tituloText;
    @FXML
    private TextField isbnText;
    @FXML
    private TextField autorText;
    @FXML
    private TextField tematicaText;

    /**
     * Maneja el evento del botón de cancelar.
     *
     * @param event El evento de clic en el botón de cancelar.
     */
    @FXML
    void CancelButton(ActionEvent event) {
        // limpiar campos
        idText.clear();
        tituloText.clear();
        isbnText.clear();
        autorText.clear();
        tematicaText.clear();
        fechaEdicionText.clear();

        // cerrar ventana
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    /**
     * Maneja el evento del botón de confirmar.
     *
     * @param event El evento de clic en el botón de confirmar.
     */
    @FXML
    void handleOkButton(ActionEvent event) {
        // obtener datos de los campos
        int id;
        try {
            id = Integer.parseInt(idText.getText());
        } catch (NumberFormatException e) {
            System.err.println("ID no válido: " + idText.getText());
            return; // Salir del método handleOkButton
        }

        String titulo = tituloText.getText();
        String isbn = isbnText.getText();
        String autor = autorText.getText();
        String tematica = tematicaText.getText();

        // Convertir String a Date
        LocalDate fechaEdicion;
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaEdicion = LocalDate.parse(fechaEdicionText.getText(), dateFormatter);
        } catch (DateTimeParseException e) {
            System.err.println("Formato de fecha no válido: " + fechaEdicionText.getText());
            return; // Salir del método handleOkButton
        }

        // convertir String a TipoDispositivo
        /*TipoTematica tipo;
        try {
            tipo = TipoTematica.valueOf(tipoStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Tipo de dispositivo no válido: " + tipoStr);
            return; // Salir del método handleOkButton
        }*/

        // crear dispositivo
        this.libro = new Libro(id, titulo, isbn, autor,tematica, fechaEdicion);
        System.out.println(libro);

        // cerrar la ventana
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Obtiene el libro creado o modificado.
     *
     * @return El libro creado o modificado.
     */
    public Libro getLibro() {
        System.out.println(libro);
        return libro;
    }
}
