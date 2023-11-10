package Mapped.api.models.entities;
import java.util.Date;

public class UsuarioVeiculo {
    @Id
	private Integer cdUser;
    private Date dtInicio;
    private Date dtFim;
    private boolean fgAtivo;

    public UsuarioVeiculo() {
    }

    public UsuarioVeiculo(Date dtInicio, Date dtFim, boolean fgAtivo, Integer cdUser) {
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.fgAtivo = fgAtivo;
        this.cdUser = cdUser;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public boolean isFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
