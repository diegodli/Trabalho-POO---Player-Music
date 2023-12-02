
package Exception;

import models.Musica;


public abstract class AdicionarMusicaException extends Exception {
    private Musica musica;
    
    public AdicionarMusicaException(Musica musica) {
        super("Não foi possível adicionar a música na playlist!!");
        this.musica = musica;
        
    }
    
    public AdicionarMusicaException(Musica musica, String mensagem) {
        super(mensagem);
        this.musica = musica;
    }
      
    public Musica getMusica() {
        return this.musica;
    }
    
}
