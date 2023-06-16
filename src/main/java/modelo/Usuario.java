/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author cmongez
 */
public class Usuario {
    private String rut;
    private char dv = ' ';
    private String nombres;
    private String apellidos;
    private String correo;
    private String fechaNacimiento;
    private String genero;
    private String fechaContratacion;
    private String telefonoUsuario;
    private int idCargo;


    public Usuario() {
    }

    public Usuario(String rut, char dv, String nombres, String apellidos, String correo, String fechaNacimiento, String genero, String fechaContratacion, int idCargo, String telefonoUsuario) {
        this.rut = rut;
        this.dv = dv;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.fechaContratacion = fechaContratacion;
        this.idCargo = idCargo;
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "rut=" + rut + ", dv=" + dv + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo +  ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", fechaContratacion=" + fechaContratacion + ", idCargo=" + idCargo + ", telefonoUsuario=" + telefonoUsuario + '}';
    }


}
