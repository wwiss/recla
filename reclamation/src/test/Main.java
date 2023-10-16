/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Reclamation;
import service.ReclamationService;
import utilities.Myconnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ZARAMI
 */


public class Main {
    public static void main(String[] args) {
        try {
            // Create a connection to the database
            Myconnection myconnection = Myconnection.getInstance();

            // Get the current date
            Date currentDate = new Date(System.currentTimeMillis());

            // Create a new Reclamation instance
            Reclamation reclamation = new Reclamation();

            // Set the Reclamation object's properties
            // Note: You may want to remove the manual setting of the ID to allow the database to generate it.
          reclamation.setNumero_mobile(2222222);
            
            reclamation.setDescription("ddddd");
            reclamation.setObjet("ddddd");
          
            reclamation.setNom("yyyyy");
            reclamation.setPrenom("Med xx");
            reclamation.setEmail("mxxxi@esprit.tn");

            // Create a ReclamationService instance and use it to insert the record
            ReclamationService rr = new ReclamationService();
            rr.create(reclamation);
        
        
           // rr.delete(2);
           // System.out.println(rr.getById(3).toString());
       
      // List<Reclamation> reclamationList = new ArrayList<Reclamation>();
        // reclamationList =rr.getAll();

        //for (Reclamation rec : reclamationList) {
            //System.out.println(rec);
      //  }
            // Print the Reclamation object
           // System.out.println(reclamation);

            // Close the database connection when done
       
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that occur during database operations
        }
    }
}
    

