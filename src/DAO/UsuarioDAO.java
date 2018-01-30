/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import quimera.erp.Conexao;

/**
 *
 * @author Leandro
 */
public class UsuarioDAO {
    public void criar(Usuario u){
        /* Isso é uma sql comum, os ? são paramentros que nós vamos adicionar
        na base de dados */
        String sql = "INSERT INTO usuario(NomeUsua, SenhaUsua, TipoUsua) VALUES (?, ?,? )";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            //Cria uma conexão com o banco
            conn = Conexao.abrir();
            //Cria um PreparedStatement, classe usas para executar a query
            ps = conn.prepareStatement(sql);
            //Adiciona o valor do primeiro paramentro da sql
            ps.setString(1, u.getNomeUsuario());
            //Adiciona o valor do segundo paramentro da sql
            ps.setString(2, u.getSenhaUsuario());
            //Adiciona o valor do terceiro paramentro da sql
            ps.setString(3, u.getTipoUsuario());
            //Executa a sql para inserção de dados
            ps.execute();
            JOptionPane.showMessageDialog(null, "Inserido Com Sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            Conexao.fechar(conn, ps);
        }
    }
    
    public void removePeloCodigo(int codigo){
        String sql = "DELETE FROM usuario WHERE codUsuario = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = Conexao.abrir();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexao.fechar(conn, ps);
        }
    }
    
    public void atualizar(Usuario u){
        String sql = "UPDATE usuario SET NomeUsua = ?, SenhaUsua = ?, TipoUsua = ? WHERE codUsuario = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = Conexao.abrir();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getNomeUsuario());
            ps.setString(2, u.getSenhaUsuario());
            ps.setString(3, u.getTipoUsuario());
            ps.setInt(4, u.getCodigoUsuario());
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexao.fechar(conn, ps);
        }
    }
    
    public List<Usuario> getUsuario(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection conn= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = Conexao.abrir();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while(rs.next()){
                Usuario usuario = new Usuario();
                //Reupera o codigo do banco e atribui ele ao objeto
                usuario.setCodigoUsuario(rs.getInt("codUsuario"));
                //Recupera o nome do banco e atribui ele ao objeto
                usuario.setNomeUsuario(rs.getString("nomeUsua"));
                //Recupera a senha do banco e atribui ele ao objeto
                usuario.setSenhaUsuario(rs.getString("senhaUsua"));
                //Recupera o tipo do banco e atribui ele ao objeto
                usuario.setTipoUsuario(rs.getString("tipoUsua"));
                //Adiciona o usuario recuperado, a lista de usuarios
                usuarios.add(usuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexao.fechar(conn, ps);
        }
        return usuarios;
    }
}
