package models;

import view.MusicasPlaylist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Musicc;

public class Playlist {
     public static void createAndShowGUI(final Usuario usuario) {
        JFrame frame = new JFrame("Minha Playlist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600); // Ajuste o tamanho conforme necessário

        // Configurar o título
        JLabel titleLabel = new JLabel("Minha Playlist");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(30, 30, 30)); // Cor escura fosca
        titlePanel.add(titleLabel);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);

        // Configurar a seção da imagem
        ImageIcon icon = new ImageIcon("C:\\Users\\c\\Documents\\SpotiflyTestes\\Playlist\\playlist\\music-img.jpg");
        Image image = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH); // Ajuste o tamanho conforme necessário
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);

        // Adicionar ação de redirecionamento para Musica quando clicar na imagem
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Fechar o frame atual
                MusicasPlaylist.createAndShowGUI(usuario); // Correção aqui
            }
        });

        // Adicionar o nome da playlist com posicionamento manual
        JLabel playlistLabel = new JLabel("Minhas Curtidas");
        playlistLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        playlistLabel.setForeground(Color.WHITE);

        JPanel centerPanel = new JPanel(null);
        centerPanel.setBackground(new Color(30, 30, 30));

        // Posicionamento manual dos componentes
        imageLabel.setBounds(140, 50, 200, 300);
        playlistLabel.setBounds(160, 350, 200, 30);

        centerPanel.add(imageLabel);
        centerPanel.add(playlistLabel);

        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Configurar o botão "Adicionar Música"
        JButton addButton = new JButton("Adicionar Música");
        addButton.addActionListener((ActionEvent e) -> {
            frame.dispose(); // Fechar o frame atual (Playlist)
            Musicc musiccPage = new Musicc(usuario);
            musiccPage.setVisible(true); // Tornar a página Musicc visível
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(30, 30, 30)); // Cor escura fosca
        buttonPanel.add(addButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Configurar o frame principal
        frame.getContentPane().setBackground(new Color(0, 0, 0)); // Cor preta fosca
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Playlist() {
    }
}
