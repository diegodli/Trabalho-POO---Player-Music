package repository;

import java.util.Vector;
import models.*;

public interface IRepositorioPlaylist {
 
    public void adicionar(Usuario perfil, Musica musica,  Vector<Usuario> perfis, Vector<Musica>musicas);
    
    public void remover(Usuario perfil, Musica musica, Vector<Usuario> perfis, Vector<Musica>musicas);
    
    public Musica buscar(Musica musica);
    
    public int tamanho();
}
