package mapped.api.models.entities;

public class Fabricante {

	private Integer cdFabricante;
    private String nmFabricante;
    private String dsDescricao;
    private Double fgAtivo;

    public Fabricante() {
    }

    public Fabricante(Integer cdFabricante, String nmFabricante, String dsDescricao, Double fgAtivo) {
        this.cdFabricante = cdFabricante;
        this.nmFabricante = nmFabricante;
        this.dsDescricao = dsDescricao;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdFabricante() {
        return cdFabricante;    
    }

    public void setCdFabricante(Integer cdFabricante) {
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
