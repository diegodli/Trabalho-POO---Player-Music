package repository;

import Exception.UsuarioExistenteException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class VectorUsuario implements Serializable, IRepositorioUsuario {

    private List<Usuario> usuarios;
    private final String filePath = "usuarios.ser";

    public VectorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(final Usuario usuario) {
        if (!existe(usuario.getUsername())) {
            usuarios.add(usuario);
            serializarUsuarios();
        }   
        
    }
    
    public void removerUsuario(final Usuario usuario){
        usuarios.remove(usuario);
        serializarUsuarios();
    }
    
    public void atualizarUsuario(Usuario usuarioAtt){
        Usuario usuarioBusca = buscarUsuario(usuarioAtt.getUsername());
        if(usuarioBusca != null){
            for(Usuario usuario : usuarios){
                if(usuarioBusca == usuario){
                    usuario.setPlaylist(usuarioAtt.getPlaylist());
                    serializarUsuarios();
                    break;
                }
             
            }
        }
            
        
    }
    

    public Usuario buscarUsuario(final String username) {
        for (final Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }
    
    public boolean existe (final String username) {
        return (buscarUsuario(username) != null);
    }
    

    public void exibirUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (final Usuario usuario : usuarios) {
            System.out.println("Username: " + usuario.getUsername() + ", Password: " + usuario.getPassword());
        }
    }

    public void serializarUsuarios() {
    File file = new File(filePath);
    if (file.exists()) {
        file.delete();
    }
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
        out.writeObject(usuarios);
    } catch (final IOException e) {
        e.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    public void desserializarUsuarios() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            final Object obj = in.readObject();
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
