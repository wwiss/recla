/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.gui;

import entities.Reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import service.ReclamationService;

public class AffichierController implements Initializable {

    @FXML
    private TreeView<String> treeView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Créez la racine du TreeView
        TreeItem<String> rootItem = new TreeItem<>("Racine");
        ReclamationService service = new ReclamationService();
        for (Reclamation data : service.getAll()) {
            TreeItem<String> item = new TreeItem<>(data.toString()); // Vous devrez personnaliser cela pour afficher les données comme vous le souhaitez
            rootItem.getChildren().add(item);
        }
        treeView.setRoot(rootItem);
    }

    @FXML
    private void actclickbutton(ActionEvent event) {
        // Code pour gérer l'événement de clic sur le bouton
    }
}
