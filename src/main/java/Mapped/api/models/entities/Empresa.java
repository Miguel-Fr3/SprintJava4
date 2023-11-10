package Mapped.api.models.entities;

public class Empresa {
    @Id
	private Integer cdEmpresa;
    private String nmEmpresa;
    private Long nrNumero;
    private String nmRua;
    private String dsComplemento;
    private String nmBairro;
    private String nmCidade;
    private String sgEstado;
    private Long nrCep;
    private Long nrDddContato;
    private String dsEmailContato;
    private Long nrCnpj;
    private String dsRazaoSocial;

    public Empresa() {
    }

    public Empresa(String nmEmpresa, Long nrNumero, String nmRua, String dsComplemento, String nmBairro, String nmCidade,
            String sgEstado, Long nrCep, Long nrDddContato, String dsEmailContato, Long nrCnpj, String dsRazaoSocial, Integer cdEmpresa) {
        this.nmEmpresa = nmEmpresa;
        this.nrNumero = nrNumero;
        this.nmRua = nmRua;
        this.nmBairro = nmBairro;
        this.nmCidade = nmCidade;
        this.sgEstado = sgEstado;
        this.nrCep = nrCep;
        this.nrDddContato = nrDddContato;
        this.dsEmailContato = dsEmailContato;
        this.dsComplemento = dsComplemento;
        this.nrCnpj = nrCnpj;
        this.dsRazaoSocial = dsRazaoSocial;
        this.cdEmpresa = cdEmpresa;
    }

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public Long getNrNumero() {
        return nrNumero;
    }

    public void setNrNumero(Long nrNumero) {
        this.nrNumero = nrNumero;
    }

    public String getNmRua() {
        return nmRua;
    }

    public void setNmRua(String nmRua) {
        this.nmRua = nmRua;
    }

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public String getSgEstado() {
        return sgEstado;
    }

    public void setSgEstado(String sgEstado) {
        this.sgEstado = sgEstado;
    }

    public Long getNrCep() {
        return nrCep;
    }

    public void setNrCep(Long nrCep) {
        this.nrCep = nrCep;
    }

    public Long getNrDddContato() {
        return nrDddContato;
    }

    public void setNrDddContato(Long nrDddContato) {
        this.nrDddContato = nrDddContato;
    }

    public String getDsEmailContato() {
        return dsEmailContato;
    }

    public void setDsEmailContato(String dsEmailContato) {
        this.dsEmailContato = dsEmailContato;
    }

    public Long getNrCnpj() {
        return nrCnpj;
    }

    public void setNrCnpj(Long nrCnpj) {
        this.nrCnpj = nrCnpj;
    }

    public String getDsRazaoSocial() {
        return dsRazaoSocial;
    }

    public void setDsRazaoSocial(String dsRazaoSocial) {
        this.dsRazaoSocial = dsRazaoSocial;
    }
}
