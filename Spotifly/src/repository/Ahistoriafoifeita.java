import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SoundPlayer extends JFrame {

    public SoundPlayer() {
        setTitle("Sound Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JButton playButton = new JButton("Play Sound");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("joaogomescantor-amando-voce-8b8be3f5.wav");
            }
        });

        getContentPane().add(playButton);
    }

    private void playSound(String filename) {
        try {
            File soundFile = new File(filename);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SoundPlayer().setVisible(true);
            }
        });
    }
}
