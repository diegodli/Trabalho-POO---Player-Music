package repository;

import models.*;

public interface IRepositorioPlaylist {
 
    public void inserirMusicaNaPlaylist(Perfil perfil, Musica musica);
    
    public void removerMusicaDaPlaylist(Perfil perfil, Musica musica);
    
    public Musica buscar(String musica);
    
    public int tamanho();
}
