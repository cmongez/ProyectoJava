/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cmongez
 */
public class TipoCargo {
    private int idTipoCargo;
    private String nombreTipoCargo;
    private String descripcionTipoCargo;

    public TipoCargo() {
    }
    

    public TipoCargo(int idTipoCargo, String nombreTipoCargo, String descripcionTipoCargo) {
        this.idTipoCargo = idTipoCargo;
        this.nombreTipoCargo = nombreTipoCargo;
        this.descripcionTipoCargo = descripcionTipoCargo;
    }

    public TipoCargo(String nombreTipoCargo, String descripcionTipoCargo) {
        this.nombreTipoCargo = nombreTipoCargo;
        this.descripcionTipoCargo = descripcionTipoCargo;
    }
    

    public int getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(int idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public String getNombreTipoCargo() {
        return nombreTipoCargo;
    }

    public void setNombreTipoCargo(String nombreTipoCargo) {
        this.nombreTipoCargo = nombreTipoCargo;
    }

    public String getDescripcionTipoCargo() {
        return descripcionTipoCargo;
    }

    public void setDescripcionTipoCargo(String descripcionTipoCargo) {
        this.descripcionTipoCargo = descripcionTipoCargo;
    }

    @Override
    public String toString() {
        return "TipoCargo{" + "idTipoCargo=" + idTipoCargo + ", nombreTipoCargo=" + nombreTipoCargo + ", descripcionTipoCargo=" + descripcionTipoCargo + '}';
    }
    
}
