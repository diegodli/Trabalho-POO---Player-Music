package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Playlist;
import models.Usuario;
import models.UsuarioComum;
import models.UsuarioPremium;


public class PaginaInicial extends JFrame {
    
    private Usuario usuario;

    public PaginaInicial(Usuario usuario) {
        this.usuario = usuario;
       
        setTitle("Spotifly");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        

        // Cria um painel para o cabeçalho
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80)); // Cor de fundo do cabeçalho
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Layout do cabeçalho

        // Adiciona o nome do projeto ao cabeçalho
        JLabel nomeProjetoLabel = new JLabel("Spotifly");
        nomeProjetoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nomeProjetoLabel.setForeground(Color.WHITE);
        headerPanel.add(nomeProjetoLabel);

        // Adiciona o cabeçalho à janela
        add(headerPanel, BorderLayout.NORTH);

        JLabel userInfoLabel = new JLabel("Usuário: " + usuario.getUsername() + " (" + tipoUsuario() + ")");
        userInfoLabel.setForeground(Color.WHITE);
        userInfoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        headerPanel.add(userInfoLabel, BorderLayout.NORTH);
        
        
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                String caminhoImagem = "Spotifly\\src\\Imagem\\img-fundo.jpg";
                Image imagemDeBackground = new ImageIcon(caminhoImagem).getImage();
                g.drawImage(imagemDeBackground, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setLayout(new GridBagLayout()); // Layout para posicionar os botões
        contentPanel.setBackground(Color.WHITE); // Cor de fundo do painel de conteúdo
        
        add(contentPanel, BorderLayout.CENTER);
        
        // Adiciona botões ao painel de conteúdo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Espaçamento entre os botões
        

        JButton musicasButton = criarBotao("Músicas");
        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicc(usuario).setVisible(true);
                dispose(); 
            }
        });
        contentPanel.add(musicasButton, gbc);

        gbc.gridy++;
        JButton playlistButton = criarBotao("Playlist");
        playlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Playlist();
                Playlist.createAndShowGUI(usuario);
                dispose();
            }
        });
        contentPanel.add(playlistButton, gbc);

        gbc.gridy++;
        JButton sairButton = criarBotao("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin().setVisible(true);
                dispose();
            }
        });
        contentPanel.add(sairButton, gbc);
        
        setLocationRelativeTo(null);

        
    }
    
    private String tipoUsuario() {
        if (usuario instanceof UsuarioPremium) return "Premium";
        else return "Comum";
    }


    private JButton criarBotao(String texto) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.PLAIN, 18));
            botao.setBackground(new Color(52, 152, 219)); // Cor de fundo
            botao.setForeground(Color.WHITE); // Cor do texto
            botao.setFocusPainted(false); // Remove a borda de foco
            botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Adiciona espaçamento interno
    
            return botao;
        }



    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }*/
}
