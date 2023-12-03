package models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<String> playlist;
    private int currentSongIndex;
    private Clip clip;
    private boolean isPlaying;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentSongIndex = 0;
    }

    public void addToPlaylist(String filePath) {
        playlist.add(filePath);
    }
    
    public void removeFromPlaylist(String filePath){
        if(playlist.contains(filePath)){
            this.playlist.remove(filePath);
        }
    }
    
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

    public void playNext() {
        if (clip != null && clip.isOpen()) {
            clip.close();
        }

        if (currentSongIndex < playlist.size()) {
            try {
                File audioFile = new File(playlist.get(currentSongIndex));
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

                clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        isPlaying = false;
                        playNext();
                    }
                });

                clip.start();
                isPlaying = true;
                currentSongIndex++;

            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void playAll() {
        currentSongIndex = 0;
        playNext();
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

