/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.services;


import Reclamation.entities.Reclamation;
import reclamation.utilities.Myconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class ReclamationService implements CrudInterface<Reclamation> {

    private Connection cnx;
    private Statement st;
    private ResultSet rs;

    public ReclamationService() {
        cnx = Myconnection.getInstance().getCnx();
    }

    @Override
    public void create(Reclamation entity) {
        PreparedStatement pst;
        int n = 0;
        int generatedId = -1;

        try {

            pst = cnx.prepareStatement("INSERT INTO Admin (id, numero_mobile,  date_traitement , description,  objet,  status,  nom,  prenom,  email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, entity.getId());
            pst.setInt(2, entity.getNumero_mobile());
             pst.setDate(5, entity.getDate_traitement());
             
            pst.setString(3, entity.getDescription());
            pst.setString(4, entity.getObjet());
             pst.setString(3, entity.getStatus());
          
            pst.setString(6, entity.getNom());
            pst.setString(7, entity.getPrenom());
             pst.setString(8, entity.getEmail());

            n = pst.executeUpdate();
            if (n > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Get the generated ID
                }
            }
            pst.close();
            entity.setId(generatedId);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return cnx.prepareStatement(sql);
    }

    @Override
    public void update(Reclamation entity) {
        PreparedStatement pst;
        int n = 0;

        try {
           pst = cnx.prepareStatement("INSERT INTO Admin (id, numero_mobile,  date_traitement , description,  objet,  status,  nom,  prenom,  email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, entity.getId());
            pst.setInt(2, entity.getNumero_mobile());
             pst.setDate(5, entity.getDate_traitement());
             
            pst.setString(3, entity.getDescription());
            pst.setString(4, entity.getObjet());
             pst.setString(3, entity.getStatus());
          
            pst.setString(6, entity.getNom());
            pst.setString(7, entity.getPrenom());
             pst.setString(8, entity.getEmail());


            n = pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

        int n = 0;
        PreparedStatement st;
        try {

            st = cnx.prepareStatement("DELETE FROM `reclamation` WHERE `id`=?");

            st.setInt(1, id);

            n = st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Reclamation getById(int id) {

        PreparedStatement st;
       Reclamation  reclamation;
        reclamation = new Reclamation();
        try {

            st = cnx.prepareStatement("SELECT * FROM `reclamation` WHERE `id`=?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {

                reclamation.setId(rs.getInt("id"));
                reclamation.setNumero_mobile(rs.getInt("numero_mobile"));
                reclamation.setDate_traitement(rs.getDate("Date date_traitement"));
                reclamation.setDescription(rs.getString("description"));
                reclamation.setObjet(rs.getString("objet"));
               reclamation.setStatus(rs.getString("status"));
                reclamation.setNom(rs.getString("nom"));
                reclamation.setPrenom(rs.getString("prenom"));
                reclamation.setEmail(rs.getString("email"));
               

            }
            cnx.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return reclamation;
    }

    @Override
    public List<Reclamation> getAll() {
        List<Reclamation> reclamationList = new ArrayList<>();
        PreparedStatement st;

        try {
            st = cnx.prepareStatement("SELECT * FROM Reclamation");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
               Reclamation reclamation = new Reclamation();
               reclamation.setId(rs.getInt("id"));
                reclamation.setNumero_mobile(rs.getInt("numero_mobile"));
                reclamation.setDate_traitement(rs.getDate("Date date_traitement"));
                reclamation.setDescription(rs.getString("description"));
                reclamation.setObjet(rs.getString("objet"));
               reclamation.setStatus(rs.getString("status"));
                reclamation.setNom(rs.getString("nom"));
                reclamation.setPrenom(rs.getString("prenom"));
                reclamation.setEmail(rs.getString("email"));
               

               reclamationList.add(reclamation);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return reclamationList;
    }
}