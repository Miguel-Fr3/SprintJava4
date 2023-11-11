package Mapped.api.models.entities;

public class Login {


    private  int id;
    private int CPF;
    private String Senha;


    public Login() {
    }

    public Login(int id, int CPF, String senha) {
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

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
