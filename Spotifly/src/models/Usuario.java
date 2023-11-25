package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

// Construtor sem argumentos exigido para a serialização
    public Usuario() {
        this("", "");
    }

    // Métodos para controle da serialização
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getUsername());
        out.writeObject(getPassword());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Chama o construtor da classe pai com os valores lidos
        String username = (String) in.readObject();
        String password = (String) in.readObject();
        this.username = username;  
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Método abstrato que pode ser implementado nas subclasses
    public abstract void metodoAbstrato();
}
