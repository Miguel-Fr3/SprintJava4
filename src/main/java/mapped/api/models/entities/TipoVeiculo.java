package mapped.api.models.entities;

public class TipoVeiculo {

	private Integer cdTpVeic;
    private String dsTipoVeiculo;
    private Integer fgAtivo;

    public TipoVeiculo() {
    }

    public TipoVeiculo(Integer cdTpVeic, String dsTipoVeiculo, Integer fgAtivo) {
        this.cdTpVeic = cdTpVeic;
        this.dsTipoVeiculo = dsTipoVeiculo;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdTpVeic() {
        return cdTpVeic;
    }

    public void setCdTpVeic(Integer cdTpVeic) {
        this.cdTpVeic = cdTpVeic;
    }

    public String getDsTipoVeiculo() {
        return dsTipoVeiculo;
    }

    public void setDsTipoVeiculo(String dsTipoVeiculo) {
        this.dsTipoVeiculo = dsTipoVeiculo;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
