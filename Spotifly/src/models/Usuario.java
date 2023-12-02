package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import repository.VectorPlaylist;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    public VectorPlaylist playlist;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.playlist = new VectorPlaylist();
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPlaylist(VectorPlaylist playlist){
        this.playlist = playlist;
    }
    
    public VectorPlaylist getPlaylist(){
        return playlist;
    }
    
    public abstract void adicionarMusica(Musica musica);
    
    public void removerMusica(Musica musica){
        playlist.remover(musica);
    }
    
	public void setNome(String string) {
	}
}
