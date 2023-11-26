package repository;

import models.Usuario;

public interface IRepositorioUsuario{

    public Usuario buscarUsuario(String username);
    
    public void cadastrarUsuario(Usuario usuario);  
}
