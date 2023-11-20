package entidades;

public class Curtida{
    
    private long idCurtida;
    private Usuario usuario;
    private Publicacao publicacao;

    //construtores vazios

    public Curtida(){
        this.idCurtida=0;
        this.usuario=null;
        this.publicacao=null;

    }

    //construtores com todos os parametro

    public Curtida(long idCurtida, Usuario usuario, Publicacao publicacao){
        this.idCurtida=idCurtida;
        this.usuario=usuario;
        this.publicacao=publicacao;

    }

    //getters e setters

    public void setIdCurtida(long idCurtida) {
        this.idCurtida = idCurtida;
    }

    public long getIdCurtida() {
        return idCurtida;
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
        return idCurtida+" "+usuario+" "+publicacao;
    }
    
    
}
