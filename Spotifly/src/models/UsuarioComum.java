package models;

import java.io.Serializable;
import models.*;
import repository.*;

public class UsuarioComum extends Usuario implements Serializable {
     private static int numMusicas = 4;
     private static final long serialVersionUID = 1L;


    public UsuarioComum(String username, String password) {
        super(username, password);
    }


    // Implementação específica para usuário comum
    @Override
   public void adicionarMusica(Musica musica){
       if(playlist.tamanho() < numMusicas){
           playlist.adicionar(musica);
       }
   }
}
