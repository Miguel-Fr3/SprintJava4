package Mapped.api.models.entities;

public class Login {
    @Id

    private  int id;
    private String CPF;

    private String Senha;


    public Login() {
    }

    public Login(int id, String CPF, String senha) {
        this.id = id;
        this.CPF = CPF;
        Senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
