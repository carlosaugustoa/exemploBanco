package dao;

import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Usuario usuario;
    public Db db;
    private PreparedStatement statement;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    public UsuarioDao(){
        usuario = new Usuario();
        db = new Db();
    }
    
    
    // método inserir
    public void insert(Usuario usuario) {
        if (db.getConexao()){
            try {
                sql = "INSERT INTO tb_teste (tst_nome, tst_idade) VALUES (?, ?)";
                statement = db.conexao.prepareStatement(sql);
                statement.setString(1, usuario.getNome());
                statement.setInt(2, usuario.getIdade());
                statement.execute();
                statement.close();
            } catch (SQLException erro){
                System.out.println("Falha na operção!");
                System.out.println("Erro: " + erro);
            } finally {
                db.fechar();
            }
        }
    }
    
    // método excluir
    public boolean excluir(Usuario usuario){
        if (db.getConexao()){
            sql = "DELETE FROM tb_teste WHERE tst_id = ?";
            try {
                statement = db.conexao.prepareStatement(sql);
                statement.setInt(1, usuario.getId());
                if (statement.executeUpdate() == 1){
                    return true;
                }
            } catch (SQLException erro){
                System.out.println("Falha na opercao");
                System.out.println("Erro: " + erro);
                return false;
            }
        }
        return false;
    }
    
    // método listar tudo
    public List<Usuario> listarTudo(){
        if (db.getConexao()){
        List<Usuario> usuarios = new ArrayList();
        sql = "SELECT * FROM tb_teste";
        try {
            statement = db.conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("tst_id"));
                usuario.setNome(resultSet.getString("tst_nome"));
                usuario.setIdade(resultSet.getInt("tst_idade"));
                usuarios.add(usuario);
            }
        } catch (SQLException erro) {
            System.out.println("Falha na opercação!");
            System.out.println("Erro " + erro);
        
        }
        return usuarios;
    }
     return null;
    
    }
    
    // método listar por id
    public Usuario listarPorId(int id){
        Usuario usuario = new Usuario();
        sql = "SELECT * FROM tb_teste WHERE tst_id = ?";
        if (db.getConexao()){
            try {
                statement = db.conexao.prepareStatement(sql);
                statement.setInt(1,id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    usuario.setId(resultSet.getInt("tst_id"));
                    usuario.setNome(resultSet.getString("tst_nome"));
                    usuario.setIdade(resultSet.getInt("tst_idade"));
                }
                return usuario;
            } catch (SQLException erro) {
                System.out.println("Falha na opercação!");
                System.out.println("Erro " + erro);
                return null;
            }    
                    
        }            
        return null;
    }
    
    // método listar por nome
    public List<Usuario> listarPorLike(String nome){
        List<Usuario> usuarios = new ArrayList();
        sql = "SELECT * FROM tb_teste WHERE tst_nome LIKE ?";
        nome = "%" + nome + "%";
        if (db.getConexao()){    
            try{
                ps = db.conexao.prepareStatement(sql);
                ps.setString(1,nome);
                rs = ps.executeQuery();
                while (rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("tst_id"));
                    usuario.setNome(rs.getString("tst_nome"));
                    usuario.setIdade(rs.getInt("tst_idade"));
                }
                rs.close();
                ps.close();
            }catch (SQLException erro) {
                System.out.println("Falha na opercação!");
                System.out.println("Erro " + erro);
                return null;
            } finally {
                db.fechar();
            }
                    
        }            
        return null;
    }
    
}
