package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private long idUsuario;
    private boolean adm;
    private String email;
    private String senha;
    private String nome;
    private long dataLogin;
    private List<Telefone> ListTelefone;
    private List<Publicacao> ListPublicacao;
    private List<Comentario> ListComentario;
    private List<Curtida> ListCurtida;

    //construtores vazios

    public Usuario(int i, String string, String string2, String string3, int j, boolean b){
        this.idUsuario=0;
        this.adm=true;
        this.adm=false;
        this.email="";
        this.senha="";
        this.nome="";
        this.dataLogin=0;
        this.ListTelefone=new ArrayList<>();
        this.ListPublicacao=new ArrayList<>();
        this.ListComentario=new ArrayList<>();
        this.ListCurtida=new ArrayList<>();

    }

    //construtores com todos os parametro

    public Usuario(long idUsuario, boolean adm, String email, String senha, String nome, long dataLogin, 
    List<Telefone> ListTelefone, List<Publicacao> ListPublicacao, List<Comentario> ListComentario, List<Curtida> ListCurtida){
        this.idUsuario=idUsuario;
        this.adm=adm;
        this.email=email;
        this.senha=senha;
        this.nome=nome;
        this.dataLogin=dataLogin;
        this.ListTelefone=ListTelefone;
        this.ListPublicacao=ListPublicacao;
        this.ListComentario=ListComentario;
        this.ListCurtida=ListCurtida;

    }

    //getters e setters

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public boolean getAdm(){
        return adm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataLogin(long dataLogin) {
        this.dataLogin = dataLogin;
    }

    public long getDataLogin() {
        return dataLogin;
    }

    public void setListTelefone(List<Telefone> listTelefone) {
        ListTelefone = listTelefone;
    }

    public List<Telefone> getListTelefone() {
        return ListTelefone;
    }

    public void setListPublicacao(List<Publicacao> listPublicacao) {
        ListPublicacao = listPublicacao;
    }

    public List<Publicacao> getListPublicacao() {
        return ListPublicacao;
    }

    public void setListComentario(List<Comentario> listComentario) {
        ListComentario = listComentario;
    }

    public List<Comentario> getListComentario() {
        return ListComentario;
    }

    public void setListCurtida(List<Curtida> listCurtida) {
        ListCurtida = listCurtida;
    }

    public List<Curtida> getListCurtida() {
        return ListCurtida;
    }

    //metodo toString

    @Override
    public String toString(){
        return idUsuario+" "+adm+" "+email+" "+senha+" "+nome+" "+dataLogin+" "+ListTelefone+" "+ListPublicacao+" "+ListComentario+" "+ListCurtida;
    }

  
}