package teste;

import java.util.List;
import entidades.Publicacao;
import entidades.Usuario;
import persistencia.UsuarioDAO;
import persistencia.PublicacaoDAO;

public class TestePublicacao {
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();

        //PUBLICAR POST

        //Publicacao publicacao = new Publicacao();
        //publicacao.setTextoP("hsfalsjdf");
        //publicacao.setFoto(null);
        
        //Usuario usuario = usuarioDAO.buscarPorId(1);
        //publicacao.setUsuario(usuario);
        //publicacaoDAO.salvar(publicacao);

        //EDITAR PUBLICACAO

        //Publicacao publicacao = new Publicacao();
        //publicacao.setIdPublicacao(1);
        //publicacao.setTextoP("e quando eu chego no para");
        //publicacao.setFoto(null);

        //Usuario usuario = usuarioDAO.buscarPorId(2);
        //publicacao.setUsuario(usuario);
        //publicacaoDAO.editar(publicacao);

        //EXCLUIR PUBLICACAO

        //publicacaoDAO.excluir(3);

        //BUSCAR POR ID

        //Publicacao publicacao = publicacaoDAO.buscarPorId(3);
        //System.out.println(publicacao.toString());

        //BUSCAR TODOS

        List<Publicacao> listaPublicacaos = publicacaoDAO.buscarTodos();
        for(Publicacao publicacao:listaPublicacaos){
            System.out.println(publicacao.toString());
        }
    }
} 
