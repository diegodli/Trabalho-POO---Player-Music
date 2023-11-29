package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Usuario;
import models.UsuarioPremium;
import models.MusicPlayer;
import models.Musica;
import repository.VectorMusica;
import repository.IRepositorioMusica;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class Musicc extends JFrame {

    private Usuario usuario;
    private MusicPlayer musicPlayer;
    private IRepositorioMusica repositorioMusica;

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
        setLocationRelativeTo(null); // Centraliza o frame na tela

        // Configuração do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);
        add(panel);

        // Adiciona o título "Musicas" no topo
        JLabel titleLabel = new JLabel("Musicas");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.PAGE_START);

        JLabel userInfoLabel = new JLabel("Usuário: " + usuario.getUsername() + " (" + tipoUsuario() + ")");
        userInfoLabel.setForeground(Color.WHITE);
        userInfoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(userInfoLabel, BorderLayout.BEFORE_LINE_BEGINS);

        // Configuração do botão de volta à página inicial
        JButton backButton = new JButton("Voltar");
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
        musicPanel.setLayout(new BoxLayout(musicPanel, BoxLayout.Y_AXIS));
        musicPanel.setBackground(Color.DARK_GRAY);

        for (Musica musica : musicas) {
            JButton musicaButton = new JButton(musica.getNome() + " - " + musica.getArtista());

            // Adiciona botões de play e pause ao lado de cada música
            JButton playButton = new JButton("Play");
            JButton pauseButton = new JButton("Pause");
            JButton adicionarButton = new JButton("Adicionar");

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

    public Musicc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String tipoUsuario() {
        if (usuario instanceof UsuarioPremium) return "Premium";
        else return "Comum";
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
