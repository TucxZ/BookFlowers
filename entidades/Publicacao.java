package entidades;

import java.util.ArrayList;
import java.util.List;

public class Publicacao{

    private long idPublicacao;
    private String textoP;
    private String foto;
    private long dataHoraP;
    private Usuario usuario;
    private List<Comentario> ListComentario;
    private List<Curtida> ListCurtida;

    //construtores vazios

    public Publicacao(){
        this.idPublicacao=0;
        this.textoP="";
        this.foto="";
        this.dataHoraP=0;
        this.usuario=null;
        this.ListComentario=new ArrayList<>();
        this.ListCurtida=new ArrayList<>();
    }

    //construtores com todos os parametro

    public Publicacao (long idPublicacao, String textoP, String foto, long dataHoraP, Usuario usuario, List<Comentario> ListComentario, List<Curtida> ListCurtida){
        this.idPublicacao=idPublicacao;
        this.textoP=textoP;
        this.foto=foto;
        this.dataHoraP=dataHoraP;
        this.usuario=usuario;
        this.ListComentario=ListComentario;
        this.ListCurtida=ListCurtida;

    }

    //getters e setters

    public void setIdPublicacao(long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public long getIdPublicacao() {
        return idPublicacao;
    }

    public void setTextoP(String textoP) {
        this.textoP = textoP;
    }

    public String getTextoP() {
        return textoP;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setDataHoraP(long dataHoraP) {
        this.dataHoraP = dataHoraP;
    }

    public long getDataHoraP() {
        return dataHoraP;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
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
         return idPublicacao+" "+textoP+" "+foto+" "+dataHoraP+" "+usuario+" "+ListComentario+" "+ListCurtida;
     }
 
}
