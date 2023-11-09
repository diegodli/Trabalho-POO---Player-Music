package models;
// import IRepositorioMusica
public abstract class Perfil {
    private String nomeDoPerfil;
    private String email;
    private IRepositorioMusica playlists;
    
    public Perfil (String nomeDoPerfil, String email, IRepositorioMusica playlists) {
        this.nomeDoPerfil = nomeDoPerfil;
        this.email = email;
        this.playlists = playlists;
    }
    
    public abstract void CriarPlaylist(String nomePlaylist);
    
    public String getNomeDoPerfil() {
        return nomeDoPerfil;
    }
    public void setNomeDoPerfil(String nomeDoPerfil) {
        this.nomeDoPerfil = nomeDoPerfil;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}