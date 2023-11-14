package mapped.api.controllers;

import mapped.api.models.entities.Empresa;
import mapped.api.models.repositories.EmpresaRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/empresas")
public class EmpresaResource {
    private EmpresaRepository repository = new EmpresaRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> getEmpresas() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmpresa(Empresa empresa) throws SQLException {
        repository.add(empresa);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa getEmpresaById(@PathParam("id") int id) throws SQLException {
        return repository.find(id).orElse(null);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa updateEmpresa(@PathParam("id") int id, Empresa empresa) throws SQLException {
        if (repository.find(id).isPresent()) {
            empresa.setCdEmpresa(id);
            repository.update(id, empresa);
            return repository.find(id).orElse(null);
        }
        return empresa;
    }

    @DELETE
    @Path("/{id}")
    public void deleteEmpresa(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
        }
    }
}
