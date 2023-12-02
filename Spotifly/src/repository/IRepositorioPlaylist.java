package repository;

import java.util.Vector;
import java. util.List;
import models.*;

public interface IRepositorioPlaylist {
 
    public void adicionar(Musica musica);
    
    public void remover(Musica musica);
    
    public Musica buscar(Musica musica);
    
    public int tamanho();
}
