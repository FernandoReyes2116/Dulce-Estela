/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yossargueta.hellopmp202103.dulcestela;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ChristianMidence
 */
public class EstelaItem {
  
     /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @return the _cedula
     */
    public String getCedula() {
        return _cedula;
    }

    /**
     * @param _cedula the _cedula to set
     */
    public void setCedula(String _cedula) {
        this._cedula = _cedula;
    }

    /**
     * @return the _precio
     */
    public String getPrecio() {
        return _precio;
    }

    /**
     * @param _precio the _precio to set
     */
    public void setPrecio(String _precio) {
        this._precio = _precio;
    }

    /**
     * @return the _fechaentrada
     */
    public Date getFechaentrada() {
        return _fechaentrada;
    }

    /**
     * @param _fechaentrada the _fechaentrada to set
     */
    public void setFechaentrada(Date _fechaentrada) {
        this._fechaentrada = _fechaentrada;
    }

    /**
     * @return the _duracion
     */
    public String getDuracion() {
        return _duracion;
    }

    /**
     * @param _duracion the _duracion to set
     */
    public void setDuracion(String _duracion) {
        this._duracion = _duracion;
    }
    /**
     * @return the _id
     */
  
    private int _id;
    private String _cedula;
    private String _nombre;
    private String  _precio;
    private Date _fechaentrada;
    private String _duracion;
    
    public EstelaItem(){
        this._id = 0;
        this._cedula = "";
        this._nombre = "";
        this._precio = "";
        this._duracion = "";
        this._fechaentrada =  new Date();
    }
    
    public EstelaItem(int id, String nombre, String precio,String cedula, String duracion, Date fechaentrada) {
        this._id = id;
        this._cedula = "";
        this._nombre = nombre;
        this._precio = "";
        this._duracion = "";
        this._fechaentrada =  new Date();
    }

    public ArrayList<String> obtenerCampos(){
        ArrayList<String> campos = new ArrayList<String>();
        campos.add(String.valueOf(this.getId()));
        campos.add(this.getCedula());
        campos.add(this.getNombre());
        campos.add(this.getPrecio());
        campos.add(this.getDuracion());
        campos.add("________");

        return campos;

    }
}
