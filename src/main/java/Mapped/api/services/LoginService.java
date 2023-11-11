package Mapped.api.services;

import Mapped.api.models.entities.Login;
import Mapped.api.models.repositories.LoginRepository;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService () {
        this.loginRepository = new LoginRepository();
    }

    public boolean login (String CPF, String Senha) throws Exception {
        if (CPF == null || Senha == null) throw new IllegalArgumentException("CPF e senha não podem ser nulos.");

        Login login = this.loginRepository.login(CPF);

        if (Objects.equals(login.getSenha(), Senha) && Objects.equals(login.getCPF(), CPF)) {
            return true;
        } else {
            return false;
        }
    }
}
