package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import entidades.Publicacao;
import entidades.Usuario;
import entidades.Comentario;
import java.util.ArrayList;
import java.util.List;



public class ComentarioDAO {

    private ConexaoMySQL conexao;

    public ComentarioDAO(){
        super();
        this.conexao = new ConexaoMySQL("localhost", "3306", "root", "Arthur2806", "BookFlowers_bd");       
    }

    //SALVAR COMENTARIO

    public void salvar (Comentario comentario){
        try{
            this.conexao.abrirConexao();
            String sql = "INSERT INTO comentario VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, comentario.getTextoC());
            statement.setLong(2, comentario.getPublicacao().getIdPublicacao());
            statement.setLong(3, comentario.getUsuario().getIdUsuario());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //EDITAR

    public void editar(Comentario comentario){
        try{
            this.conexao.abrirConexao();
            String sql = "UPDATE publicacao SET textoC=? WHERE id_comentario=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, comentario.getTextoC());
            statement.setLong(2, comentario.getIdComentario());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //BUSCAR POR ID

    public Comentario buscarPorID(long idComentario){
        Comentario comentario = null;
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM comentario WHERE id_comentario=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, idComentario);
            ResultSet rs = statement.executeQuery();

            if(rs.next() == true){
                comentario = new Comentario();
                comentario.setIdComentario(rs.getLong("id_comentario"));
                comentario.setTextoC(rs.getString("textoC"));
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                comentario.setUsuario(usuario);

                PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
                Publicacao publicacao = publicacaoDAO.buscarPorId(rs.getLong("id_publicacao"));
                comentario.setPublicacao(publicacao);
            }
            } catch (SQLException e){
            e.printStackTrace();
        }
        return comentario;
    }

    //DELETAR PUBLICACAO

    public void excluir(long idComentario){
        try{
            this.conexao.abrirConexao();
            String sql = "DELETE FROM comentario WHERE id_comentario=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, idComentario);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //BUSCAR TODOS

    public List<Comentario> buscarTodos(){
        List<Comentario> listaComentarios = new ArrayList<>();
        Comentario comentario = null;
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM comentario";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

            while (rs.next() == true){
                comentario = new Comentario();
                comentario.setIdComentario(rs.getLong("id_comentario"));
                comentario.setTextoC(rs.getString("textoC"));

                UsuarioDAO usuarioDAO = new UsuarioDAO();

                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                comentario.setUsuario(usuario);
                listaComentarios.add(comentario);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaComentarios;
    }


}    

