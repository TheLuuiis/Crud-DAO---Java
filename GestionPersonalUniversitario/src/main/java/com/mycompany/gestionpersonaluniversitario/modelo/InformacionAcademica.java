/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.modelo;

/**
 *
 * @author USUARIO
 */
public class InformacionAcademica {
    private int funcinarioId;
    private String universidad;
    private String nivelEstudio;
    private String titulo;
    
    // Constructor

    public InformacionAcademica(int funcinarioId, String universidad, String nivelEstudio, String titulo) {
        this.funcinarioId = funcinarioId;
        this.universidad = universidad;
        this.nivelEstudio = nivelEstudio;
        this.titulo = titulo;
    }
    
    // Getters
    public int getFuncinarioId() {
        return funcinarioId;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public String getTitulo() {
        return titulo;
    }
    
    // Setters
    public void setFuncinarioId(int funcinarioId) {
        this.funcinarioId = funcinarioId;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
}
