package teste;

import java.util.List;
import entidades.Usuario;
import persistencia.UsuarioDAO;

public class TesteUsuario {
    public static void main(String[] args) {

        //CADASTRAR USUARIO

        Usuario usuario = new Usuario(0, "Alana@gmail.com", "Alana123", "Alana", null, null, null, null);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usuario);
        
        //TESTE BUSCAR POR EMAIL E SENHA

        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //Usuario usuario = usuarioDAO.buscarPorEmailSenha("Arthur28mota@gmail.com", "Arthur2806");
        //System.out.println(usuario.toString());

        //TESTE BUSCAR POR ID

        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //Usuario usuario = usuarioDAO.buscarPorId(2);
        //System.out.println(usuario.toString());

        //EXCLUIR USUARIO

        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //usuarioDAO.excluir(3);

        //EDITAR USUARIO

        //Usuario usuario = new Usuario(3,"Arthur28mota@gmail.com","Arthur2806","Arthur", null, null, null, null);
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //usuarioDAO.editar(usuario);

        //BUSCAR TODOS OS USUARIOS

        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //List<Usuario> listaUsuarios = usuarioDAO.buscarTodos();
        //for(Usuario usuario:listaUsuarios){
        //    System.out.println(usuario.toString());
        //}
    }
    
}
