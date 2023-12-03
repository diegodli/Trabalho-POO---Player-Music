package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Playlist;


public class PrimeiraTela extends JFrame {
    

    public PrimeiraTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centraliza a janela
        
        

        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Adicione aqui o código para carregar a imagem de background
                // Exemplo:
                String caminhoImagem = "src\\Imagem\\img-fundo.jpg"; // Substitua pelo caminho real da sua imagem
                Image imagemDeBackground = new ImageIcon(caminhoImagem).getImage();
                g.drawImage(imagemDeBackground, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setLayout(new GridBagLayout()); // Layout para posicionar os botões
        contentPanel.setBackground(Color.WHITE); // Cor de fundo do painel de conteúdo
        // Adiciona o painel de conteúdo à janela
        add(contentPanel, BorderLayout.CENTER);
        
        // Adiciona botões ao painel de conteúdo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Espaçamento entre os botões
        

        JButton loginButton = criarBotao("LOG IN");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new TelaLogin().setVisible(true);
                    }
                });
                dispose(); // Fecha o frame atual (Pagina_inicial)
            }
        });
        contentPanel.add(loginButton, gbc);

        gbc.gridy++;
    

        gbc.gridy++;
        JButton criarContaButton = criarBotao("SIGN UP");
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new TelaCriarConta().setVisible(true);
                    }
                });
                dispose();
            }
        });
        contentPanel.add(criarContaButton, gbc);

        
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



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrimeiraTela().setVisible(true);
            }
        });
    }
}
