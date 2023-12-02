package models;

import java.io.Serializable;
import models.*;
import repository.*;
import Exception.*;

public class UsuarioComum extends Usuario implements Serializable {
     private static int numMusicas = 4;
     private static final long serialVersionUID = 1L;


    public UsuarioComum(String username, String password) {
        super(username, password);
    }


    
    @Override
   public void adicionarMusica(Musica musica) throws AdicionarMusicaException {
       if(playlist.tamanho() < numMusicas){
           playlist.adicionar(musica);
       }
       else throw new LimiteDeMusicasAtingidoException(musica);
   }
}
