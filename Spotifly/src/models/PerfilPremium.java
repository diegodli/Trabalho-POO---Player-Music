/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import repository.IRepositorioMusica;
/**
 *
 * @author dinow
 */
public class PerfilPremium extends Perfil {
   
    public PerfilPremium (String usuario, IRepositorioMusica playlist) {
        super(usuario, playlist);
    }
    @Override
    public void AdicionarMusica(String nomeDaMusica) {
        playlist.adicionar(nomeDaMusica);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
