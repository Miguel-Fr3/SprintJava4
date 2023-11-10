package Mapped.api.models.entities;

public class Cidade {
    @Id
	private Integer cdCidade;
    private String nmCidade;

    public Cidade() {
    }

    public Cidade(String nmCidade, Integer cdCidade) {
        this.nmCidade = nmCidade;
        this.cdCidade = cdCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }
}
