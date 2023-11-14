package mapped.api.models.entities;
import java.util.Date;
import java.time.LocalTime;

public class OrdemServico {

	private Integer cdOs;
    private String sgTipo;
    private double nrCnpjCpf;
    private double nrRgInscEstadual;
    private String dsEmailCliente;
    private String nmContatoCliente;
    private double nrTelComercial;
    private String nmModelo;
    private Date dtAgendamento;
    private double nrAnoFabricacao;
    private double fgAtivo;
    private LocalTime hrAgendamento;
    private String nmParceiro;
    private String dsChassi;

    public OrdemServico() {
    }

    public OrdemServico(Integer cdOs, String sgTipo, double nrCnpjCpf, double nrRgInscEstadual, String dsEmailCliente, String nmContatoCliente, double nrTelComercial, String nmModelo, Date dtAgendamento, double nrAnoFabricacao, double fgAtivo, LocalTime hrAgendamento, String nmParceiro, String dsChassi) {
        this.cdOs = cdOs;
        this.sgTipo = sgTipo;
        this.nrCnpjCpf = nrCnpjCpf;
        this.nrRgInscEstadual = nrRgInscEstadual;
        this.dsEmailCliente = dsEmailCliente;
        this.nmContatoCliente = nmContatoCliente;
        this.nrTelComercial = nrTelComercial;
        this.nmModelo = nmModelo;
        this.dtAgendamento = dtAgendamento;
        this.nrAnoFabricacao = nrAnoFabricacao;
        this.fgAtivo = fgAtivo;
        this.hrAgendamento = hrAgendamento;
        this.nmParceiro = nmParceiro;
        this.dsChassi = dsChassi;
    }

    public Integer getCdOs() {
        return cdOs;
    }

    public void setCdOs(Integer cdOs) {
        this.cdOs = cdOs;
    }

    public String getSgTipo() {
        return sgTipo;
    }

    public void setSgTipo(String sgTipo) {
        this.sgTipo = sgTipo;
    }

    public double getNrCnpjCpf() {
        return nrCnpjCpf;
    }

    public void setNrCnpjCpf(double nrCnpjCpf) {
        this.nrCnpjCpf = nrCnpjCpf;
    }

    public double getNrRgInscEstadual() {
        return nrRgInscEstadual;
    }

    public void setNrRgInscEstadual(double nrRgInscEstadual) {
        this.nrRgInscEstadual = nrRgInscEstadual;
    }

    public String getDsEmailCliente() {
        return dsEmailCliente;
    }

    public void setDsEmailCliente(String dsEmailCliente) {
        this.dsEmailCliente = dsEmailCliente;
    }

    public String getNmContatoCliente() {
        return nmContatoCliente;
    }

    public void setNmContatoCliente(String nmContatoCliente) {
        this.nmContatoCliente = nmContatoCliente;
    }

    public double getNrTelComercial() {
        return nrTelComercial;
    }

    public void setNrTelComercial(double nrTelComercial) {
        this.nrTelComercial = nrTelComercial;
    }

    public String getNmModelo() {
        return nmModelo;
    }

    public void setNmModelo(String nmModelo) {
        this.nmModelo = nmModelo;
    }

    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public double getNrAnoFabricacao() {
        return nrAnoFabricacao;
    }

    public void setNrAnoFabricacao(double nrAnoFabricacao) {
        this.nrAnoFabricacao = nrAnoFabricacao;
    }

    public double getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(double fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    public LocalTime getHrAgendamento() {
        return hrAgendamento;
    }

    public void setHrAgendamento(LocalTime hrAgendamento) {
        this.hrAgendamento = hrAgendamento;
    }

    public String getNmParceiro() {
        return nmParceiro;
    }

    public void setNmParceiro(String nmParceiro) {
        this.nmParceiro = nmParceiro;
    }

    public String getDsChassi() {
        return dsChassi;
    }

    public void setDsChassi(String dsChassi) {
        this.dsChassi = dsChassi;
    }
}
