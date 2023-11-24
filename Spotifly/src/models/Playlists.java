package models;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

import java.util.HashMap;

import javax.swing.SwingUtilities;

import javax.swing.JFrame;

public class Playlists implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Map<String, Playlist> usuariosPlaylists = new HashMap<>();
    private static DefaultListModel<String> playlistListModel = new DefaultListModel<>();
    private static JList<String> playlistJList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> criarInterfaceLogin());
    }

    private static void criarInterfaceLogin() {
        JFrame frameLogin = new JFrame("Login");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(300, 150);

        JPanel painelLogin = new JPanel();
        JLabel labelUsuario = new JLabel("Nome do Usuário:");
        JTextField campoUsuario = new JTextField(15);
        JButton botaoLogin = new JButton("Login");

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUsuario = campoUsuario.getText();
                if (!nomeUsuario.isEmpty()) {
                    fazerLogin(nomeUsuario);
                    frameLogin.dispose(); // Fechar a tela de login após o login bem-sucedido
                } else {
                    JOptionPane.showMessageDialog(frameLogin, "Por favor, digite um nome de usuário.");
                }
            }
        });

        painelLogin.add(labelUsuario);
        painelLogin.add(campoUsuario);
        painelLogin.add(botaoLogin);

        frameLogin.getContentPane().add(BorderLayout.CENTER, painelLogin);
        frameLogin.setVisible(true);
    }

    private static void criarInterfacePlaylist(String nomeUsuario) {
        JFrame framePlaylist = new JFrame("Sistema de Streaming de Música - " + nomeUsuario);
        framePlaylist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePlaylist.setSize(400, 300);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        JLabel labelTitulo = new JLabel("Suas Playlists");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        painelPrincipal.add(labelTitulo);

        playlistJList = new JList<>(playlistListModel);
        JScrollPane scrollPane = new JScrollPane(playlistJList);
        painelPrincipal.add(scrollPane);

        JButton botaoExcluirPlaylist = new JButton("Excluir Playlist");
        botaoExcluirPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSelecionado = playlistJList.getSelectedIndex();
                if (indiceSelecionado != -1) {
                    Playlist playlistAtual = usuariosPlaylists.get(nomeUsuario);
                    playlistAtual.removerPlaylist(indiceSelecionado);
                    atualizarListaPlaylists(nomeUsuario);
                    salvarPlaylists(nomeUsuario);
                }
            }
        });

        playlistJList.addListSelectionListener(e -> {
            int indiceSelecionado = playlistJList.getSelectedIndex();
            if (indiceSelecionado != -1) {
                Playlist playlistSelecionada = usuariosPlaylists.get(nomeUsuario);
                JOptionPane.showMessageDialog(framePlaylist,
                        "Playlist: " + playlistSelecionada.getNome(indiceSelecionado) +
                                "\nQuantidade de Músicas: " + playlistSelecionada.getQuantidadeMusicas(indiceSelecionado),
                        "Detalhes da Playlist",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoExcluirPlaylist);
        painelPrincipal.add(painelBotoes);

        JButton botaoAdicionarPlaylist = new JButton("Criar Nova Playlist");
        botaoAdicionarPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePlaylist = JOptionPane.showInputDialog(framePlaylist, "Digite o nome da nova playlist:");
                if (nomePlaylist != null && !nomePlaylist.isEmpty()) {
                    Playlist playlist = usuariosPlaylists.get(nomeUsuario);
                    playlist.adicionarPlaylist(nomePlaylist, 0);
                    atualizarListaPlaylists(nomeUsuario);
                    salvarPlaylists(nomeUsuario);
                }
            }
        });

        painelPrincipal.add(botaoAdicionarPlaylist);

        framePlaylist.getContentPane().add(painelPrincipal);
        framePlaylist.setVisible(true);

        framePlaylist.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                salvarPlaylists(nomeUsuario);
            }
        });
    }

    private static void fazerLogin(String nomeUsuario) {
        if (!usuariosPlaylists.containsKey(nomeUsuario)) {
            carregarPlaylists(nomeUsuario);
        }
        SwingUtilities.invokeLater(() -> criarInterfacePlaylist(nomeUsuario));
    }

    private static void adicionarPlaylist(String nomeUsuario, String nomePlaylist, int quantidadeMusicas) {
        Playlist playlist = usuariosPlaylists.get(nomeUsuario);
        playlist.adicionarPlaylist(nomePlaylist, quantidadeMusicas);
        salvarPlaylists(nomeUsuario);
    }

    private static void atualizarListaPlaylists(String nomeUsuario) {
        playlistListModel.clear();
        Playlist playlist = usuariosPlaylists.get(nomeUsuario);
        for (int i = 0; i < playlist.getQuantidadePlaylists(); i++) {
            playlistListModel.addElement(playlist.getNome(i) + " (" + playlist.getQuantidadeMusicas(i) + " músicas)");
        }
    }

    private static void salvarPlaylists(String nomeUsuario) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("playlists_" + nomeUsuario + ".ser"))) {
            outputStream.writeObject(usuariosPlaylists.get(nomeUsuario));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void carregarPlaylists(String nomeUsuario) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playlists_" + nomeUsuario + ".ser"))) {
            Object object = inputStream.readObject();
            if (object instanceof Playlist) {
                usuariosPlaylists.put(nomeUsuario, (Playlist) object);
                atualizarListaPlaylists(nomeUsuario);
            }
        } catch (IOException | ClassNotFoundException e) {
            // Não há playlists salvas ou ocorreu um erro durante a leitura
            usuariosPlaylists.put(nomeUsuario, new Playlist());
        }
    }

    static class Playlist implements Serializable {
        private List<String> nomes;
        private List<Integer> quantidadesMusicas;

        public Playlist() {
            nomes = new ArrayList<>();
            quantidadesMusicas = new ArrayList<>();
        }

        public void adicionarPlaylist(String nome, int quantidadeMusicas) {
            nomes.add(nome);
            quantidadesMusicas.add(quantidadeMusicas);
        }

        public void removerPlaylist(int indice) {
            if (indice >= 0 && indice < nomes.size()) {
                nomes.remove(indice);
                quantidadesMusicas.remove(indice);
            }
        }

        public String getNome(int indice) {
            return nomes.get(indice);
        }

        public int getQuantidadeMusicas(int indice) {
            return quantidadesMusicas.get(indice);
        }

        public int getQuantidadePlaylists() {
            return nomes.size();
        }
    }
}
