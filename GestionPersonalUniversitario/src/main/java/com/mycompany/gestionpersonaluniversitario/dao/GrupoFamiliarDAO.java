/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversitario.dao;

import com.mycompany.gestionpersonaluniversitario.modelo.GrupoFamiliar;
import java.util.List;
/**
 *<>
 * @author USUARIO
 */
public interface GrupoFamiliarDAO {
    void agregarGrupoFamiliar(GrupoFamiliar grupoFamiliar);
    void actualizarGrupoFamiliar(GrupoFamiliar grupoFamiliar);
    void eliminarGrupoFamiliar(int familiarId);
    GrupoFamiliar obtenerGrupoFamiliar(int familiarId);
    List<GrupoFamiliar>listarGruposFamiliares();

    public List<GrupoFamiliar> listarGruposFamiliares(int funcionarioId);
}
