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
        cadastrarMusica("url1", "Nome1", "Artista 1");
        cadastrarMusica("url2", "Nome2", "Artista 2");
        cadastrarMusica("url3", "Nome3", "Artista 3"); 
   
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

    public void cadastrarMusica(String url, String nome, String artista) {
        Musica novaMusica = new Musica(url, nome, artista);
        this.musicas.add(novaMusica);

    }
    
    public Musica obterMusicaPorUrl(String url) {
        for (Musica musica : this.musicas) {
            if (musica.getUrl().equals(url)) {
                return musica;
            }
        }
        return null;
    }  
    
}

