/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quimera.erp;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
