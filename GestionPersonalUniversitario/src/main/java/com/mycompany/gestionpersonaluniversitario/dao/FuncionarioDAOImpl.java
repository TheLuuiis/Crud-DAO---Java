/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;
import com.mycompany.gestionpersonaluniversitario.modelo.Funcionario;
import com.mycompany.gestionpersonaluniversitario.excepciones.GestionPersonalException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    // URL de conexión para PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5000/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kevinm24";

    // Sentencias SQL para las operaciones CRUD
    private static final String INSERT_FUNCIONARIO = "INSERT INTO funcionarios (FuncionarioID, TipoIdentificacion, Nombres, Apellidos, EstadoCivil, Sexo, Direccion, Telefono, FechaNacimiento) VALUES\n" +
"(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET FuncionarioID = ?, TipoIdentificacion = ?, Nombres = ?, Apellidos = ?, EstadoCivil = ?, Sexo = ?, Direccion = ?, Telefono = ?, FechaNacimiento = ? WHERE funcionarios.funcionarioid = ?";
    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionarios WHERE funcionarioid = ?";
    private static final String SELECT_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE funcionarioid = ?";
    private static final String SELECT_ALL_FUNCIONARIOS = "SELECT * FROM funcionarios";

    @Override
    public void agregarFuncionario(Funcionario funcionario) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(INSERT_FUNCIONARIO)) {
            // Configuramos los parámetros del PreparedStatement con los valores del funcionario
            stmt.setInt(1, funcionario.getNumeroIdentificacion());
            stmt.setString(2, funcionario.getTipoIdentificacion());
            stmt.setString(3, funcionario.getNombres());
            stmt.setString(4, funcionario.getApellidos());
            stmt.setString(5, funcionario.getEstadoCivil());
            stmt.setString(6, funcionario.getSexo());
            stmt.setString(7, funcionario.getDireccion());
            stmt.setString(8, funcionario.getTelefono());
            stmt.setString(9, funcionario.getFechaNacimiento());

            // Ejecutamos la consulta
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Lanzamos una excepción personalizada con un mensaje de error descriptivo
            throw new GestionPersonalException("Error al agregar el funcionario", e);
        }
    }

    @Override
    public void actualizarFuncionario(Funcionario funcionario, int id) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(UPDATE_FUNCIONARIO)) {
        // Configuramos los parámetros del PreparedStatement con los valores actualizados del funcionario
        stmt.setInt(1, funcionario.getNumeroIdentificacion());
        stmt.setString(2, funcionario.getTipoIdentificacion());
        stmt.setString(3, funcionario.getNombres());
        stmt.setString(4, funcionario.getApellidos());
        stmt.setString(5, funcionario.getEstadoCivil());
        stmt.setString(6, funcionario.getSexo());
        stmt.setString(7, funcionario.getDireccion());
        stmt.setString(8, funcionario.getTelefono());
        stmt.setString(9, funcionario.getFechaNacimiento());
        stmt.setInt(10, id);  // Usamos el id en la cláusula WHERE
        // Ejecutamos la consulta
        stmt.executeUpdate();
    } catch (SQLException e) {
        // lanzamos una excepción personalizada con un mensaje de error descriptivo

            throw new GestionPersonalException("Error al actualizar el funcionario", e);
        }
    }

    @Override
    public void eliminarFuncionario(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(DELETE_FUNCIONARIO)) {
            // Configuramos los parámetros del PreparedStatement con el ID del funcionario a eliminar
            stmt.setInt(1, id);

            // Ejecutamos la consulta
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Lanzamos una excepción personalizada con un mensaje de error descriptivo
            throw new GestionPersonalException("Error al eliminar el funcionario", e);
        }
    }

    @Override
    public Funcionario obtenerFuncionario(int id) {
        Funcionario funcionario = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_FUNCIONARIO_BY_ID)) {
            stmt.setInt(1, id);
            // Ejecutamos la consulta y obtener el resultado
            ResultSet rs = stmt.executeQuery();
            // Procesamos el resultado y Construimos el objeto Funcionario
            if (rs.next()) {
                // Construimos el objeto Funcionario a partir de los datos del ResultSet
                funcionario = new Funcionario();
                funcionario.setTipoIdentificacion(rs.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(rs.getInt("numero_identificacion"));
                funcionario.setNombres(rs.getString("nombres"));
                funcionario.setApellidos(rs.getString("apellidos"));
                funcionario.setEstadoCivil(rs.getString("estado_civil"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            }
        } catch (SQLException e) {
            // Aquí lanzamos una excepción personalizada con un mensaje de error 
            throw new GestionPersonalException("Error al obtener el funcionario", e);
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FUNCIONARIOS)) {
            // Ejecutamos la consulta para obtener los datos
            ResultSet rs = stmt.executeQuery();
            // Procesamos el resultado y construimos la lista de Funcionarios
            while (rs.next()) {
            // Construimos cada objeto Funcionario a partir de los datos del ResultSet y los agregamos a la lista
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(rs.getString("tipoidentificacion"));
            funcionario.setNumeroIdentificacion(rs.getInt("funcionarioid"));
            funcionario.setNombres(rs.getString("nombres"));
            funcionario.setApellidos(rs.getString("apellidos"));
            funcionario.setEstadoCivil(rs.getString("estadocivil"));
            funcionario.setSexo(rs.getString("sexo"));
            funcionario.setDireccion(rs.getString("direccion"));
            funcionario.setTelefono(rs.getString("telefono"));
            funcionario.setFechaNacimiento(rs.getString("fechanacimiento"));
            // Agregar el funcionario a la lista
            funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            // Aqui lanzamos una excepción personalizada con un mensaje de error
            throw new GestionPersonalException("Error al listar los funcionarios", e);
        }
        
        return funcionarios;
    }

   
   
    
}