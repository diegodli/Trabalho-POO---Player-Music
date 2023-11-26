package models;

import java.io.Serializable;


public class UsuarioPremium extends Usuario implements Serializable{

    /*private String username;
    private String password;*/

    public UsuarioPremium(String username, String password) {
        super(username, password);
    }

    // Implementação específica para usuário premium
    @Override
    public boolean podeAdd() {
       return true;
    }
}
