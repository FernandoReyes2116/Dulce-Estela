/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yossargueta.hellopmp202103.conexion;
import com.yossargueta.hellopmp202103.dulcestela.EstelaItem;
import java.util.ArrayList;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chritian Midence
 */
public class DulcestelaDB {
      private ArrayList _cursoItems;
    
    public DulcestelaDB(){
            this._cursoItems = new ArrayList<EstelaItem>();
    }
    
    public ArrayList<EstelaItem> getCursoItems(){
        return this.getCursoItems(false);
    }
    
    public void tableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS COSINA"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " NUMERO DE CEDULA TEXT NOT NULL,"
                        + " NOMBRE DEL CURSO TEXT NOT NULL,"
                        + " PRECIO TEXT NOT NULL,"
                        + " DURACION TEXT NOT NULL"
                        + ")";
       
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
        } catch( Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<EstelaItem> getCursoItems(boolean forceLoad){
        try {
           if (forceLoad) {
                Statement comando =  Conexion.getConexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from COCINA;");
                this._cursoItems.clear();
                while (misRegistro.next()) {
                    EstelaItem registro = new EstelaItem();
                    registro.setId(misRegistro.getInt("ID"));
                    registro.setPrecio(misRegistro.getString("CEDULA"));
                    registro.setNombre(misRegistro.getString("NOMBRE DEL CURSO"));
                    registro.setPrecio(misRegistro.getString("PRECIO"));
                    registro.setDuracion(misRegistro.getString("DURACION"));
                    this._cursoItems.add(registro);
                }
                comando.close();
           }
           return this._cursoItems;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return this._cursoItems;
        }   
    }
    
    public EstelaItem getCursoItemById(int id){
        try {
            String SQLGetByID = "SELECT * FROM CURSO WHERE ID = ?;";
            PreparedStatement comando =  Conexion.getConexion().prepareStatement(SQLGetByID);
            comando.setInt(1, id);
            ResultSet misRegistro = comando.executeQuery();
            EstelaItem registro = new EstelaItem();
            while (misRegistro.next()) {
                registro.setId(misRegistro.getInt("ID"));
                registro.setPrecio(misRegistro.getString("CEDULA"));
                registro.setNombre(misRegistro.getString("NOMBRE DEL CURSO"));
                registro.setPrecio(misRegistro.getString("PRECIO"));
                registro.setDuracion(misRegistro.getString("DURACION"));
                break;
            }
            comando.close();

            return registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    }
    
    public int updateCursoItem(EstelaItem ItemToUpdate) {
        try {
            String SQLUpdate = "UPDATE CURSO set NOMBRE DEL CURSO=?,CEDULA=?, PRECIO=?, DURACION=? where ID=?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLUpdate);
            
            comando.setString(1, ItemToUpdate.getNombre());
            comando.setString(2, ItemToUpdate.getCedula());
            comando.setString(3, ItemToUpdate.getPrecio());
            comando.setString(4, ItemToUpdate.getDuracion());
            comando.setInt(5, ItemToUpdate.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     public int insertCursoItem(EstelaItem ItemToInsert) {
        try {
            String SQLInsert = "INSERT INTO CURSO (NOMBRE,CEDULA, PRECIO, DURACION) values (?, ?, ?);";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLInsert);
            
            comando.setString(1, ItemToInsert.getNombre());
            comando.setString(2, ItemToInsert.getCedula());
            comando.setString(3, ItemToInsert.getPrecio());
            comando.setString(4, ItemToInsert.getDuracion());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     
    public int deleteCursoItem(EstelaItem ItemToDelete) {
        try {
            String SQLDelete = "DELETE FROM CURSO WHERE ID = ?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLDelete);
            
            comando.setInt(1, ItemToDelete.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
