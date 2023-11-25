package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class VectorUsuario implements Serializable {

    private List<Usuario> usuarios;

    public VectorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        serializarUsuarios(); // Adiciona serialização após cada cadastro
    }

    public Usuario buscarUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    public void exibirUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("Username: " + usuario.getUsername() + ", Password: " + usuario.getPassword());
        }
    }

    private void serializarUsuarios() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.ser"))) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void desserializarUsuarios() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.ser"))) {
            Object obj = in.readObject();
            if (obj instanceof List<?>) {
                usuarios = (List<Usuario>) obj;
                System.out.println("Desserialização concluída. Usuários:");
                exibirUsuarios(); // Adiciona a exibição após a desserialização
            } else {
                System.out.println("Erro: Objeto lido não é uma instância de List<Usuario>.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar usuários: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
