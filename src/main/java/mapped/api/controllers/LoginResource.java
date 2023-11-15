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
        String cpf = String.valueOf(login.getCPF());


        if (cpf.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("O campo CPF não pode estar vazio.")
                    .build();
        }


        try {
            long cpfNumber = Long.parseLong(cpf);

            LoginService loginService = new LoginService();
            boolean result =  loginService.login(Long.parseLong(cpf), login.getSenha());
            LoginRetornoDto response = new LoginRetornoDto(result);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (NumberFormatException e) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Formato de CPF inválido.")
                    .build();
        }
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