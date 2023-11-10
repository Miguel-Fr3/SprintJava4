package Mapped.api.models.entities;

public class Perfil {
    @Id
	private Integer cdPerfil;
    private String Perfil;
    private String Nome;

    public Perfil() {
    }

    public Perfil(String Perfil, String Nome, Integer cdPerfil) {
        this.Perfil = Perfil;
        this.Nome = Nome;
        this.cdPerfil = cdPerfil;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
