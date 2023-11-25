package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UsuarioComum extends Usuario implements Serializable {

    private String username;
    private String password;

    public UsuarioComum(String username, String password) {
        super(username, password);
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


    // Implementação específica para usuário comum
    @Override
    public void metodoAbstrato() {
        // Implementação específica para usuário comum, se necessário
    }
}
