package mapped.api.models.entities;

public class Cliente {

	private Integer cdCliente;
    private String sgTipo;
    private Integer nrDocumento;
    private Integer nrInscEstadual;
    private String dsEmailCliente;
    private Long nrCelular;
    private Integer fgAtivo;
    private String nmContatoCliente;
    private Long nrTelComercial;

    public Cliente() {
    }

    public Cliente(Integer cdCliente, String sgTipo, Integer nrDocumento, Integer nrInscEstadual, String dsEmailCliente, Long nrCelular, Integer fgAtivo, String nmContatoCliente, Long nrTelComercial) {
        this.cdCliente = cdCliente;
        this.sgTipo = sgTipo;
        this.nrDocumento = nrDocumento;
        this.nrInscEstadual = nrInscEstadual;
        this.dsEmailCliente = dsEmailCliente;
        this.nrCelular = nrCelular;
        this.fgAtivo = fgAtivo;
        this.nmContatoCliente = nmContatoCliente;
        this.nrTelComercial = nrTelComercial;
    }

    public Integer getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(Integer cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getSgTipo() {
        return sgTipo;
    }

    public void setSgTipo(String sgTipo) {
        this.sgTipo = sgTipo;
    }

    public Integer getNrDocumento() {
        return nrDocumento;
    }

    public void setNrDocumento(Integer nrDocumento) {
        this.nrDocumento = nrDocumento;
    }

    public Integer getNrInscEstadual() {
        return nrInscEstadual;
    }

    public void setNrInscEstadual(Integer nrInscEstadual) {
        this.nrInscEstadual = nrInscEstadual;
    }

    public String getDsEmailCliente() {
        return dsEmailCliente;
    }

    public void setDsEmailCliente(String dsEmailCliente) {
        this.dsEmailCliente = dsEmailCliente;
    }

    public Long getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(Long nrCelular) {
        this.nrCelular = nrCelular;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    public String getNmContatoCliente() {
        return nmContatoCliente;
    }

    public void setNmContatoCliente(String nmContatoCliente) {
        this.nmContatoCliente = nmContatoCliente;
    }

    public Long getNrTelComercial() {
        return nrTelComercial;
    }

    public void setNrTelComercial(Long nrTelComercial) {
        this.nrTelComercial = nrTelComercial;
    }
}
