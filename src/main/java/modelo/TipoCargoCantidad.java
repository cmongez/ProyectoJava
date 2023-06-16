/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cmongez
 */

public class TipoCargoCantidad {
    private String nombreTipoCargo;
    private int cantidadCargos;

    public TipoCargoCantidad(String nombreTipoCargo, int cantidadCargos) {
        this.nombreTipoCargo = nombreTipoCargo;
        this.cantidadCargos = cantidadCargos;
    }

    public String getNombreTipoCargo() {
        return nombreTipoCargo;
    }

    public void setNombreTipoCargo(String nombreTipoCargo) {
        this.nombreTipoCargo = nombreTipoCargo;
    }

    public int getCantidadCargos() {
        return cantidadCargos;
    }

    public void setCantidadCargos(int cantidadCargos) {
        this.cantidadCargos = cantidadCargos;
    }
}
