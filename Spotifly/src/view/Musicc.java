package view;

import Exception.AdicionarMusicaException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Usuario;
import models.MusicPlayer;
import models.Musica;

import repository.VectorMusica;
import repository.IRepositorioMusica;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import repository.VectorUsuario;


public class Musicc extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private List<Musica> musicas;
   

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

        musicas = new ArrayList<>();

        musicas = new ArrayList<>();
        musicas.add(new Musica("gustavomioto-gustavo-mioto-anti-amor-part-jorge-e-mateus-61cde797.wav", "anti-amor", "Gustavo Mioto"));
        musicas.add(new Musica("joaogomescantor-dengo-802f8e08.wav", "dengo", "João Gomes"));
        musicas.add(new Musica("henriqueejulianooficial-eu-e-a-saudade-b16028df.wav", "eu e a saudade", "Henrique e Juliano"));
        musicas.add(new Musica("pericles-ate-que-durou-7307fede.wav", "até que durou", "Péricles"));

        musicas.add(new Musica("pablocantoroficial-nem-doeu-01ab7769.wav", "nem doeu", "Pablo"));
        musicas.add(new Musica("Marília Mendonça - Leão - Decretos Reais.wav", "Leão", "Rainha"));
        musicas.add(new Musica("Ana Castela - Tô Voltando.wav", "Tô Voltando", "Ana Castela"));
        musicas.add(new Musica("Gusttavo Lima - Canudinho Part. Ana Castela.wav", "Canudinho", "Gusttavo Lima feat Ana Castela"));

        String currentDirectory = System.getProperty("user.dir");
        String fileSeparator = File.separator;
        String filePath = currentDirectory + fileSeparator +"src" + fileSeparator + "MusicsTeste" + fileSeparator;
        


        this.repositorioMusica = new VectorMusica(musicas, filePath);  // Ou outra classe que implemente IRepositorioMusica

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

        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        searchPanel.add(searchField);

        searchButton = new JButton("Pesquisar");
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(Color.BLACK);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                Musica foundMusic = searchMusic(searchTerm);
                if (foundMusic != null) {
                    openMusicDetailPage(foundMusic, filePath);
                } else {
                    JOptionPane.showMessageDialog(null, "Música não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.PAGE_START);
    

        // Configuração do botão de volta à página inicial
       JButton backButton = new JButton("Voltar");
     
        backButton.setForeground(Color.WHITE); // Alteração aqui
        backButton.setBackground(Color.BLACK); 
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaginaInicial(usuario).setVisible(true);
                dispose(); // Fecha o frame atual (Music)
                musicPlayer.pause();
            }
        });

        List<Musica> musicas = repositorioMusica.getMusicas();
        musicPlayer = new MusicPlayer();

        
     

        // Configuração do painel para exibir as músicas em coluna
        JPanel musicPanel = new JPanel();
        musicPanel.setLayout(new GridLayout(8, 1)); // Usando GridLayout com 1 coluna
        musicPanel.setBackground(Color.black);
        musicPanel.setAlignmentY(Component.CENTER_ALIGNMENT);  // Ou use Component.CENTER_ALIGNMENT
        
       VectorUsuario repositorioUsuario = new VectorUsuario();
        
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
                    repositorioUsuario.desserializarUsuarios();
                    try {
                        usuario.adicionarMusica(musica);
                        repositorioUsuario.atualizarUsuario(usuario);            
            
                        MusicasPlaylist.createAndShowGUI(usuario);

                        dispose();
                    }
                    catch(AdicionarMusicaException ame) {
                        JOptionPane.showMessageDialog(null, ame.getMessage());
                    }
                    
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

    public Musica searchMusic(String searchTerm) {
        for (Musica musica : musicas) {
            if (musica.getNome().equalsIgnoreCase(searchTerm)) {
                return musica;
            }
        }
        return null;
    }

    public void openMusicDetailPage(Musica foundMusic, String filePath) {
        JFrame musicDetailFrame = new JFrame("Detalhes da Música");
        musicDetailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        musicDetailFrame.setSize(400, 200);
        musicDetailFrame.setLocationRelativeTo(null);

        JPanel musicDetailPanel = new JPanel();
        musicDetailPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Nome: " + foundMusic.getNome());
        JLabel artistLabel = new JLabel("Artista: " + foundMusic.getArtista());

        JButton playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(100, 30));
        playButton.setBackground(new Color(173, 216, 230));
        
        playButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    String musicFilePath = filePath + foundMusic.getUrl();
                    if (new File(musicFilePath).exists()) {
                        musicPlayer.play(musicFilePath);
                    } else {
                        System.out.println("Arquivo não encontrado: " + musicFilePath);
                    }
                }
            });

        

        musicDetailPanel.add(nameLabel);
        musicDetailPanel.add(artistLabel);
        musicDetailPanel.add(playButton);

        musicDetailFrame.add(musicDetailPanel);
        musicDetailFrame.setVisible(true);
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
