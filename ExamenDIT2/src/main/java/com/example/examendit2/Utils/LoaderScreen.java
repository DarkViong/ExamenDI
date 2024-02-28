package com.example.examendit2.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoaderScreen {
    public static Object loadScreen(String fxml, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoaderScreen.class.getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        return loader.getController();
    }
}
