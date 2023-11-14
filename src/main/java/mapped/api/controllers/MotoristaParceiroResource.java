package mapped.api.controllers;

import mapped.api.models.entities.MotoristaParceiro;
import mapped.api.services.MotoristaParceiroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/motorista-parceiro")
public class MotoristaParceiroResource {
    private MotoristaParceiroService service = new MotoristaParceiroService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MotoristaParceiro> getMotoristasParceiros() throws SQLException {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMotoristaParceiro(MotoristaParceiro motoristaParceiro) throws SQLException {
        service.add(motoristaParceiro);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MotoristaParceiro getMotoristaParceiroPorId(@PathParam("id") int id) throws SQLException {
        return service.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMotoristaParceiro(@PathParam("id") int id, MotoristaParceiro motoristaParceiro) throws SQLException {
        service.update(id, motoristaParceiro);
    }

    @DELETE
    @Path("{id}")
    public void deleteMotoristaParceiro(@PathParam("id") int id) throws SQLException {
        service.delete(id);
    }
}
