// repository/VectorMusica.java
package repository;

import java.util.Vector;
import models.Musica;

public class VectorMusica implements IRepositorioMusica {
    private Vector<Musica> musicas;
    
    public static void main(String[] args) {
        VectorMusica repositorioMusica = new VectorMusica();
        
        repositorioMusica.imprimirUrlsMusicas();
    }
    public VectorMusica() {
        this.musicas = new Vector<>();
   
    }

    @Override
    public Musica buscar(String nomeMusica) {
        for (Musica musica : this.musicas) {
            if (musica.getNome().equals(nomeMusica)) {
                return musica;
            }
        }
        return null;
    }

    public void adicionar(Musica musica) {
        
    }
    
    public Musica obterMusicaPorUrl(String url) {
        for (Musica musica : this.musicas) {
            if (musica.getUrl().equals(url)) {
                return musica;
            }
        }
        return null;
    }  

    private void imprimirUrlsMusicas() {
        
    }

    @Override
    public void remover(Musica musica) {
        
    }
    
}

