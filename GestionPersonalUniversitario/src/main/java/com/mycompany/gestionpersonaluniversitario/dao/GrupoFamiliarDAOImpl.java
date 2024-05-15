/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;

import com.mycompany.gestionpersonaluniversitario.excepciones.GestionPersonalException;
import com.mycompany.gestionpersonaluniversitario.modelo.GrupoFamiliar;
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

public abstract class GrupoFamiliarDAOImpl implements GrupoFamiliarDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    
    private static final String INSERT_GRUPO_FAMILIAR = "INSERT INTO grupo_familiar (funcionario_id, nombre, apellido, rol) VALUES (?, ?, ?, ?)";
    private static final String SELECT_GRUPO_FAMILIAR_BY_ID = "SELECT * FROM grupo_familiar WHERE familiar_id = ?";
    private static final String SELECT_ALL_GRUPOS_FAMILIARES = "SELECT * FROM grupo_familiar";
    private static final String UPDATE_GRUPO_FAMILIAR = "UPDATE grupo_familiar SET nombre = ?, apellido = ?, rol = ? WHERE familiar_id = ?";
    private static final String DELETE_GRUPO_FAMILIAR = "DELETE FROM grupo_familiar WHERE familiar_id = ?";

    @Override
    public void agregarGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(INSERT_GRUPO_FAMILIAR)) {
            
            stmt.setInt(1, grupoFamiliar.getFuncionarioId());
            stmt.setString(2, grupoFamiliar.getNombre());
            stmt.setString(3, grupoFamiliar.getApellido());
            stmt.setString(4, grupoFamiliar.getRol());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al agregar el grupo familiar", e);
        }
    }

    @Override
    public GrupoFamiliar obtenerGrupoFamiliar(int id) {
        GrupoFamiliar grupoFamiliar = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_GRUPO_FAMILIAR_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                grupoFamiliar = new GrupoFamiliar(
                        rs.getInt("familiar_id"),
                        rs.getInt("funcionario_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al obtener el grupo familiar", e);
        }
        return grupoFamiliar;
    }

    @Override
    public List<GrupoFamiliar> listarGruposFamiliares() {
        List<GrupoFamiliar> gruposFamiliares = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_GRUPOS_FAMILIARES)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GrupoFamiliar grupoFamiliar = new GrupoFamiliar(
                        rs.getInt("familiar_id"),
                        rs.getInt("funcionario_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("rol")
                );
                gruposFamiliares.add(grupoFamiliar);
            }
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al listar los grupos familiares", e);
        }
        return gruposFamiliares;
    }

    @Override
    public void actualizarGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_GRUPO_FAMILIAR)) {

            stmt.setString(1, grupoFamiliar.getNombre());
            stmt.setString(2, grupoFamiliar.getApellido());
            stmt.setString(3, grupoFamiliar.getRol());
            stmt.setInt(4, grupoFamiliar.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al actualizar el grupo familiar", e);
        }
    }

    @Override
    public void eliminarGrupoFamiliar(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(DELETE_GRUPO_FAMILIAR)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al eliminar el grupo familiar", e);
        }
    }
}