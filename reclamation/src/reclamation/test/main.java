/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.test;
import Reclamation.entities.Reclamation;
import reclamation.services.ReclamationService;
import reclamation.utilities.Myconnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ZARAMI
 */
public class main {
     public static void main(String[] args) {

        Myconnection myconnection = Myconnection.getInstance();

        Reclamation reclamation = new Reclamation();
     Date currentDate = new Date(System.currentTimeMillis());
     reclamation.setId(4);
        reclamation.setNumero_mobile(1111110);
     reclamation.setDate_traitement(currentDate);
        
      
        reclamation.setDescription("ddddd");
          reclamation.setObjet("ddddd");       
        reclamation.setStatus("fffff");
        reclamation.setNom("yyyyy");
        reclamation.setPrenom("Med xx");
        reclamation.setEmail("mxxxi@esprit.tn");
      
    
        ReclamationService rr = new ReclamationService();

        
        System.out.println("reclamation r created successfully.");
            }
}