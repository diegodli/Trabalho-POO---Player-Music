package view;

import models.Musica;
import models.Playlist;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import models.MusicPlayer;
import repository.VectorUsuario;


public class MusicasPlaylist {

    private static Usuario usuario2;
    private static MusicPlayer musicPlayer;
   
  
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI(usuario2);
        });
       
    }

    public static void createAndShowGUI(final Usuario usuario) {
        usuario2 = usuario;
       
    

        final JFrame frame = new JFrame("Músicas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Configurar o título
        final JLabel titleLabel = new JLabel("Músicas");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        final JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(30, 30, 30)); // Cor escura fosca
        titlePanel.add(titleLabel);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);

        // Adicionar botão de tocar a playlist
        final JButton playCompletoButton = new JButton("Play");
        playCompletoButton.addActionListener((final ActionEvent e) -> {
            musicPlayer.playAll();
        });
        
        // Adicionar botão de voltar para Playlist no canto superior direito
        final JButton backButton = new JButton("Voltar para Playlist");
        backButton.addActionListener((final ActionEvent e) -> {
            frame.dispose();// Fechar o frame atual
            musicPlayer.pause();
            final Playlist playlist = new Playlist();
            playlist.createAndShowGUI(usuario); // Correção aqui
        });
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(playCompletoButton, BorderLayout.CENTER);
        titlePanel.add(buttonPanel, BorderLayout.EAST); // Adicionando o botão ao painel de título
         
        
        

        // Adicionar cor cinza ao fundo abaixo do título
        final JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Configurar o frame principal
        frame.getContentPane().setBackground(new Color(0, 0, 0)); // Cor preta fosca
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Adicionar botões de música
        final JPanel musicPanel = new JPanel();
        musicPanel.setLayout(new BoxLayout(musicPanel, BoxLayout.Y_AXIS));
        musicPanel.setBackground(Color.LIGHT_GRAY);
        
         musicPlayer = new MusicPlayer();
        
        ArrayList<Musica> musicasTemporarias = new ArrayList<Musica>(usuario.getPlaylist().listarPlaylist());
        VectorUsuario repositorioUsuario = new VectorUsuario();

        for (final Musica musica : musicasTemporarias) {
        
            final JButton musicaButton = new JButton(musica.getNome());
            final JButton playButton = new JButton("Play");
            final JButton pauseButton = new JButton("Pause");
            final JButton retirarButton = new JButton("Remover");
            
            String currentDirectory = System.getProperty("user.dir");
            String fileSeparator = File.separator;
            String filePath = currentDirectory + fileSeparator + "src" + fileSeparator + "MusicsTeste" + fileSeparator;

                    
            String musicFilePath = filePath + musica.getUrl();
            musicPlayer.addToPlaylist(musicFilePath);

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    
                   
                    if (new File(musicFilePath).exists()) {
                        musicPlayer.play(musicFilePath);
                    } else {
                        System.out.println("Arquivo não encontrado: " + musicFilePath);
                    }// Lógica para tocar a música
                }
            });

            pauseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                      musicPlayer.pause();// Lógica para pausar a música
                }
            });
            

            // Crie um novo botão de música e adicione-o ao painel
            final JPanel musicButtonPanel = new JPanel();
            musicButtonPanel.setLayout(new FlowLayout());
            musicButtonPanel.add(musicaButton);
            musicButtonPanel.add(playButton);
            musicButtonPanel.add(pauseButton);
            musicButtonPanel.add(retirarButton);

            musicPanel.add(musicButtonPanel);
            
             retirarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {  //apagando botão por botão
                    
                    musicasTemporarias.remove(musica);
                    usuario.removerMusica(musica);
                    repositorioUsuario.desserializarUsuarios();
                    repositorioUsuario.atualizarUsuario(usuario);
                    
                    musicButtonPanel.remove(musicaButton);
                    musicButtonPanel.remove(playButton);
                    musicButtonPanel.remove(pauseButton);
                    musicButtonPanel.remove(retirarButton);
                    musicButtonPanel.revalidate(); //atualizando a tela
                }
            });
        }

        contentPanel.add(musicPanel);
    }

    private MusicasPlaylist() {
    }
}
