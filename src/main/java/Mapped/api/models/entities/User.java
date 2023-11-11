package Mapped.api.models.entities;

public class User {
    @Id
	private Integer cdUser;
    private String user;
    private String nickNome;
    private String cep;
    private String rua;
    private String cidade;
    private String estado;
    private String celular;
    private String cpf;
    private String complemento;
    private String numeroEndereco;
    private String telComercial;
    private String bairro;
    private boolean ativo;

    public User() {
    }

    public User(Integer cdUser, String user, String nickNome, String cep, String rua, String cidade, String estado, String celular, String cpf, String complemento, String numeroEndereco, String telComercial, String bairro, boolean ativo) {
        this.cdUser = cdUser;
        this.user = user;
        this.nickNome = nickNome;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.celular = celular;
        this.cpf = cpf;
        this.complemento = complemento;
        this.numeroEndereco = numeroEndereco;
        this.telComercial = telComercial;
        this.bairro = bairro;
        this.ativo = ativo;
    }

    public Integer getCdUser() {
        return cdUser;
    }

    public void setCdUser(Integer cdUser) {
        this.cdUser = cdUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNickNome() {
        return nickNome;
    }

    public void setNickNome(String nickNome) {
        this.nickNome = nickNome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getTelComercial() {
        return telComercial;
    }

    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
