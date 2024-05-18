/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionpersonaluniversitario;
import com.mycompany.gestionpersonaluniversitario.dao.FuncionarioDAO;
import com.mycompany.gestionpersonaluniversitario.modelo.Funcionario;
import com.mycompany.gestionpersonaluniversitario.dao.FuncionarioDAOImpl;
import com.mycompany.gestionpersonaluniversitario.interfaz.GestionPersonal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class GestionPersonalUniversitario {

    public static void main(String[] args) {
        System.out.println("Listando Funcionarios");
        FuncionarioDAO funcionarioDao = new FuncionarioDAOImpl();
        List<Funcionario> lista = funcionarioDao.listarFuncionarios();
        System.out.println(lista);
        
        GestionPersonal princ = new GestionPersonal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        
        
        System.out.println("Creando funcionarios");
        Scanner scan = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        
        String tipoIdentificacion = scan.nextLine();
        funcionario.setTipoIdentificacion(tipoIdentificacion);
        
        int id = Integer.parseInt (scan.nextLine());
        funcionario.setNumeroIdentificacion(id);
        
        String nombres = scan.nextLine();
        funcionario.setNombres(nombres);
        
        String apellidos = scan.nextLine();
        funcionario.setApellidos(apellidos);
        
        String sexo = scan.nextLine();
        funcionario.setSexo(sexo);
        
        String estadoCivil = scan.nextLine();
        funcionario.setEstadoCivil(estadoCivil);
        
        String direccion = scan.nextLine();
        funcionario.setDireccion(direccion);
        
        String telefono = scan.nextLine();
        funcionario.setTelefono(telefono);
        
        System.out.println(funcionario);
        funcionarioDao.agregarFuncionario(funcionario);
        
        
        
    }
}
