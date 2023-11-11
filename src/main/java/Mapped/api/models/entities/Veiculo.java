package Mapped.api.models.entities;

public class Veiculo {
    @Id
	private Integer cdVeiculo;
    private String nmModelo;
    private String dsPlaca;
    private String dsChassi;
    private int nrAnoFabricacao;
    private String nmCorVeiculo;
    private boolean fgAtivo;

    public Veiculo() {
    }

    public Veiculo(Integer cdVeiculo, String nmModelo, String dsPlaca, String dsChassi, int nrAnoFabricacao, String nmCorVeiculo, boolean fgAtivo) {
        this.cdVeiculo = cdVeiculo;
        this.nmModelo = nmModelo;
        this.dsPlaca = dsPlaca;
        this.dsChassi = dsChassi;
        this.nrAnoFabricacao = nrAnoFabricacao;
        this.nmCorVeiculo = nmCorVeiculo;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdVeiculo() {
        return cdVeiculo;
    }

    public void setCdVeiculo(Integer cdVeiculo) {
        this.cdVeiculo = cdVeiculo;
    }

    public String getNmModelo() {
        return nmModelo;
    }

    public void setNmModelo(String nmModelo) {
        this.nmModelo = nmModelo;
    }

    public String getDsPlaca() {
        return dsPlaca;
    }

    public void setDsPlaca(String dsPlaca) {
        this.dsPlaca = dsPlaca;
    }

    public String getDsChassi() {
        return dsChassi;
    }

    public void setDsChassi(String dsChassi) {
        this.dsChassi = dsChassi;
    }

    public int getNrAnoFabricacao() {
        return nrAnoFabricacao;
    }

    public void setNrAnoFabricacao(int nrAnoFabricacao) {
        this.nrAnoFabricacao = nrAnoFabricacao;
    }

    public String getNmCorVeiculo() {
        return nmCorVeiculo;
    }

    public void setNmCorVeiculo(String nmCorVeiculo) {
        this.nmCorVeiculo = nmCorVeiculo;
    }

    public boolean isFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
