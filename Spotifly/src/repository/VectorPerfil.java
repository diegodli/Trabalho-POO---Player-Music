package repository;

import java.util.Vector;
import models.*;

public class VectorPerfil implements IRepositorioPerfil{
    private Vector<Perfil> perfis;

    public VectorPerfil(){
        this.perfis = new Vector<Perfil>();
    }

    public void cadastrar(Perfil perfil){
        if(perfis.contains(perfil)){
            //exeção para se aquele perfil já existir aqui
        }
        this.perfis.add(perfil);
    }
    
    public Perfil procurar(Perfil perfil){
        if(perfis.contains(perfil)){
            return perfil;
        }
        return null;
        //exceção para se o perfil não for encontrado
    }
       

}
