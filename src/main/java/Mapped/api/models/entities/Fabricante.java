package Mapped.api.models.entities;

public class Fabricante {
    @Id
	private Integer cdFabricante;
    private String nmFabricante;
    private String dsDescricao;
    private Double fgAtivo;

    public Fabricante() {
    }

    public Fabricante(String nmFabricante, String dsDescricao, Double fgAtivo, Integer cdFabricante) {
        this.nmFabricante = nmFabricante;
        this.dsDescricao = dsDescricao;
        this.fgAtivo = fgAtivo;
        this.cdFabricante = cdFabricante;
    }

    public String getNmFabricante() {
        return nmFabricante;
    }

    public void setNmFabricante(String nmFabricante) {
        this.nmFabricante = nmFabricante;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public Double getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Double fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
