/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package reclamation.gui; // Assurez-vous de personnaliser le package en fonction de votre projet

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class af extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Charger le fichier FXML (vous devrez personnaliser le chemin du fichier FXML)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("affich.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setTitle("affichage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
