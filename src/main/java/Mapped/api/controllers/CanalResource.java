package mapped.api.controllers;

import mapped.api.models.entities.Canal;
import mapped.api.models.repositories.CanalRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/canais")
public class CanalResource {
    private CanalRepository repository = new CanalRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Canal> getCanais() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCanal(Canal canal) throws SQLException {
        repository.add(canal);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Canal getCanalById(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Canal updateCanal(@PathParam("id") int id, Canal canal) throws SQLException {
        if (repository.find(id).isPresent()) {
            canal.setCdCanal(id);
            repository.update(id, canal);
            return repository.find(id).orElse(null);
        }
        return canal;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCanal(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
}
