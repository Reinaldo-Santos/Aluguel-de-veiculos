
package br.com.bancoDeDados;
import java.sql.*;
/**
  @author Reinaldo Santos
 */
public class Conectar_com_banco_de_dadaos {
    //Método resposável por estabelecer a conexão com bd
    public static Connection conexao(){
        java.sql.Connection conectar = null;
        //A  linha abaixo chama o driver
        String driver = "com.mysql.jdbc.Driver";
        // Armazena informações referentes ao bd
        String url="jdbc:mysql://localhost:3306/alugueldecarros01";
        String user = "root";
        String Senha = "";
        // Estabelecendo a conexão com o bd
        try {
            conectar=DriverManager.getConnection(url, user, Senha);
            return conectar;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
