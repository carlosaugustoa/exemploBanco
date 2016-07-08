package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {

    public static void main(String[] args) {
        
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/";
        final String BANCO = URL + "db_teste";
        final String USUARIO = "root";
        final String SENHA = "SENAC";
                
        try {
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection(BANCO,USUARIO,SENHA);
            conexao.close();
            System.out.printf("Conexao feita com sucesso!");
        } catch(ClassNotFoundException erro){
            System.out.println(erro.toString());
        } catch (SQLException erro){
            System.out.println(erro);
        }
        
        
        
    }
    
}
