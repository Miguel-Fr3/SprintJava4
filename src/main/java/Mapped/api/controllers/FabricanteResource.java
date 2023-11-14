package Mapped.api.controllers;

import Mapped.api.models.entities.Fabricante;
import Mapped.api.models.repositories.FabricanteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/fabricante")
public class FabricanteResource {
    private FabricanteRepository repository = new FabricanteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fabricante> getFabricantes() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFabricante(Fabricante fabricante) throws SQLException {
        repository.add(fabricante);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fabricante getFabricantePorId(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fabricante updateFabricante(@PathParam("id") int id, Fabricante fabricante) throws SQLException {
        if (repository.find(id).isPresent()) {
            fabricante.setCdFabricante(id);
            repository.update(id, fabricante);
            return repository.find(id).orElse(null);
        }
        return fabricante;
    }

    @DELETE
    @Path("{id}")
    public void deleteFabricante(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
}
