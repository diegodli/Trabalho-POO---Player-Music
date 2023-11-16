package repository;

import java.util.Vector;
import Spotifly.src.models.*;

public class VectorPerfil implements IRepositorio{
    private Vector<Perfil> perfis;

    public VectorPerfil(){
        this.perfis = new Vector<Perifl>();
    }

    public void cadastrar(Perfil perfil){
        if(this.existe(perfil.getUsuario())){
            //exeção para se aquele nome de usurario já existir aqui
        }
        this.perfis.add(perfil);
    }
    
    public Perfil buscar(String usuario){
        for(Perfil perfil : this.perfis){
            if(perfil.getUsuario().equals(usuario)){
                return perfil;
            }
        } 
        return null;
    }

    public void atualizar(Perfil perfil, String novoUsuario){
        if(perfil.getUsuario().equals(usuario)){
            email = perfil.getEmail();
            playlists = perfil.getPlaylists();
            usuario = novoUsuario;
        } else {
            //exceção para se o usuario não existir aqui
        }
    }

}
