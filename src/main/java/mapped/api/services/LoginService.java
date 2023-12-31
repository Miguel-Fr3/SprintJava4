package mapped.api.services;

import mapped.api.models.entities.Login;
import mapped.api.models.repositories.LoginRepository;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService() {
        this.loginRepository = new LoginRepository();
    }

    public boolean login(long CPF, String Senha) throws Exception {
        if (CPF == 0 || Senha == null) throw new IllegalArgumentException("CPF e senha não podem ser nulos.");

        Login login = this.loginRepository.login(CPF);

        return Objects.equals(login.getSenha(), Senha) && Objects.equals(login.getCPF(), CPF);
    }
}
