package models;

import Exception.*;
import java.io.Serializable;


public class UsuarioPremium extends Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    public UsuarioPremium(String username, String password) {
        super(username, password);
    }

 
    @Override
    public void adicionarMusica(Musica musica) throws AdicionarMusicaException {
        playlist.adicionar(musica);
    }
}
