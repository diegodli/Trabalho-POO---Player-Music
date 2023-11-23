package repository;

import java.util.Vector;
import models.*;

public class VectorPerfil implements IRepositorioPerfil{
    private Vector<Perfil> perfis;

    public VectorPerfil(){
        this.perfis = new Vector<Perfil>();
    }

    public void cadastrar(Perfil perfil){
        if(this.existe(perfil.getUsuario())){
            //exeção para se aquele nome de usuario já existir aqui
        }
        this.perfis.add(perfil);
    }
    
    public Perfil procurar(String usuario){
        for(Perfil perfil : this.perfis){
            if(perfil.getUsuario().equals(usuario)){
                return perfil;
            }
            else{
                //exceção para se o nome de usuario não existir
            }
        } 
        return null;
    }
}
