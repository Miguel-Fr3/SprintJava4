package Mapped.api.controllers;

import Mapped.api.models.entities.Login;
import Mapped.api.models.repositories.LoginRepository;
import Mapped.api.services.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.sql.SQLException;
import java.util.List;



@Path("/login")
public class LoginResource {
    private LoginRepository repository = new LoginRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Login> getLogin() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLogin(Login login) throws SQLException {
        System.out.println(login.getSenha());
        repository.add(login);
    }

    @POST
    @Path("/autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void login(@FormParam("CPF") String CPF, @FormParam("Senha") String Senha) throws Exception {
        LoginService loginService = new LoginService();
        loginService.login(CPF, Senha);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Login getLoginPorId(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Login updateLogin(@PathParam("id") int id, Login login) throws SQLException {
        if (repository.find(id).isPresent()) {
            login.setId(id);
            repository.update(login);
            return repository.find(id).orElse(null);
        }
        return login;
    }

    @DELETE
    @Path("{id}")
    public void deleteLogin(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
    @OPTIONS
    public Response options() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }
}
