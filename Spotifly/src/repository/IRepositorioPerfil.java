package repository;

import models.Perfil;

public interface IRepositorioPerfil{

    public Perfil procurar(String usuario);
    
      public void cadastrar(Perfil perfil) ;
      
      public boolean existe(Perfil perfil);
      
}
