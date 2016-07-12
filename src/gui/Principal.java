package gui;


import dao.UsuarioDao;
import javax.swing.JOptionPane;
import model.Usuario;

public class Principal {

    public static void main(String[] args) {
  
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = new Usuario();

////incluir      
//        usuario.setNome(
//           JOptionPane.showInputDialog("Nome do Usuario")
//        );
//       
//        usuario.setIdade(
//            Integer.parseInt(
//                JOptionPane.showInputDialog("Idade do Usuario")
//            )
//        );
//       
//       dao.insert(usuario);
    
        
//excluir
//        usuario.setId(
//            Integer.parseInt(
//                JOptionPane.showInputDialog("Idade do Usuario")
//            )
//        );
//        
//        if (dao.excluir(usuario)) {
//            JOptionPane.showMessageDialog(null, "SUCESSO!");
//        } else {
//            JOptionPane.showMessageDialog(null, "FALHA");
//        }
//      
        
//listar
        String texto = "";
        
        for (Usuario u : dao.listarTudo()){
            texto += u.getId() + " " + u.getNome() + " " + u.getIdade() + "\n";
        }
        
        JOptionPane.showMessageDialog(null,texto);
        
        
        
        
        
        
        
    }
}  
  






//package gui;
//
//import model.Usuario;
//import java.sql.*;
//import java.util.Scanner;
//
//public class Principal {
//
//    public static void main(String[] args) {
//  
//        final String DRIVER = "com.mysql.jdbc.Driver";
//        final String URL = "jdbc:mysql://localhost:3306/";
//        final String BANCO = URL + "db_teste";
//        final String USUARIO = "root";
//        final String SENHA = "SENAC";
//        
//        Scanner sc = new Scanner(System.in);      
//        
//        try {
//            Class.forName(DRIVER);
//            Connection conexao = DriverManager.getConnection(BANCO,USUARIO,SENHA);
//            //System.out.printf("Conexao feita com sucesso!");
//            
//            Usuario usuario = new Usuario();
//            
//                        System.out.print("Nome: ");
//                        usuario.setNome(sc.next());
//                        System.out.print("Idade: ");
//                        usuario.setIdade(sc.nextInt());
//                        
//                        String sql = "INSERT INTO tb_teste(tst_nome, tst_idade) VALUE (?, ?)";
//                        
//                        PreparedStatement statement = conexao.prepareStatement(sql);
//                        statement.setString(1, usuario.getNome());
//                        statement.setInt(2, usuario.getIdade());
//                    
//                        statement.execute();
//            
//        } catch(ClassNotFoundException erro){
//            System.out.println(erro.toString());
//        } catch (SQLException erro){
//            System.out.println(erro);
//        }
//         
//    }
//    
//}
