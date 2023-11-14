package mapped.api.models.entities;

public class CategoriaVeiculo {

	private Integer cdCtVeiculo;
    private String dsCategoriaVeiculo;

    public CategoriaVeiculo() {
    }

    public CategoriaVeiculo(Integer cdCtVeiculo, String dsCategoriaVeiculo) {
        this.cdCtVeiculo = cdCtVeiculo;
        this.dsCategoriaVeiculo = dsCategoriaVeiculo;
    }

    public Integer getCdCtVeiculo() {
        return cdCtVeiculo;
    }

    public void setCdCtVeiculo(Integer cdCtVeiculo) {
        this.cdCtVeiculo = cdCtVeiculo;
    }

    public String getDsCategoriaVeiculo() {
        return dsCategoriaVeiculo;
    }

    public void setDsCategoriaVeiculo(String dsCategoriaVeiculo) {
        this.dsCategoriaVeiculo = dsCategoriaVeiculo;
    }
}
