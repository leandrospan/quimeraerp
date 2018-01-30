/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quimera.erp;

import DAO.UsuarioDAO;
import bean.Usuario;

/**
 *
 * @author Leandro
 */
public class TestaUsuarioCRUD {
    public static void main(String[] args){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        /* ROTINA DE INSERIR DADOS
        //Cria um usuario e salva no banco
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Leandro");
        usuario.setSenhaUsuario("123mudar");
        usuario.setTipoUsuario("admin");
        usuarioDAO.criar(usuario);
        */
        
        /* ROTINA DE UPDATE 
        //Atualiza um usuario om codigo = 1 com os dados do objeto
        Usuario usuario1 = new Usuario();
        usuario1.setCodigoUsuario(1);
        usuario1.setNomeUsuario("Leandro Spanghero");
        usuario1.setSenhaUsuario("123mudar");
        usuario1.setTipoUsuario("admin");
        usuarioDAO.atualizar(usuario1);
        */
        
        /*ROTINA DE DELETAR
        //Remove o usuario com codigo = 3
        usuarioDAO.removePeloCodigo(3);
        */
        
        /* ROTINA PARA LISTAR USUARIOS
        //Listar todos os contatos do banco de dados
        for(Usuario u : usuarioDAO.getUsuario()){
            System.out.println("Nome: " + u.getNomeUsuario());
        }
        */
    }    
}
