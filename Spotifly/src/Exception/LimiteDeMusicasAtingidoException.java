/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import models.Musica;


public class LimiteDeMusicasAtingidoException extends AdicionarMusicaException {
    
    private Musica musica;

    public LimiteDeMusicasAtingidoException (Musica musica) {
        super(musica, "Limite de Músicas Atingido no Plano Comum");
        
        this.musica = musica;
    }

    public Musica getMusica() {
        return this.musica;
    }
}