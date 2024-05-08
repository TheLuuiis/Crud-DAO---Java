/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.excepciones;

/**
 *
 * @author USUARIO
 */
public class GrupoFamiliarNoEncontradoException extends GestionPersonalException {
    public GrupoFamiliarNoEncontradoException(int id) {
        super("No se encontró un grupo familiar con ID: " + id);
    }
}
