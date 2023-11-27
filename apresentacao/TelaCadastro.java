package apresentacao;

import entidades.Usuario;
import persistencia.UsuarioDAO;
import java.util.Scanner;

public class TelaCadastro {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);


        System.out.println("1- Cadastrar usuario");
        System.out.println("2- Login usuario");

        int x = tec.nextInt();

        if(x == 1){
            System.out.println("Adicone seu email: Adicione sua senha: Adicione seu nome de usuario: ");
        String email = tec.nextLine();
        String senha = tec.nextLine();
        String nome = tec.nextLine();


              
        }
        else {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorEmailSenha("Arthur28mota@gmail.com", "Arthur2806");
        System.out.println(usuario.toString());
        }

        }
}
