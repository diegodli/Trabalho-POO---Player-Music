package repository;

import java.util.Vector;
import models.*;

public interface IRepositorioPlaylist {
 
    public void adicionar(Perfil perfil, Musica musica,  Vector<Perfil> perfis, Vector<Musica>musicas);
    
    public void remover(Perfil perfil, Musica musica, Vector<Perfil> perfis, Vector<Musica>musicas);
    
    public Musica buscar(Musica musica);
    
    public int tamanho();
}
