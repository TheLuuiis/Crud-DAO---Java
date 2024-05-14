/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionpersonaluniversitario;
import com.mycompany.gestionpersonaluniversitario.dao.FuncionarioDAO;
import com.mycompany.gestionpersonaluniversitario.modelo.Funcionario;
import com.mycompany.gestionpersonaluniversitario.dao.FuncionarioDAOImpl;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class GestionPersonalUniversitario {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        FuncionarioDAO funcionario = new FuncionarioDAOImpl();
        List<Funcionario> lista = funcionario.listarFuncionarios();
        System.out.println(lista);
    }
}
