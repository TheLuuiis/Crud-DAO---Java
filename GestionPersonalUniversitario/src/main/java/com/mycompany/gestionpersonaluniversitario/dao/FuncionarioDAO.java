/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;

import com.mycompany.gestionpersonaluniversitario.modelo.Funcionario;
import java.util.List;
/**
 *<>
 * @author USUARIO
 */
public interface FuncionarioDAO {
    void agregarFuncionario(Funcionario funcionario);
    void actualizarFuncionario(Funcionario funcionario);
    void eliminarFuncionario(int numeroIdentificacion);
    Funcionario obtenerFuncionario(int numeroIdentificacion);
    List<Funcionario> listarFuncionarios();
}