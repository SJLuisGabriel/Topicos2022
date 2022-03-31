package com.example.topicos2022_proyecto.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesDAO {
    private int cvecte;
    private String nomcte;
    private String telcte;
    private String dircte;

    public int getCvecte() {return cvecte;}

    public void setCvecte(int cvecte) {this.cvecte = cvecte;}

    public String getNomcte() {return nomcte;}

    public void setNomcte(String nomcte) {this.nomcte = nomcte;}

    public String getTelcte() {return telcte;}

    public void setTelcte(String telcte) {this.telcte = telcte;}

    public String getDircte() {return dircte;}

    public void setDircte(String dircte) {this.dircte = dircte;}

    public void INSERTAR(){
        try {
            String query = "INSERT INTO tblcliente (nomcte, telcte, dircte) "
                    + " values ('"+nomcte+"',"+telcte+","+dircte+")";
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();//DEBUG MODE
        }
    }

    public void ACTUALIZAR(){
        try {
            String query = "UPDATE tblcliente set nomcte = '"+nomcte+"', telcte = '"+telcte+"', " +
                    "dircte = '"+dircte+"' WHERE cvecte =" + cvecte;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();//DEBUG MODE
        }
    }

    public void ELIMINAR(){
        try {
            String query = "DELETE FROM tblcliente WHERE cvecte = " + cvecte;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //recupera todos los registros de la tabla
    public ObservableList<ClientesDAO> SELECCIONAR(){

        ObservableList<ClientesDAO> listaC = FXCollections.observableArrayList();

        try {
            ClientesDAO objC;
            String query = "SELECT * FROM tblCliente ORDER BY nomcte";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()) {
                objC = new ClientesDAO();
                objC.setCvecte(res.getInt("cveCte"));
                objC.setNomcte(res.getString("nomCte"));
                objC.setTelcte(res.getString("telCte"));
                objC.setDircte(res.getString("dirCte"));
                listaC.add(objC);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaC;
    }

    //Recupera los registros por un ID
    public ClientesDAO SELECCIONARBYID(){
        ClientesDAO objP = null;
        try {
            String query = "SELECT * FROM tblCliente where cvecte = " + cvecte;
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                objP = new ClientesDAO();
                objP.setCvecte(res.getInt("cveCte"));
                objP.setNomcte(res.getString("nomCte"));
                objP.setTelcte(res.getString("telCte"));
                objP.setDircte(res.getString("dirCte"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return objP;
    }

}
