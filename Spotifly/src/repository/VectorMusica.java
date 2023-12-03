// repository/VectorMusica.java
package repository;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import models.Musica;
import java.io.Serializable;



public class VectorMusica implements IRepositorioMusica, Serializable {
    private Vector<Musica> musicas;
    private String diretorioMusica;
    private static final long serialVersionUID = 3L;

    public VectorMusica(List<Musica> musicas, String diretorioMusica) {
        this.musicas = new Vector<>(musicas);
        this.diretorioMusica = diretorioMusica;
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
        this.musicas.add(musica);
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
        for (Musica musica : this.musicas) {
            System.out.println("Nome: " + musica.getNome() + ", Artista: " + musica.getArtista() + ", URL: " + musica.getUrl());
        }
    }

    @Override
    public List<Musica> getMusicas() {
        return new ArrayList<>(this.musicas);
    }

    @Override
    public void remover(Musica musica) {
        this.musicas.remove(musica);
    }
}

