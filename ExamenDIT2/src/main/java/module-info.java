module com.example.examendit2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examendit2 to javafx.fxml;
    exports com.example.examendit2;
}