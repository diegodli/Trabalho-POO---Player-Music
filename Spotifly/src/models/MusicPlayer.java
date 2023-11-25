package models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import models.Musica;
import repository.IRepositorioMusica;

public class MusicPlayer {

    private Clip clip;
    private boolean isPlaying;

    public void play(String filePath) {
        try {
            if (clip != null && clip.isOpen()) {
                clip.close();
            }

            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    isPlaying = false;
                }
            });

            clip.start();
            isPlaying = true;

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (clip != null && clip.isOpen()) {
            clip.stop();
            isPlaying = false;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
