package Mapped.api.controllers;

import Mapped.api.models.entities.Parceiro;
import Mapped.api.services.ParceiroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/parceiro")
public class ParceiroResource {
    private ParceiroService service = new ParceiroService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parceiro> getParceiros() throws SQLException {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addParceiro(Parceiro parceiro) throws SQLException {
        service.add(parceiro);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Parceiro getParceiroPorId(@PathParam("id") int id) throws SQLException {
        return service.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateParceiro(@PathParam("id") int id, Parceiro parceiro) throws SQLException {
        service.update(id, parceiro);
    }

    @DELETE
    @Path("{id}")
    public void deleteParceiro(@PathParam("id") int id) throws SQLException {
        service.delete(id);
    }
}
