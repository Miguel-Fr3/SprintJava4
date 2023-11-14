package mapped.api.controllers;

import mapped.api.models.entities.Logradouro;
import mapped.api.models.repositories.LogradouroRepository;
import mapped.api.services.LogradouroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/logradouro")
public class LogradouroResource {
    private LogradouroService service = new LogradouroService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logradouro> getLogradouros() throws SQLException {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLogradouro(Logradouro logradouro) throws SQLException {
        service.add(logradouro);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Logradouro getLogradouroPorId(@PathParam("id") int id) throws SQLException {
        return service.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateLogradouro(@PathParam("id") int id, Logradouro logradouro) throws SQLException {
        logradouro.setCdLogradouro(id);
        service.update(logradouro);
    }

    @DELETE
    @Path("{id}")
    public void deleteLogradouro(@PathParam("id") int id) throws SQLException {
        service.delete(id);
    }
}
