package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Musicc extends JFrame {

    public Musicc() {
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
        panel.add(titleLabel, BorderLayout.NORTH);

        // Configuração do botão de volta à página inicial no canto superior direito
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaginaInicial().setVisible(true);
                dispose(); // Fecha o frame atual (Music)
            }
        });

        panel.add(backButton, BorderLayout.PAGE_START);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Musicc().setVisible(true);
            }
        });
    }
}
