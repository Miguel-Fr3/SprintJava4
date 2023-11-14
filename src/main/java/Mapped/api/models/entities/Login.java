package Mapped.api.models.entities;

public class Login {

    private int id;
    private long CPF;
    private String Senha;

    public Login() {
    }

    public Login(int id, long CPF, String senha) {
        this.id = id;
        this.CPF = CPF;
        this.Senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
