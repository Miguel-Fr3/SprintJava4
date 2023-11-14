package mapped.api.models.entities;

public class Cidade {

	private Integer cdCidade;
    private String nmCidade;

    public Cidade() {
    }

    public Cidade(Integer cdCidade, String nmCidade) {
        this.cdCidade = cdCidade;
        this.nmCidade = nmCidade;
    }

    public Integer getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(Integer cdCidade) {
        this.cdCidade = cdCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }
}
