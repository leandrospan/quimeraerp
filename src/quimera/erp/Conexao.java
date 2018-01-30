/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quimera.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Conexao {
    private static final String USUARIO = "root";
    private static final String SENHA = "etec8";
    //private static final String CAMINHO = "jdbc:mariadb://localhost:3306/bdquimera?User=root&password=etec8";
    private static final String CAMINHO = "jdbc:mariadb://localhost:3306/bdquimera";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    
    //Conectar ao banco
    public static Connection abrir(){
        try{
            //Registrar o driver
            Class.forName(DRIVER);
            //Capturar a conexão
            Connection conn = DriverManager.getConnection(CAMINHO, USUARIO, SENHA);
            //Retornar a conexão aberta
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Conexão Falhou!!");
            return null;
        }
    }
    
    //Fechar conexão
    public static void fechar(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Fechamento da Conexão Falhou!!");
        }
    }
    
    public static void fechar(Connection conn, PreparedStatement ps){
        fechar(conn);
        try {
            if(ps != null){
                ps.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Fechamento da Conexão Falhou!!");
        }
    }
    
    public static void fechar(Connection conn, PreparedStatement ps, ResultSet rs){
        fechar(conn, ps);
        try {
            if(rs != null){
                rs.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Fechamento da Conexão Falhou!!");
        }
    }
    
    /*public static void main(String[] args){
        Connection conexao = abrir();
        if(conexao != null){
            System.out.println("Conexão Obtida com Sucesso! " + conexao);
        }
    }*/
}
