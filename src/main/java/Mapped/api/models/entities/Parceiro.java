package Mapped.api.models.entities;

public class Parceiro {
    @Id
	private Integer cdParceiro;
    private String nmParceiro;
    private double nrCep;
    private String nmRua;
    private String nmCidade;
    private String nmEstado;
    private String dsComplemento;
    private double nrCpf;
    private double dsNumeroEndereco;
    private double fgAtivo;

    public Parceiro() {
    }

    public Parceiro(Integer cdParceiro, String nmParceiro, double nrCep, String nmRua, String nmCidade, String nmEstado, String dsComplemento, double nrCpf, double dsNumeroEndereco, double fgAtivo) {
        this.cdParceiro = cdParceiro;
        this.nmParceiro = nmParceiro;
        this.nrCep = nrCep;
        this.nmRua = nmRua;
        this.nmCidade = nmCidade;
        this.nmEstado = nmEstado;
        this.dsComplemento = dsComplemento;
        this.nrCpf = nrCpf;
        this.dsNumeroEndereco = dsNumeroEndereco;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdParceiro() {
        return cdParceiro;
    }

    public void setCdParceiro(Integer cdParceiro) {
        this.cdParceiro = cdParceiro;
    }

    public String getNmParceiro() {
        return nmParceiro;
    }

    public void setNmParceiro(String nmParceiro) {
        this.nmParceiro = nmParceiro;
    }

    public double getNrCep() {
        return nrCep;
    }

    public void setNrCep(double nrCep) {
        this.nrCep = nrCep;
    }

    public String getNmRua() {
        return nmRua;
    }

    public void setNmRua(String nmRua) {
        this.nmRua = nmRua;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public double getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(double nrCpf) {
        this.nrCpf = nrCpf;
    }

    public double getDsNumeroEndereco() {
        return dsNumeroEndereco;
    }

    public void setDsNumeroEndereco(double dsNumeroEndereco) {
        this.dsNumeroEndereco = dsNumeroEndereco;
    }

    public double getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(double fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
