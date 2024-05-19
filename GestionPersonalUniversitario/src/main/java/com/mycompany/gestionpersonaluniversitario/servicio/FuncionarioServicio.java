/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.servicio;

import com.mycompany.gestionpersonaluniversitario.dao.FuncionarioDAO;
import com.mycompany.gestionpersonaluniversitario.dao.FuncionarioDAOImpl;
import com.mycompany.gestionpersonaluniversitario.modelo.Funcionario;
import com.mycompany.gestionpersonaluniversitario.excepciones.GestionPersonalException;
import com.mycompany.gestionpersonaluniversitario.excepciones.FuncionarioNoEncontradoException;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class FuncionarioServicio {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioServicio() {
        this.funcionarioDAO = new FuncionarioDAOImpl(); 
    }

    public void agregarFuncionario(Funcionario funcionario) throws GestionPersonalException {
        try {
            funcionarioDAO.agregarFuncionario(funcionario);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al agregar el funcionario", ex);
        }
    }

    public Funcionario[] listarFuncionarios() throws GestionPersonalException {
        try {
            List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
            return funcionarios.toArray(new Funcionario[0]);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al listar los funcionarios", ex);
        }
    }

    public Funcionario obtenerFuncionario(int id) throws GestionPersonalException, FuncionarioNoEncontradoException {
        try {
            Funcionario funcionario = funcionarioDAO.obtenerFuncionario(id);
            if (funcionario == null) {
                throw new FuncionarioNoEncontradoException(id);
            }
            return funcionario;
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al obtener el funcionario", ex);
        }
    }

    public void actualizarFuncionario(Funcionario funcionario, int id) throws GestionPersonalException {

        try {
            
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al actualizar el funcionario", ex);
        }
    }

    public void eliminarFuncionario(int id) throws GestionPersonalException {
        try {
            funcionarioDAO.eliminarFuncionario(id);
        } catch (GestionPersonalException ex) {
            throw new GestionPersonalException("Error al eliminar el funcionario", ex);
        }
    }
}