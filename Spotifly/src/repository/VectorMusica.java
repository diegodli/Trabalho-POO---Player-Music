// repository/VectorMusica.java
package repository;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import models.Musica;



public class VectorMusica implements IRepositorioMusica {
    private Vector<Musica> musicas;
    private String diretorioMusica;

    public VectorMusica(List<Musica> musicas, String diretorioMusica) {
        this.musicas = new Vector<>(musicas);
        this.diretorioMusica = diretorioMusica;
    }

    public static void main(String[] args) {
        VectorMusica repositorioMusica = new VectorMusica();

        Musica musica1 = new Musica("gustavomioto-gustavo-mioto-anti-amor-part-jorge-e-mateus-61cde797.wav", "anti-amor", "Gustavo Mioto");
        Musica musica2 = new Musica("joaogomescantor-dengo-802f8e08.wav", "dengo", "João Gomes");
        Musica musica3 = new Musica("henriqueejulianooficial-eu-e-a-saudade-b16028df.wav", "eu e a saudade", "Henrique e Juliano");
        Musica musica4 = new Musica("pericles-ate-que-durou-7307fede.wav", "até que durou", "Péricles");
        Musica musica5 = new Musica("nadsonoferinhadoarrochaweb-03-eu-vc-o-mar-e-ela-401f3c7f.wav", "eu você o mar e ela", "Nadson Ferinha");
        Musica musica6 = new Musica("pablocantoroficial-nem-doeu-01ab7769.wav", "nem doeu", "Pablo");

        repositorioMusica.adicionar(musica1);
        repositorioMusica.adicionar(musica2);
        repositorioMusica.adicionar(musica3);
        repositorioMusica.adicionar(musica4);
        repositorioMusica.adicionar(musica5);
        repositorioMusica.adicionar(musica6);

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

