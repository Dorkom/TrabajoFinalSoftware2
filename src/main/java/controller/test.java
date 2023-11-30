/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CursoDAO;
import dao.DAOFactory;
import dao.PublicacionDAO;
import dao.TipoUsuarioDAO;
import dao.TutoriaDAO;
import dao.UsuarioDAO;
import dao.mysql.UsuarioDAOImplMysql;
import java.util.List;
import model.Publicacion;
import model.TipoUsuario;
import model.Tutoria;
import model.Usuario;

/**
 *
 * @author orope
 */
public class test {
    
    public static void main(String args[]){
//        System.out.println("hola");
        List<Usuario> lista = null;
        

        DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        UsuarioDAO usuairoDAO=factory.createUsuarioDAO();
//        String nombre=cursoDAO.NombreCurso(1);
//        System.out.println("holaaaaaaaaaa" + nombre);
        Usuario u=usuairoDAO.findById(1);
        System.out.println(u.getNombres());
        
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).getNombres());
//        }
        
//        Usuario u=usuarioDao.autentificar("juan@example.com", "123456");
//        System.out.println("hola");
//        System.out.println(u);
//        if (u!=null) {
//            System.out.println(u.getNombres());
//        }
//        lista = usuarioDao.findAll();
//        
//        Usuario u= new Usuario("brayan", "oropeza", "email", "2324", 1);
//        UsuarioDAO usudao=new UsuarioDAOImplMysql();
//        usudao.save(u);
//        usuarioDao.obtenerNombreRolesUsuario(6);
    }
    

}
