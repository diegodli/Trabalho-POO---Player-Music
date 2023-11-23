package repository;

import java.util.Vector;
import models.*;
import repository.*;

public class VectorPlaylist implements IRepositorioMusica{
    private Vector<Musica> playlist;
    
    public VectorPlaylist(Perfil perfil,Musica musica){
        this.playlist = new Vector<Musica>();
    }
    
    @Override
    public void adicionar(Perfil perfil, Musica musica){
        if(this.existe(musica.getNome())){
            //exceção para se a musica já estiver na playlist
        }
        this.playlist.add(musica);
    }
    
    @Override
    public void remover(Perfil perfil, Musica musica){
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
