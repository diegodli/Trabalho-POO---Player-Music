package repository;

import java.util.Vector;
import Spotifly.src.models.*;

public class VectorMusica implements IRepositorio{
   private Vector<Musica> musicas;

   public VectorMusica(){
    this.musicas = new Vector<Musica>();
   }

   public Musica buscar(String musica){
      for(Musica music : this.musicas){
         if(music.getNome().equals(musica)){
            return music;
         }
      }
      return null;
   }
}
