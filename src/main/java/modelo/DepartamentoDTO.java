/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cmongez
 */
public class DepartamentoDTO {
    private int idDepartamento;
    private String nombreDepartamento;
    private String descripcionDepartamento;
    private String telefonoDepartamento;

    public DepartamentoDTO(int idDepartamento, String nombreDepartamento, String descripcionDepartamento, String telefonoDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.descripcionDepartamento = descripcionDepartamento;
        this.telefonoDepartamento = telefonoDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    public void setDescripcionDepartamento(String descripcionDepartamento) {
        this.descripcionDepartamento = descripcionDepartamento;
    }

    public String getTelefonoDepartamento() {
        return telefonoDepartamento;
    }

    public void setTelefonoDepartamento(String telefonoDepartamento) {
        this.telefonoDepartamento = telefonoDepartamento;
    }

    
}
