import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.*;
 
public class PlayerMusica {
    private String nomeMusica;
    private String url;
    private String autor;
    private boolean isPlaying;

    public PlayerMusica(String nomeMusica, String url, String autor) {
        this.nomeMusica = nomeMusica;
        this.url = url;
        this.autor = autor;
        this.isPlaying = false;
    }

    public void play() {
        if (!isPlaying) {
            System.out.println("Tocando: " + nomeMusica + " - " + autor);
            System.out.println("URL: " + url);
            isPlaying = true;
        } else {
            System.out.println("A música já está sendo reproduzida.");
        }
    }

    public void pause() {
        if (isPlaying) {
            System.out.println("Pausando: " + nomeMusica + " - " + autor);
            isPlaying = false;
        } else {
            System.out.println("Nenhuma música está sendo reproduzida para pausar.");
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        PlayerMusica player = new PlayerMusica("Exemplo", "http://exemplo.com/musica.mp3", "Artista");
        
        // Tocar a música
        player.play();

        // Pausar a música
        player.pause();
    }
}



