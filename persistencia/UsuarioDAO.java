package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Usuario;

public class UsuarioDAO {
    private ConexaoMySQL conexao;

    public UsuarioDAO(){
        this.conexao=new ConexaoMySQL("localhost", "3306", "root", "Arthur2806", "BookFlowers_bd");

    }

    //CADASTRAR USUARIO
    public void salvar (Usuario usuario){
        try{
            this.conexao.abrirConexao();
            String sql= "INSERT INTO usuario VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }

    }

    //LOGIN USUARIO
    //BUSCAR POR EMAIL, SENHA

    public Usuario buscarPorEmailSenha(String email, String senha){
        Usuario usuario = null;
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM usuario WHERE email=? AND senha=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();

            if (rs.next() == true){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } 
        return usuario;
    }

    //NAO SERA ULTILIZADO(CASO O BUSCAR POR EMAIL E SENHA FUNCIONE)
    //BUSCAR POR ID

    public Usuario buscarPorId(long idUsuario){
        Usuario usuario = null;
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM usuario WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, idUsuario);
            ResultSet rs = statement.executeQuery();

            if (rs.next() == true){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }

    //EDITAR USUARIO

    public void editar(Usuario usuario){
        try {
            this.conexao.abrirConexao();
            String sql = "UPDATE usuario SET email=?, senha=?, nome=? WHERE id_usuario=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setLong(4, usuario.getIdUsuario());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //EXCLUIR USUARIO

    public void excluir (long idUsuario){
        try {
            this.conexao.abrirConexao();
            String sql = "DELETE FROM usuario WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, idUsuario);
            statement.executeUpdate();
        } catch (SQLException e ){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //BUSCAR TODOS OS USUARIOS

    public List<Usuario> buscarTodos(){
        Usuario usuario = null;
        List<Usuario> listaUsuarios = new ArrayList<>();
        try{
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM usuario";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next() ==  true){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }
}
