package repository;

import models.Musica;

public interface IRepositorioMusica{
    
     public Musica buscar(String musica);
     
     public void adicionar(Musica musica);
     
     public void remover(Musica musica);
}
