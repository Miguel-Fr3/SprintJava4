package mapped.api.dtos;

public class LoginDto {
    private long CPF;
    private String senha;

    public LoginDto(long CPF, String senha) {
        this.CPF = CPF;
        this.senha = senha;
    }

    public LoginDto() {
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
