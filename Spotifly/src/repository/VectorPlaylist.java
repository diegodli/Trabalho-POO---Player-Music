package repository;

import java.util.Vector;
import models.*;
import repository.*;

public class VectorPlaylist implements IRepositorioPlaylist{
    private Vector<Musica> playlist;
    
    public VectorPlaylist(Perfil perfil,Musica musica){
        this.playlist = new Vector<Musica>();
    }
    public void inserirMusicaNaPlaylist(Perfil perfil, Musica musica){
        if(this.existe(musica.getNome())){
            //exceção para se a musica já estiver na playlist
        }
        this.playlist.add(musica);
    }
    
    public void removerMusicaDaPlaylist(Perfil perfil, Musica musica){
        if(this.existe(musica.getNome())){
            this.playlist.remove(musica);
        }
        else{
            //exceção para se a musica não estiver na playlist
        }
    }
    
    public Musica buscar(String musica){
        for(Musica music : this.playlist){
         if(music.getNome().equals(musica)){
            return music;
         }
      }
      return null;
    }
    
    public int tamanho(){
        return this.playlist.size();
    }
}
