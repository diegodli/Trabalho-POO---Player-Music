package repository;

import models.Perfil;

public interface IRepositorioPerfil{

    public Perfil procurar(String usuario);

    public void atualizar(Perfil perfil, String novoUsuario);

    public void cadastrar(Perfil perfil) ;
    
}
