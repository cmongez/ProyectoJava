/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cmongez
 */
public class Cargo {
    private int idCargo;    
    private int idTipoCargo;
    private String nombreCargo;
    private String nombreTipoCargo;




    public Cargo(int idCargo,  int idTipoCargo, String nombreCargo, String nombreTipoCargo ) {
        this.idCargo = idCargo;
        this.idTipoCargo = idTipoCargo;
        this.nombreCargo = nombreCargo;
        this.nombreTipoCargo = nombreTipoCargo;

    }

    public Cargo() {
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(int idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getNombreTipoCargo() {
        return nombreTipoCargo;
    }

    public void setNombreTipoCargo(String nombreTipoCargo) {
        this.nombreTipoCargo = nombreTipoCargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", idTipoCargo=" + idTipoCargo + ", nombreCargo=" + nombreCargo + ", nombreTipoCargo=" + nombreTipoCargo + '}';
    }

   
    

}
