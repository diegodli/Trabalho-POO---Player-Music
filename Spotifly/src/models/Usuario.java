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
    protected VectorPlaylist playlist;
    protected int numMusicas;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setNumMusicas(int numMusicas){ 
      this.numMusicas = numMusicas ; 
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public int getNumMusicas(){
        return numMusicas;
    }
    public VectorPlaylist getPlaylist(){
        return playlist;
    }

    // Método abstrato que pode ser implementado nas subclasses
    public abstract boolean podeAdd();
}
