package repository;

import models.Usuario;

public interface IRepositorioPerfil{

    public Usuario procurar(Usuario perfil);
    
    public void cadastrar(Usuario perfil);  
}
