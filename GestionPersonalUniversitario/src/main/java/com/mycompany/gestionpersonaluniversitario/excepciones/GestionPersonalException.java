/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.excepciones;

/**
 *
 * @author USUARIO
 */

public class GestionPersonalException extends RuntimeException {
    public GestionPersonalException(String message) {
        super(message);
    }

    public GestionPersonalException(String message, Throwable cause) {
        super(message, cause);
    }
}
