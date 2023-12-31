package repository;

import Exception.*;
import java.util.Vector;
import java.util.List;
import models.*;
import repository.*;
import java.io.Serializable;
import java.util.ArrayList;

public class VectorPlaylist implements IRepositorioPlaylist, Serializable{
    private Vector<Musica> playlist;
    private static final long serialVersionUID = 5L;
    
    
    public VectorPlaylist(){
        this.playlist = new Vector<Musica>();
    }
    
   
    public void adicionar(Musica musica) throws AdicionarMusicaException{
        
        if(!playlist.contains(musica)){
                
            this.playlist.add(musica);
        }
                
            
        else {
            throw new MusicaJaExisteNaPlaylistException(musica);
        }
    }
            
       
       //exceção para se o perfil e/ou música não for encontrado
    
    public void remover(Musica musica){
       
            if(playlist.contains(musica)){
                this.playlist.remove(musica);
            }
           
        }
        
   
    
    public Musica buscar(Musica musica){
       if(playlist.contains(musica)){
           return musica;
       }
       return null;
    }
    
    public int tamanho(){
        return this.playlist.size();
    }
    
    public ArrayList listarPlaylist(){
        ArrayList<Musica> musicasListadas = new ArrayList<Musica>();
        for(Musica musica : this.playlist){
            musicasListadas.add(musica);
        }
        return musicasListadas;
    }

}
