/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;
import com.mycompany.gestionpersonaluniversitario.modelo.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {
    // hacemos la conexión con PostgreSQL
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    
    // Aquí hacmeos las sentencias SQL para las operaciones CRUD
    private static final String INSERT_FUNCIONARIO = "";
    private static final String UPDATE_FUNCIONARIO = "";
    private static final String DELETE_FUNCIONARIO = "";
    private static final String SELECT_FUNCIONARIO_BY_ID = "";
    private static final String SELECT_ALL_FUNCIONARIOS = "";
}

@Override
