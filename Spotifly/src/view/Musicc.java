package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Usuario;
import models.UsuarioPremium;

public class Musicc extends JFrame {
    
    private Usuario usuario;

    public Musicc(Usuario usuario) {
        this.usuario = usuario;
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

        panel.add(backButton, BorderLayout.SOUTH);
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
