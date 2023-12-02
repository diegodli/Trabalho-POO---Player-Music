package repository;

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
    
   
    public void adicionar(Musica musica){
        
            if(!playlist.contains(musica)){
                
                    this.playlist.add(musica);
                }
                //exceção para se não puder adicionar mais músicas
            }
            //exceção para se a música já estiver na playlist
       
       //exceção para se o perfil e/ou música não for encontrado
    
    public void remover(Musica musica){
       
            if(playlist.contains(musica)){
                this.playlist.remove(musica);
            }
            // exceção para se a música não estiver na playlist
        }
        //exceção para se o perfil e/ou música não for encontrado
   
    
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
