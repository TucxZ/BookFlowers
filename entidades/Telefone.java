package entidades;

public class Telefone{

    private long idTelefone;
    private int numero;
    private Usuario usuario;

    //construtores vazios

    public Telefone(){
        this.idTelefone=0;
        this.numero=0;
        this.usuario=null;

    }

    //construtores com todos os parametro

    public Telefone (long idTelefone, int numero, Usuario usuario){
        this.idTelefone=idTelefone;
        this.numero=numero;
        this.usuario=usuario;

    }

    //getters e setters

    public void setIdTelefone(long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public long getIdTelefone() {
        return idTelefone;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //metodo toString

    @Override
    public String toString(){
        return idTelefone+" "+numero+" "+usuario;
    }

 }

    
    
        
    
    

