/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reclamation.entities;
import java.sql.Date;
import java.sql.Time;


/**
 *
 * @author ZARAMI
 */
public class Reclamation {
     int id,numero_mobile;
    Date date_traitement;
    String description,objet,status,nom,prenom,email;

    public Reclamation() {
    }

    public Reclamation(int id, int numero_mobile, Date date_traitement, String description, String objet, String status, String nom, String prenom, String email) {
        this.id = id;
        this.numero_mobile = numero_mobile;
        this.date_traitement = date_traitement;
        this.description = description;
        this.objet = objet;
        this.status = status;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getNumero_mobile() {
        return numero_mobile;
    }

    public Date getDate_traitement() {
        return date_traitement;
    }

    public String getDescription() {
        return description;
    }

    public String getObjet() {
        return objet;
    }

    public String getStatus() {
        return status;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero_mobile(int numero_mobile) {
        this.numero_mobile = numero_mobile;
    }

    public void setDate_traitement(Date date_traitement) {
        this.date_traitement = date_traitement;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", numero_mobile=" + numero_mobile + ", date_traitement=" + date_traitement + ", description=" + description + ", objet=" + objet + ", status=" + status + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }
    
}
