package repository;

import models.Perfil;

public interface IRepositorioPerfil{

    public Perfil procurar(Perfil perfil);
    
    public void cadastrar(Perfil perfil) ;  
}
