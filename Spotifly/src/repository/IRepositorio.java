package repository;

import models.*;

public interface IRepositorio {

    public Musica buscar(String musica);

    public Perfil procurar(String usuario);

    public void atualizar(Perfil perfil, String novoUsuario);

    public void cadastrar(Perfil perfil) ;
    
}
