package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public Connection conexao = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String BANCO = URL + "db_teste";
    private final String USUARIO = "root";
    private final String SENHA = "SENAC";
    
    public boolean getConexao(){
        try {
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection(BANCO,USUARIO,SENHA);
            System.out.println("Conectou!");
            return true;
        } catch (ClassNotFoundException erro){
            System.out.println("Driver não encontrado!");
            return false;
        } catch (SQLException erro){
            System.out.println("Falha ao Conectar!");
            return false;
        }    
    }
    
    public void fechar(){
        try {
            conexao.close();
            System.out.println("Desconetou!");
        } catch(SQLException erro){
            System.out.println("Falha ao desconectar!");
        }
        
    }
    
    
}
