/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPersonalException;

/**
 *
 * @author USUARIO
 */
public class GestionPersonalException extends RuntimeException {
    public GestionPersonalException(String mensaje) {
        super(mensaje);
    }
    /**
    * public GestionPersonalException(String mensaje, ExcepcionCausante causa) {
    *    super(mensaje, causa);
    * }; 
    */
}
