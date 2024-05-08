/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;
import com.mycompany.gestionpersonaluniversitario.excepciones.GestionPersonalException;
import com.mycompany.gestionpersonaluniversitario.modelo.InformacionAcademica;
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
public abstract class InformacionAcademicaDAOImpl implements InformacionAcademicaDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/nombre_base_de_datos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";
    
    private static final String INSERT_INFORMACION_ACADEMICA = "INSERT INTO informacion_academica (funcionario_id, universidad, nivel_estudio, titulo) VALUES (?, ?, ?, ?)";
    private static final String SELECT_INFORMACION_ACADEMICA_BY_ID = "SELECT * FROM informacion_academica WHERE funcionario_id = ?";
    private static final String SELECT_ALL_INFORMACION_ACADEMICA = "SELECT * FROM informacion_academica";
    private static final String UPDATE_INFORMACION_ACADEMICA = "UPDATE informacion_academica SET universidad = ?, nivel_estudio = ?, titulo = ? WHERE funcionario_id = ?";

    @Override
    public void agregarInformacionAcademica(InformacionAcademica infoAcademica) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(INSERT_INFORMACION_ACADEMICA)) {
            stmt.setInt(1, infoAcademica.getFuncionarioId());
            stmt.setString(2, infoAcademica.getUniversidad());
            stmt.setString(3, infoAcademica.getNivelEstudio());
            stmt.setString(4, infoAcademica.getTitulo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al agregar la información académica", e);
        }
    }

    public InformacionAcademica obtenerInformacionAcademica(int funcionarioId) {
        InformacionAcademica infoAcademica = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_INFORMACION_ACADEMICA_BY_ID)) {
            stmt.setInt(1, funcionarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                infoAcademica = new InformacionAcademica(
                        rs.getInt("funcionario_id"),
                        rs.getString("universidad"),
                        rs.getString("nivel_estudio"),
                        rs.getString("titulo")
                );
            }
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al obtener la información académica", e);
        }
        return infoAcademica;
    }

    @Override
    public List<InformacionAcademica> listarInformacionAcademica() {
        List<InformacionAcademica> listaInformacionAcademica = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_INFORMACION_ACADEMICA)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                InformacionAcademica infoAcademica = new InformacionAcademica(
                        rs.getInt("funcionario_id"),
                        rs.getString("universidad"),
                        rs.getString("nivel_estudio"),
                        rs.getString("titulo")
                );
                listaInformacionAcademica.add(infoAcademica);
            }
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al listar la información académica", e);
        }
        return listaInformacionAcademica;
    }

    public void actualizarInformacionAcademica(InformacionAcademica infoAcademica) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_INFORMACION_ACADEMICA)) {
            stmt.setString(1, infoAcademica.getUniversidad());
            stmt.setString(2, infoAcademica.getNivelEstudio());
            stmt.setString(3, infoAcademica.getTitulo());
            stmt.setInt(4, infoAcademica.getFuncionarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GestionPersonalException("Error al actualizar la información académica", e);
        }
    }
}
