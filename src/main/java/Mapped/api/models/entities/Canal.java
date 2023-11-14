package mapped.api.models.entities;

public class Canal {

	private Integer cdCanal;
    private String nmCanal;
    private String dsDescricao;

    public Canal() {
    }

    public Canal(Integer cdCanal, String nmCanal, String dsDescricao) {
        this.cdCanal = cdCanal;
        this.nmCanal = nmCanal;
        this.dsDescricao = dsDescricao;
    }

    public Integer getCdCanal() {
        return cdCanal;
    }

    public void setCdCanal(Integer cdCanal) {
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
