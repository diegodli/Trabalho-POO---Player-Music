package repository;

import models.Musica;
import java.util.List;

public interface IRepositorioMusica{
    
     public Musica buscar(String nomeString);
     
     public void adicionar(Musica musica);
     
     public void remover(Musica musica);

     List<Musica> getMusicas();
}
