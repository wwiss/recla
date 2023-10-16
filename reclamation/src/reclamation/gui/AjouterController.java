/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.gui;

import entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author ZARAMI
 */
public class AjouterController implements Initializable {
 
     
    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField mobileTextField;

    @FXML
    private SplitMenuButton objetSplitMenuButton;

    @FXML
    private TextArea descriptionTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void envoyerButton(ActionEvent event) { // Assurez-vous que la méthode prend en charge ActionEvent
       
        ReclamationService rr = new ReclamationService();
        String mobilestring = mobileTextField.getText();
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String email = emailTextField.getText();
        String objet = objetSplitMenuButton.getText();
        String description = descriptionTextArea.getText();

        if (!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !description.isEmpty() && !mobilestring.isEmpty()) {
            // Vérifiez que l'e-mail a un format d'e-mail valide
            if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                // Assurez-vous que "mobileString" contient uniquement des entiers et a une longueur de 8 chiffres
                if (mobilestring.matches("\\d{8}")) {
                    // La chaîne contient uniquement des entiers et a une longueur de 8 chiffres
                    int mobile = Integer.parseInt(mobilestring);
                    rr.create(new Reclamation(mobile, description, objet, nom, prenom, email));
                } else {
                    System.err.println("Le numéro de téléphone doit contenir exactement 8 chiffres.");
                }
            } else {
                System.err.println("L'e-mail n'est pas valide.");
            }
        } else {
            System.err.println("Veuillez remplir tous les champs.");
        }
    }
}