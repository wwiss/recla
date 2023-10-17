/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.gui;

import entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.event.ActionEvent;
import service.ReclamationService;

public class AffichController implements Initializable {

    @FXML
    private TreeView<String> treeview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
   
    // Créez la racine du TreeView
    TreeItem<String> rootItem = new TreeItem<>("Réclamations");
    ReclamationService service = new ReclamationService();
    for (Reclamation reclamation : service.getAll()) {
        TreeItem<String> reclamationItem = new TreeItem<>(reclamation.toString());

        // Créez des sous-TreeItems pour afficher les détails de la réclamation
        TreeItem<String> numeroMobileItem = new TreeItem<>("Numéro mobile : " + reclamation.getNumero_mobile());
        TreeItem<String> descriptionItem = new TreeItem<>("Description : " + reclamation.getDescription());
        TreeItem<String> objetItem = new TreeItem<>("Objet : " + reclamation.getObjet());
        TreeItem<String> nomItem = new TreeItem<>("Nom : " + reclamation.getNom());
        TreeItem<String> prenomItem = new TreeItem<>("Prénom : " + reclamation.getPrenom());
        TreeItem<String> emailItem = new TreeItem<>("Email : " + reclamation.getEmail());

        // Ajoutez les détails comme enfants de l'élément de réclamation
        reclamationItem.getChildren().addAll(numeroMobileItem, descriptionItem, objetItem, nomItem, prenomItem, emailItem);

        // Ajoutez l'élément de réclamation à la racine
        rootItem.getChildren().add(reclamationItem);
    }

    // Définissez la racine du TreeView
    treeview.setRoot(rootItem);
}


    

    @FXML
    private void SUPP(ActionEvent event) {
        // Affichez une boîte de dialogue de confirmation
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Suppression par ID");
        dialog.setHeaderText(null);
        dialog.setContentText("Entrez l'ID de la réclamation à supprimer :");

        Optional<String> resultId = dialog.showAndWait();
        if (resultId.isPresent()) {
            try {
                int id = Integer.parseInt(resultId.get());
                ReclamationService service = new ReclamationService();
                service.delete(id);
                showAlert("Réclamation avec ID " + id + " supprimée avec succès.", Alert.AlertType.INFORMATION);
                // Mettez à jour votre affichage (rafraîchissez le TreeView ou autre composant que vous utilisez)
                refreshTreeViewData((TreeItem<String>) treeview.getRoot());
            } catch (NumberFormatException e) {
                showAlert("ID non valide. Veuillez entrer un numéro entier.", Alert.AlertType.ERROR);
            }
        }
    }

    

    private void refreshTreeViewData(TreeItem<String> rootItem) {
        // Ici, vous devrez recharger les données dans le TreeView en utilisant ReclamationService
        ReclamationService service = new ReclamationService();
        rootItem.getChildren().clear(); // Supprimez tous les éléments actuels
        for (Reclamation data : service.getAll()) {
            TreeItem<String> item = new TreeItem<>(data.toString());
            rootItem.getChildren().add(item);
        }
    }

    private void showAlert(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}






















    



