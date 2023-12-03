/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import models.Musica;


public class MusicaJaExisteNaPlaylistException extends AdicionarMusicaException {
    private final Musica musica;

    public MusicaJaExisteNaPlaylistException(Musica musica) {
        super(musica, "A música " + musica.getNome() + " já está na playlist");
    
        this.musica = musica;
    }

    

    @Override
    public Musica getMusica() {
        return this.musica;
    }
}
