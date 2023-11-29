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
        // Configurações do frame
        setTitle("Spotifly");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centraliza o frame na tela
        
        // Configuração do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);
        add(panel);

        // Adiciona o nome do projeto no topo
        JLabel projectNameLabel = new JLabel("Spotifly");
        projectNameLabel.setForeground(Color.WHITE);
        projectNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        projectNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(projectNameLabel, BorderLayout.NORTH);
        
        // Add the label to display user information in the top-right corner
        JLabel userInfoLabel = new JLabel("Usuário: " + usuario.getUsername() + " (" + tipoUsuario() + ")");
        userInfoLabel.setForeground(Color.WHITE);
        userInfoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(userInfoLabel, BorderLayout.NORTH);


        // Configuração do painel dividido em dois
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(200); // Ajusta a localização do divisor
        splitPane.setResizeWeight(0.5); // Ajusta a largura inicial
        splitPane.setContinuousLayout(true);
        panel.add(splitPane, BorderLayout.CENTER);

        // Configuração do painel da esquerda com opções de músicas e playlist
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.DARK_GRAY);

        JButton musicasButton = new JButton("Músicas");
        JButton playlistButton = new JButton("Playlist");
        JButton sair = new JButton("Sair");

        // Adiciona ação aos botões (substitua com suas ações reais)
        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicc(usuario).setVisible(true);
                dispose(); // Fecha o frame atual (Pagina_inicial)
            }
        });

        playlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new Playlist().createAndShowGUI();
        dispose();
                // Adicione a lógica para exibir o frame de playlist
                // Exemplo: new PlaylistFrame().setVisible(true);
            }
        });
        
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin().setVisible(true);
                dispose();
            }
        });

        leftPanel.add(musicasButton);
        leftPanel.add(playlistButton);
        leftPanel.add(sair);

        splitPane.setLeftComponent(leftPanel);

        // Configuração do painel da direita com cards de artistas (exemplo)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.DARK_GRAY);
        // Adicione os cards de artistas ou outras informações aqui

        splitPane.setRightComponent(rightPanel);
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
}
