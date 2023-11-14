package mapped.api.models.entities;

public class MotoristaParceiro {

	private Integer cdMotorista;
    private String nmMotorista;
    private Integer nrCep;
    private String nmRua;
    private String nmCidade;
    private String nmEstado;
    private String dsComplemento;
    private Integer nrCpf;
    private Integer dsNumeroEndereco;
    private Integer fgAtivo;

    public MotoristaParceiro() {
    }

    public MotoristaParceiro(Integer cdMotorista, String nmMotorista, Integer nrCep, String nmRua, String nmCidade, String nmEstado, String dsComplemento, Integer nrCpf, Integer dsNumeroEndereco, Integer fgAtivo) {
        this.cdMotorista = cdMotorista;
        this.nmMotorista = nmMotorista;
        this.nrCep = nrCep;
        this.nmRua = nmRua;
        this.nmCidade = nmCidade;
        this.nmEstado = nmEstado;
        this.dsComplemento = dsComplemento;
        this.nrCpf = nrCpf;
        this.dsNumeroEndereco = dsNumeroEndereco;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdMotorista() {
        return cdMotorista;
    }

    public void setCdMotorista(Integer cdMotorista) {
        this.cdMotorista = cdMotorista;
    }

    public String getNmMotorista() {
        return nmMotorista;
    }

    public void setNmMotorista(String nmMotorista) {
        this.nmMotorista = nmMotorista;
    }

    public Integer getNrCep() {
        return nrCep;
    }

    public void setNrCep(Integer nrCep) {
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

    public Integer getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(Integer nrCpf) {
        this.nrCpf = nrCpf;
    }

    public Integer getDsNumeroEndereco() {
        return dsNumeroEndereco;
    }

    public void setDsNumeroEndereco(Integer dsNumeroEndereco) {
        this.dsNumeroEndereco = dsNumeroEndereco;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
