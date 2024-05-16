/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.servicio;


import com.mycompany.gestionpersonaluniversitario.dao.GrupoFamiliarDAO;
import com.mycompany.gestionpersonaluniversitario.dao.GrupoFamiliarDAOImpl;
import com.mycompany.gestionpersonaluniversitario.excepciones.GestionPersonalException;
import com.mycompany.gestionpersonaluniversitario.excepciones.GrupoFamiliarNoEncontradoException;
import com.mycompany.gestionpersonaluniversitario.modelo.GrupoFamiliar;
import java.util.List;
/**
 *
 * @author USUARIO
 */

public class GrupoFamiliarServicio {
    private GrupoFamiliarDAO grupoFamiliarDAO;

    public GrupoFamiliarServicio() {
        this.grupoFamiliarDAO = new GrupoFamiliarDAOImpl() {
            @Override
            public List<GrupoFamiliar> listarGruposFamiliares(int funcionarioId) {
                throw new UnsupportedOperationException("Aún no es compatible.");
            }
        }; 
    }

    public void agregarGrupoFamiliar(GrupoFamiliar grupoFamiliar) throws GestionPersonalException {
        if (grupoFamiliar == null || grupoFamiliar.getNombre() == null) {
            throw new GestionPersonalException("El grupo familiar es nulo o tiene datos incompletos");
        }
        
        try {
            grupoFamiliarDAO.agregarGrupoFamiliar(grupoFamiliar);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al agregar el grupo familiar", ex);
        }
    }

    public GrupoFamiliar[] listarGruposFamiliares() throws GestionPersonalException {
        try {
            List<GrupoFamiliar> gruposFamiliares = grupoFamiliarDAO.listarGruposFamiliares();
            return gruposFamiliares.toArray(new GrupoFamiliar[0]);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al listar los grupos familiares", ex);
        }
    }

    public GrupoFamiliar obtenerGrupoFamiliar(int id) throws GestionPersonalException, GrupoFamiliarNoEncontradoException {
        try {
            GrupoFamiliar grupoFamiliar = grupoFamiliarDAO.obtenerGrupoFamiliar(id);
            if (grupoFamiliar == null) {
                throw new GrupoFamiliarNoEncontradoException(id);
            }
            return grupoFamiliar;
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al obtener el grupo familiar", ex);
        }
    }

    public void actualizarGrupoFamiliar(GrupoFamiliar grupoFamiliar) throws GestionPersonalException {
        if (grupoFamiliar == null || grupoFamiliar.getNombre() == null) {
            throw new GestionPersonalException("El grupo familiar es nulo o tiene datos incompletos");
        }
        
        try {
            grupoFamiliarDAO.actualizarGrupoFamiliar(grupoFamiliar);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al actualizar el grupo familiar", ex);
        }
    }

    public void eliminarGrupoFamiliar(int id) throws GestionPersonalException {
        try {
            grupoFamiliarDAO.eliminarGrupoFamiliar(id);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al eliminar el grupo familiar", ex);
        }
    }
}