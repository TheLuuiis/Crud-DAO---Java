/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;

import com.mycompany.gestionpersonaluniversitario.modelo.InformacionAcademica;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface InformacionAcademicaDAO {
    void agregarInformacionAcademica(InformacionAcademica informacionAcademica);
    void acttualizarInformacionAcademica(InformacionAcademica informacionAcademica);
    void eliminarInformacionAcademica(int funcinarioId);
    InformacionAcademica obtenerInformacionAcadeica(int funcionarioId);
    List<InformacionAcademica> listarInformacionAcademica();

    public List<InformacionAcademica> listarInformacionAcademica(int funcionarioId);

    public InformacionAcademica obtenerInformacionAcademica(int id);

    public void actualizarInformacionAcademica(InformacionAcademica infoAcademica);
} 