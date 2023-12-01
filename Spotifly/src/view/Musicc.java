package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Usuario;
import models.UsuarioPremium;
import models.MusicPlayer;
import models.Musica;
import view.MusicasPlaylist;
import repository.VectorMusica;
import repository.IRepositorioMusica;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class Musicc extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private MusicPlayer musicPlayer;
    private IRepositorioMusica repositorioMusica;
    private MusicasPlaylist musicasPlaylist;


    public Musicc(Usuario usuario) {
        this.usuario = usuario;

        List<Musica> listaMusicas = new ArrayList<>();
        
        listaMusicas.add(new Musica("gustavomioto-gustavo-mioto-anti-amor-part-jorge-e-mateus-61cde797.wav", "anti-amor", "Gustavo Mioto"));
        listaMusicas.add(new Musica("joaogomescantor-dengo-802f8e08.wav", "dengo", "João Gomes"));
        listaMusicas.add(new Musica("henriqueejulianooficial-eu-e-a-saudade-b16028df.wav", "eu e a saudade", "Henrique e Juliano"));
        listaMusicas.add(new Musica("pericles-ate-que-durou-7307fede.wav", "até que durou", "Péricles"));
        listaMusicas.add(new Musica("nadsonoferinhadoarrochaweb-03-eu-vc-o-mar-e-ela-401f3c7f.wav", "eu você o mar e ela", "Nadson Ferinha"));
        listaMusicas.add(new Musica("pablocantoroficial-nem-doeu-01ab7769.wav", "nem doeu", "Pablo"));

        String currentDirectory = System.getProperty("user.dir");
        String fileSeparator = File.separator;
        String filePath = currentDirectory + fileSeparator + "src" + fileSeparator + "MusicsTeste" + fileSeparator;


        this.repositorioMusica = new VectorMusica(listaMusicas, filePath);  // Ou outra classe que implemente IRepositorioMusica

        // Configurações do frame
        setTitle("Musicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setBackground(Color.blue);// Centraliza o frame na tela

        // Configuração do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
      
       
        panel.setBackground(Color.blue);
        add(panel);

        // Adiciona o título "Musicas" no topo
        JLabel titleLabel = new JLabel("Musicas");
        titleLabel.setForeground(Color.WHITE); // Alteração aqui
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.PAGE_START);
    

        // Configuração do botão de volta à página inicial
       JButton backButton = new JButton("Voltar");
     
        backButton.setForeground(Color.WHITE); // Alteração aqui
        backButton.setBackground(Color.BLACK); 
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaginaInicial(usuario).setVisible(true);
                dispose(); // Fecha o frame atual (Music)
            }
        });

        List<Musica> musicas = repositorioMusica.getMusicas();
        musicPlayer = new MusicPlayer();

        
     

        // Configuração do painel para exibir as músicas em coluna
        JPanel musicPanel = new JPanel();
        musicPanel.setLayout(new GridLayout(8, 1)); // Usando GridLayout com 1 coluna
        musicPanel.setBackground(Color.black);
        musicPanel.setAlignmentY(Component.CENTER_ALIGNMENT);  // Ou use Component.CENTER_ALIGNMENT
       
        
        for (Musica musica : musicas) {
            JButton musicaButton = new JButton(musica.getNome() + " - " + musica.getArtista());
            musicaButton.setForeground(Color.WHITE); // Alteração aqui
            musicaButton.setBackground(Color.BLACK);
            musicaButton.setPreferredSize(new Dimension(230, 30));

            // Adiciona botões de play e pause ao lado de cada música
            JButton playButton = new JButton("Play");
            playButton.setPreferredSize(new Dimension(100, 30));
            playButton.setBackground(new Color(173, 216, 230));
            JButton pauseButton = new JButton("Pause");
            pauseButton.setBackground(new Color(173, 216, 230));
            JButton adicionarButton = new JButton("Adicionar");
            adicionarButton.setBackground(new Color(173, 216, 230));
            adicionarButton.setPreferredSize(new Dimension(100, 30));
            adicionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Musica novaMusica = new Musica("nome", "artista", "joaogomescantor-dengo-802f8e08.wav");
                    musicas.add(novaMusica);
            
                    // Cria e mostra a GUI atualizada
                    MusicasPlaylist.createAndShowGUI(usuario, musicas);
                }
            });
            
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String musicFilePath = filePath + musica.getUrl();
                    if (new File(musicFilePath).exists()) {
                        musicPlayer.play(musicFilePath);
                    } else {
                        System.out.println("Arquivo não encontrado: " + musicFilePath);
                    }
                }
            });
            pauseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    musicPlayer.pause();
                }
            });

            // Adiciona os botões ao painel de música
            JPanel musicButtonPanel = new JPanel();
            musicButtonPanel.setLayout(new FlowLayout());
            musicButtonPanel.add(musicaButton);
            musicButtonPanel.add(playButton);
            musicButtonPanel.add(pauseButton);
            musicButtonPanel.add(adicionarButton);

            musicPanel.add(musicButtonPanel);
        }

        // Adiciona o painel de músicas ao painel principal
        panel.add(musicPanel, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);
        
    }

    public MusicasPlaylist getMusicasPlaylist() {
		return musicasPlaylist;
	}

	public void setMusicasPlaylist(MusicasPlaylist musicasPlaylist) {
		this.musicasPlaylist = musicasPlaylist;
	}

	public Musicc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogin().setVisible(true);
                
            }
        });
    }

    public static class setVisible {

        public setVisible(boolean b) {
        }
    }
}
