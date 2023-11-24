package repository;

import java.util.Vector;
import models.*;
import repository.*;

public class VectorPlaylist implements IRepositorioPlaylist{
    private Vector<Musica> playlist;
    
    
    public VectorPlaylist(){
        this.playlist = new Vector<Musica>();
    }
    
   
    public void adicionar(Perfil perfil, Musica musica, Vector<Perfil> perfis, Vector<Musica> musicas){
        if(perfis.contains(perfil) && musicas.contains(musica)){
            if(!playlist.contains(musica)){
                this.playlist.add(musica);
            }
            //exceção para se a música já estiver na playlist
        }
       //exceção para se o perfil e/ou música não for encontrado
    }
    
    public void remover(Perfil perfil, Musica musica, Vector<Perfil> perfis, Vector<Musica> musicas){
        if(perfis.contains(perfil) && musicas.contains(musica)){
            if(playlist.contains(musica)){
                this.playlist.remove(musica);
            }
            // exceção para se a música não estiver na playlist
        }
        //exceção para se o perfil e/ou música não for encontrado
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
}
