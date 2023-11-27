package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Publicacao;
import entidades.Usuario;
import java.sql.ResultSet;

public class PublicacaoDAO {

    private ConexaoMySQL conexao;

    public PublicacaoDAO(){
        super();
        this.conexao = new ConexaoMySQL("localhost", "3306", "root", "Arthur2806", "BookFlowers_bd");
    }

    //SALVAR PUBLICAÇÃO

    public void salvar(Publicacao publicacao){
        try{
            this.conexao.abrirConexao();
            String sql = "INSERT INTO publicacao VALUES(null, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, publicacao.getTextoP());
            statement.setString(2, publicacao.getFoto());
            statement.setLong(3, publicacao.getUsuario().getIdUsuario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //EDITAR PUBLICACAO

    public void editar(Publicacao publicacao){
        try{
            this.conexao.abrirConexao();
            String sql = "UPDATE publicacao SET textoP=?, foto=? WHERE id_publicacao=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, publicacao.getTextoP());
            statement.setString(2, publicacao.getFoto());
            statement.setLong(3, publicacao.getIdPublicacao());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //DELETAR PUBLICACAO

    public void excluir(long idPublicacao){
        try{
            this.conexao.abrirConexao();
            String sql = "DELETE FROM publicacao WHERE id_publicacao=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, idPublicacao);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    //BUSCAR POR ID

    public Publicacao buscarPorId(long idPublicacao){
        Publicacao publicacao = null;
        try{
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM publicacao WHERE id_publicacao=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, idPublicacao);
            ResultSet rs = statement.executeQuery();

            if(rs.next() == true){
                publicacao = new Publicacao();
                publicacao.setIdPublicacao(rs.getLong("id_publicacao"));
                publicacao.setTextoP(rs.getString("textoP"));
                publicacao.setFoto(rs.getString("foto"));

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                publicacao.setUsuario(usuario);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return publicacao;
    }

    //BUSCAR TODOS

    public List<Publicacao> buscarTodos(){
        List<Publicacao> listapPublicacaos = new ArrayList<>();
        Publicacao publicacao = null;
        try {
            this.conexao.abrirConexao();
            String sql = "SELECT * FROM publicacao";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

            while (rs.next() == true){
                publicacao = new Publicacao();
                publicacao.setIdPublicacao(rs.getLong("id_publicacao"));
                publicacao.setTextoP(rs.getString("textoP"));
                publicacao.setFoto(rs.getString("foto"));

                UsuarioDAO usuarioDAO = new UsuarioDAO();

                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                publicacao.setUsuario(usuario);
                listapPublicacaos.add(publicacao);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listapPublicacaos;

    }
}

