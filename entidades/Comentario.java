package entidades;

public class Comentario{
    
    private long idComentario;
    private String textoC;
    private Usuario usuario;
    private Publicacao publicacao;

    //construtores vazios

    public Comentario(){
        this.idComentario=0;
        this.textoC="";
        this.usuario=null;
        this.publicacao=null;

    }

    //construtores com todos os parametro

    public Comentario (long idComentario, String textoC, Usuario usuario, Publicacao publicacao){
        this.idComentario=idComentario;
        this.textoC=textoC;
        this.usuario=usuario;
        this.publicacao=publicacao;

    }

    //getters e setters

    public void setIdComentario(long idComentario) {
        this.idComentario = idComentario;
    }

    public long getIdComentario() {
        return idComentario;
    }

    public void setTextoC(String textoC) {
        this.textoC = textoC;
    }

    public String getTextoC() {
        return textoC;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    //metodo toString

    @Override
    public String toString(){
        return idComentario+" "+textoC+" "+usuario+" "+publicacao;
    }

   
    }




  

    
