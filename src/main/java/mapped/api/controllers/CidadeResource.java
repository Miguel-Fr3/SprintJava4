package mapped.api.controllers;

import mapped.api.models.entities.Cidade;
import mapped.api.models.repositories.CidadeRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/cidades")
public class CidadeResource {
    private CidadeRepository repository = new CidadeRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> getCidades() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCidade(Cidade cidade) throws SQLException {
        repository.add(cidade);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade getCidadeById(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade updateCidade(@PathParam("id") int id, Cidade cidade) throws SQLException {
        if (repository.find(id).isPresent()) {
            cidade.setCdCidade(id);
            repository.update(id, cidade);
            return repository.find(id).orElse(null);
        }
        return cidade;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCidade(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
}
