/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.excepciones;

/**
 *
 * @author USUARIO
 */
public class FuncionarioNoEncontradoException  extends GestionPersonalException {
    public FuncionarioNoEncontradoException (int id) {
        super("No se encontró información académica con ID: " + id);
    }
}
