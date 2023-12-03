package repository;

import Exception.UsuarioExistenteException;
import models.Usuario;

public interface IRepositorioUsuario{

    public Usuario buscarUsuario(String username);
    
    /**
     *
     * @param usuario
     * @throws UsuarioExistenteException
     */
    public void cadastrarUsuario(final Usuario usuario);  
}
