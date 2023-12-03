
package Exception;

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
