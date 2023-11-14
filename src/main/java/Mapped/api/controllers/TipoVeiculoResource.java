package mapped.api.controllers;

import mapped.api.models.entities.TipoVeiculo;
import mapped.api.models.repositories.TipoVeiculoRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/tipo-veiculo")
@Produces(MediaType.APPLICATION_JSON)
public class TipoVeiculoResource {

    private final TipoVeiculoRepository tipoVeiculoRepository;

    public TipoVeiculoResource() {
        this.tipoVeiculoRepository = new TipoVeiculoRepository();
    }

    @GET
    public Response getAllTiposVeiculo() {
        try {
            List<TipoVeiculo> tiposVeiculo = tipoVeiculoRepository.findAll();
            return Response.ok(tiposVeiculo).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao obter tipos de veículo: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getTipoVeiculoById(@PathParam("id") int id) {
        try {
            Optional<TipoVeiculo> tipoVeiculo = tipoVeiculoRepository.find(id);
            if (tipoVeiculo.isPresent()) {
                return Response.ok(tipoVeiculo.get()).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Tipo de veículo não encontrado com o ID: " + id)
                        .build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao obter tipo de veículo: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTipoVeiculo(TipoVeiculo tipoVeiculo) {
        try {
            tipoVeiculoRepository.add(tipoVeiculo);
            return Response.status(Response.Status.CREATED).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao adicionar tipo de veículo: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTipoVeiculo(@PathParam("id") int id, TipoVeiculo tipoVeiculo) {
        tipoVeiculoRepository.update(id, tipoVeiculo);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTipoVeiculo(@PathParam("id") int id) {
        tipoVeiculoRepository.delete(id);
        return Response.ok().build();
    }
}
