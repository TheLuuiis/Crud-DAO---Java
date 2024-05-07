/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.modelo;

/**
 *
 * @author USUARIO
 */
public class GrupoFamiliar {
    private int familiarId;
    private int funcionarioId;
    private String nombre;
    private String apellido;
    private String rol;
    
    // Constructor
    public GrupoFamiliar(int familiarId, int funcionarioId, String nombre, String apellido, String rol) {
        this.familiarId = familiarId;
        this.funcionarioId = funcionarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    // Getters
    public int getId() {
        return familiarId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setId(int id) {
        this.familiarId = id;
    }

    // Setters
    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
