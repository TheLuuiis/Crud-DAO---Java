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
                throw new UnsupportedOperationException("Aún no es compatible.");
            }

            @Override
            public void eliminarInformacionAcademica(int funcinarioId) {
                throw new UnsupportedOperationException("Aún no es compatible."); 
            }

            @Override
            public InformacionAcademica obtenerInformacionAcadeica(int funcionarioId) {
                throw new UnsupportedOperationException("Aún no es compatible."); 
            }

            @Override
            public List<InformacionAcademica> listarInformacionAcademica(int funcionarioId) {
                throw new UnsupportedOperationException("Aún no es compatible."); 
            }
        }; 
    }

    public void agregarInformacionAcademica(InformacionAcademica informacionAcademica) throws GestionPersonalException {
        if (informacionAcademica == null || informacionAcademica.getUniversidad() == null) {
            throw new GestionPersonalException("La información académica es nula o tiene datos incompletos");
        }
        
        try {
            informacionAcademicaDAO.agregarInformacionAcademica(informacionAcademica);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al agregar la información académica", ex);
        }
    }

    public InformacionAcademica[] listarInformacionAcademica() throws GestionPersonalException {
        try {
            List<InformacionAcademica> informacionAcademicaList = informacionAcademicaDAO.listarInformacionAcademica();
            return informacionAcademicaList.toArray(new InformacionAcademica[0]);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al listar la información académica", ex);
        }
    }

    public InformacionAcademica obtenerInformacionAcademica(int id) throws GestionPersonalException, InformacionAcademicaNoEncontradaException {
        try {
            InformacionAcademica informacionAcademica = informacionAcademicaDAO.obtenerInformacionAcademica(id);
            if (informacionAcademica == null) {
                throw new InformacionAcademicaNoEncontradaException(id);
            }
            return informacionAcademica;
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al obtener la información académica", ex);
        }
    }

    public void actualizarInformacionAcademica(InformacionAcademica informacionAcademica) throws GestionPersonalException {
        if (informacionAcademica == null || informacionAcademica.getUniversidad() == null) {
            throw new GestionPersonalException("La información académica es nula o tiene datos incompletos");
        }
        
        try {
            informacionAcademicaDAO.actualizarInformacionAcademica(informacionAcademica);
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