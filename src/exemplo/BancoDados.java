package exemplo;

import java.sql.*;
import java.util.Scanner;

public class BancoDados {

    public static void main(String[] args) {
        
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/";
        final String BANCO = URL + "db_teste";
        final String USUARIO = "root";
        final String SENHA = "SENAC";
        
        Scanner sc = new Scanner(System.in);      
        
        try {
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection(BANCO,USUARIO,SENHA);
            //System.out.printf("Conexao feita com sucesso!");
            
            Usuario usuario = new Usuario();
            
            int opcao = -1;       
        
            do {
                System.out.print(
                    "===== teste ======"
                    + "\n1-Incluir"
                    + "\n2-Listar Tudo"
                    + "\n3-Buscar por Matricula"
                    + "\n4-Alterar"
                    + "\n5-Excluir"
                    + "\n0-Sair"
                    + "\n======================"
                    + "\n\nOpção: ");
       
                opcao = sc.nextInt();
                switch(opcao){
                    case 1:    
                        System.out.print("Nome: ");
                        usuario.setNome(sc.next());
                        System.out.print("Idade: ");
                        usuario.setIdade(sc.nextInt());
                        
                        String sql = "INSERT INTO tb_teste(tst_nome, tst_idade) VALUE (?, ?)";
                        
                        PreparedStatement statement = conexao.prepareStatement(sql);
                        statement.setString(1, usuario.getNome());
                        statement.setInt(2, usuario.getIdade());
                    
                        statement.execute();
            
        } catch(ClassNotFoundException erro){
            System.out.println(erro.toString());
        } catch (SQLException erro){
            System.out.println(erro);
        }
        
        
        
        
        
        
        
       
    }
    
}
