package persistencia;

import java.sql.PreparedStatement;

import java.sql.SQLException;


import entidades.Usuario;

public class UsuarioDAO {
    private ConexaoMySQL conexao;

    public UsuarioDAO(){
        this.conexao=new ConexaoMySQL("localhost", "3306", "root", "Arthur2806", "BookFlowers_bd");

    }

    // INSERT INTO usuario VALUES(id, nome, email, senha)
    public void salvar (Usuario usuario){
        try{
            this.conexao.abrirConexao();
            String sql= "INSERT INTO usuario VALUES(null, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getNome());
            statement.setLong(4, usuario.getDataLogin());
            statement.setBoolean(5, usuario.getAdm());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }

    }


    
}
