/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author dinow
 */
public class UsuarioExistenteException extends Exception {
    
    private final String username;
    
    public UsuarioExistenteException(String username) {
        super("Nome de usuário já cadastrado");
        this.username = username;
    }
    
    public String getUsername () {
        return this.username;
    }
    
}
