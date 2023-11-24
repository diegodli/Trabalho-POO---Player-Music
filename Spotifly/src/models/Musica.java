// models/Musica.java
package models;

public class Musica {
    private String url;
    private String nome;
    private String artista;

    public Musica(String url, String nome, String artista) {
        this.url = url;
        this.nome = nome;
        this.artista = artista;
    }

    // Getters e Setters para os atributos

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
