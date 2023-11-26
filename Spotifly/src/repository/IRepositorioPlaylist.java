package repository;

import java.util.Vector;
import java. util.List;
import models.*;

public interface IRepositorioPlaylist {
 
    public void adicionar(Usuario perfil, Musica musica,  List<Usuario> usuarios, Vector<Musica> musicas);
    
    public void remover(Usuario perfil, Musica musica, List<Usuario>usuarios, Vector<Musica> musicas);
    
    public Musica buscar(Musica musica);
    
    public int tamanho();
}
