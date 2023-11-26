package models;

import java.io.Serializable;
import models.*;

public class UsuarioComum extends Usuario implements Serializable {
    


    public UsuarioComum(String username, String password) {
        super(username, password);
        this.setNumMusicas(4);
    }


    // Implementação específica para usuário comum
    @Override
    public boolean podeAdd() {
        if(this.getPlaylist().tamanho()<numMusicas){
            return true;
        }
        else{
            return false;
        }
    }
}
