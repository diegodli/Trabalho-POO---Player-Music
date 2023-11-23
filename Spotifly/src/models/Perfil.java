package models;
import repository.IRepositorioMusica;

public abstract class Perfil {
    private String usuario;
    protected IRepositorioMusica playlist;
    
    public Perfil (String usuario, IRepositorioMusica playlist) {
        this.usuario = usuario;
        
        this.playlist = playlist;
    }
    
    public abstract void AdicionarMusica(String nomeDaMusica);
    
    public void RemoverMusica(String nomeDaMusica) {
        playlist.remover(nomeDaMusica);
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    
    
}