package Mapped.api.controllers;

import Mapped.api.models.entities.CategoriaVeiculo;
import Mapped.api.models.repositories.CategoriaVeiculoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/categoria-veiculo")
public class CategoriaVeiculoResource {

    private CategoriaVeiculoRepository repository = new CategoriaVeiculoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaVeiculo> getCategoriasVeiculo() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) throws SQLException {
        repository.add(categoriaVeiculo);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaVeiculo getCategoriaVeiculoPorId(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaVeiculo updateCategoriaVeiculo(@PathParam("id") int id, CategoriaVeiculo categoriaVeiculo) throws SQLException {
        Optional<CategoriaVeiculo> existingCategoria = repository.find(id);
        if (existingCategoria.isPresent()) {

            existingCategoria.get().setDsCategoriaVeiculo(categoriaVeiculo.getDsCategoriaVeiculo());


            repository.update(id, existingCategoria.get());

            return existingCategoria.get();
        } else {

            repository.add(categoriaVeiculo);
            return categoriaVeiculo;
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteCategoriaVeiculo(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
}
