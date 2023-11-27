 package teste;

import entidades.Comentario;
import entidades.Publicacao;
import entidades.Usuario;
import persistencia.ComentarioDAO;
import persistencia.UsuarioDAO;
import persistencia.PublicacaoDAO;
import java.util.List;

public class TesteComentario {

    public static void main(String[] args) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();

        //PUBLICAR COMENTARIO

        Comentario comentario = new Comentario();
        comentario.setTextoC("Eu não amo mais plantas");

        Publicacao publicacao = publicacaoDAO.buscarPorId(1);
        Usuario usuario = usuarioDAO.buscarPorId(2);
        comentario.setPublicacao(publicacao);
        comentario.setUsuario(usuario);
        comentarioDAO.salvar(comentario);

        //EDITAR COMENTARIO
        //não funcionando se tiver tempo arrumar

        //Comentario comentario = new Comentario();
        //comentario.setIdComentario(1);
        //comentario.setTextoC("Não amo plnatas");

        //Usuario usuario = usuarioDAO.buscarPorId(1);
        //comentario.setUsuario(usuario);

        //Publicacao publicacao = publicacaoDAO.buscarPorId(1);
        //comentario.setPublicacao(publicacao);
        //comentarioDAO.editar(comentario);

        //BUSCAR POR ID

        //Comentario comentario = comentarioDAO.buscarPorID(1);
        //System.out.println(comentario.toString());

        //EXCLUIR COMENTARIO

        //comentarioDAO.excluir(1);

        //BUSCAR TODOS OS COMENTARIOS

        //List<Comentario> listaComentarios = comentarioDAO.buscarTodos();
        //for(Comentario comentario:listaComentarios){
        //    System.out.println(comentario.toString());
        //}



    }
    
}
