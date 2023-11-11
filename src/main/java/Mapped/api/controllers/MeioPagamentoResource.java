package Mapped.api.controllers;


import Mapped.api.models.entities.MeioPagamento;
import Mapped.api.models.repositories.MeioPagamentoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;


@Path("/meiopagamento")
public class MeioPagamentoResource {
    private MeioPagamentoRepository repository = new MeioPagamentoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MeioPagamento> getMeioPagamento() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMeioPagamento(MeioPagamento meioPagamento) throws SQLException {
        repository.add(meioPagamento);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MeioPagamento getMeioPagamentoPorId(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MeioPagamento updateMeioPagamento(@PathParam("id") int id, MeioPagamento meioPagamento) throws SQLException {
        if (repository.find(id).isPresent()) {
            meioPagamento.setCdMeioPgto(id);
            repository.update(meioPagamento);
            return repository.find(id).orElse(null);
        }
        return meioPagamento;
    }

    @DELETE
    @Path("{id}")
    public void deleteMeioPagamento(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
}