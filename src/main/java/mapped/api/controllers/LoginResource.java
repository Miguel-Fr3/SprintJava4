package mapped.api.controllers;

import jakarta.ws.rs.core.Response;
import mapped.api.dtos.LoginDto;
import mapped.api.dtos.LoginRetornoDto;
import mapped.api.models.entities.Login;
import mapped.api.models.repositories.LoginRepository;
import mapped.api.services.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


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

    @GET
    @Path("/autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Login> getLoginAut() throws SQLException {
        return repository.findAll();
    }
    @POST
    @Path("/autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDto login) throws Exception {
        LoginService loginService = new LoginService();
        System.out.println(login.getCPF());
        System.out.println(login.getSenha());
        boolean result =  loginService.login(login.getCPF(), login.getSenha());
        System.out.println(result);
        LoginRetornoDto response = new LoginRetornoDto(result);

        return Response.status(Response.Status.OK).entity(response).build();
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

}