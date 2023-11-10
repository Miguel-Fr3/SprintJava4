package Mapped.api.models.entities;

public class CategoriaVeiculo {
    @Id
	private Integer cdCtVeiculo;
    private String dsCategoriaVeiculo;

    public CategoriaVeiculo() {
    }

    public CategoriaVeiculo(String dsCategoriaVeiculo, Integer cdCtVeiculo) {
        this.dsCategoriaVeiculo = dsCategoriaVeiculo;
        this.cdCtVeiculo = cdCtVeiculo;
    }

    public String getDsCategoriaVeiculo() {
        return dsCategoriaVeiculo;
    }

    public void setDsCategoriaVeiculo(String dsCategoriaVeiculo) {
        this.dsCategoriaVeiculo = dsCategoriaVeiculo;
    }
}
