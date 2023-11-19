package models;

import models.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Musica {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Músicas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Configurar o título
        JLabel titleLabel = new JLabel("Músicas");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(30, 30, 30)); // Cor escura fosca
        titlePanel.add(titleLabel);
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);

        // Adicionar músicas do usuário (trabalharemos mais adiante nesta parte)

        // Adicionar botão de voltar para Playlist no canto superior direito
        JButton backButton = new JButton("Voltar para Playlist");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fechar o frame atual
                Playlist.main(new String[0]); // Voltar para a classe Playlist
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.add(backButton);
        titlePanel.add(buttonPanel, BorderLayout.EAST); // Adicionando o botão ao painel de título

        // Adicionar cor cinza ao fundo abaixo do título
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Configurar o frame principal
        frame.getContentPane().setBackground(new Color(0, 0, 0)); // Cor preta fosca
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
