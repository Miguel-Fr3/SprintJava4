package Mapped.api.models.entities;

public class Perfil {
    @Id
	private Integer cdPerfil;
    private String Perfil;
    private String Nome;

    public Perfil() {
    }

    public Perfil(Integer cdPerfil, String perfil, String nome) {
        this.cdPerfil = cdPerfil;
        Perfil = perfil;
        Nome = nome;
    }

    public Integer getCdPerfil() {
        return cdPerfil;
    }

    public void setCdPerfil(Integer cdPerfil) {
        this.cdPerfil = cdPerfil;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String perfil) {
        Perfil = perfil;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
