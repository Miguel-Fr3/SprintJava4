package Mapped.api.models.entities;

public class TipoVeiculo {
    @Id
	private Integer cdTpVeic;
    private String dsTipoVeiculo;
    private Integer fgAtivo;

    public TipoVeiculo() {
    }

    public TipoVeiculo(String dsTipoVeiculo, Integer fgAtivo, Integer cdTpVeic) {
        this.dsTipoVeiculo = dsTipoVeiculo;
        this.fgAtivo = fgAtivo;
        this.cdTpVeic = cdTpVeic;
    }
}
