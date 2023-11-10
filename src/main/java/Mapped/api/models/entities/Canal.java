package Mapped.api.models.entities;

public class Canal {
	@Id
	private Integer cdCanal;
    private String nmCanal;
    private String dsDescricao;

    public Canal() {
    }

    public Canal(Integer cdCanal, String nmCanal, String dsDescricao) {
        this.nmCanal = nmCanal;
        this.dsDescricao = dsDescricao;
        this.cdCanal = cdCanal;
    }

    public String getNmCanal() {
        return nmCanal;
    }

    public void setNmCanal(String nmCanal) {
        this.nmCanal = nmCanal;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }
}
