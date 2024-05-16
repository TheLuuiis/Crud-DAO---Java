/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.servicio;

import com.mycompany.gestionpersonaluniversitario.dao.InformacionAcademicaDAO;
import com.mycompany.gestionpersonaluniversitario.dao.InformacionAcademicaDAOImpl;
import com.mycompany.gestionpersonaluniversitario.excepciones.GestionPersonalException;
import com.mycompany.gestionpersonaluniversitario.excepciones.InformacionAcademicaNoEncontradaException;
import com.mycompany.gestionpersonaluniversitario.modelo.InformacionAcademica;
import java.util.List;

/**
 *
 * @author USUARIO
 */

public class InformacionAcademicaServicio {
    private InformacionAcademicaDAO informacionAcademicaDAO;

    public InformacionAcademicaServicio() {
        this.informacionAcademicaDAO = new InformacionAcademicaDAOImpl() {
            @Override
            public void acttualizarInformacionAcademica(InformacionAcademica informacionAcademica) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }

            @Override
            public void eliminarInformacionAcademica(int funcinarioId) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }

            @Override
            public InformacionAcademica obtenerInformacionAcadeica(int funcionarioId) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
            @Override
            public List<InformacionAcademica> listarInformacionAcademica(int funcionarioId) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }; 
    }

    public void agregarInformacionAcademica(InformacionAcademica infoAcademica) throws GestionPersonalException {
        try {
            informacionAcademicaDAO.agregarInformacionAcademica(infoAcademica);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al agregar la información académica", ex);
        }
    }

    public List<InformacionAcademica> listarInformacionAcademica(int funcionarioId) throws GestionPersonalException {
        try {
            return informacionAcademicaDAO.listarInformacionAcademica(funcionarioId);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al listar la información académica", ex);
        }
    }

    public InformacionAcademica obtenerInformacionAcademica(int id) throws GestionPersonalException, InformacionAcademicaNoEncontradaException {
        try {
            InformacionAcademica infoAcademica = informacionAcademicaDAO.obtenerInformacionAcademica(id);
            if (infoAcademica == null) {
                throw new InformacionAcademicaNoEncontradaException(id);
            }
            return infoAcademica;
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al obtener la información académica", ex);
        }
    }

    public void actualizarInformacionAcademica(InformacionAcademica infoAcademica) throws GestionPersonalException {
        try {
            informacionAcademicaDAO.actualizarInformacionAcademica(infoAcademica);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al actualizar la información académica", ex);
        }
    }

    public void eliminarInformacionAcademica(int id) throws GestionPersonalException {
        try {
            informacionAcademicaDAO.eliminarInformacionAcademica(id);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al eliminar la información académica", ex);
        }
    }
}