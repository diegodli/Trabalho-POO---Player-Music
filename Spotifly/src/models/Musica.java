// models/Musica.java
package models;

import java.io.Serializable;
import java.util.Objects;

public class Musica implements Serializable{
    private String url;
    private String nome;
    private String artista;
    private static final long serialVersionUID = 2L;

    public Musica (String url, String nome, String artista){
        this.url = url;
        this.nome = nome;
        this.artista = artista;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Musica musica = (Musica) obj;
        return Objects.equals(url, musica.url)
                && Objects.equals(nome, musica.nome)
                && Objects.equals(artista, musica.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, nome, artista);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
