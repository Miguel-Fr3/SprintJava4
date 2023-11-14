package mapped.api.models.entities;
import java.util.Date;

public class UsuarioVeiculo {

	private Integer cdUser;
    private Date dtInicio;
    private Date dtFim;
    private boolean fgAtivo;

    public UsuarioVeiculo() {
    }

    public UsuarioVeiculo(Integer cdUser, Date dtInicio, Date dtFim, boolean fgAtivo) {
        this.cdUser = cdUser;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdUser() {
        return cdUser;
    }

    public void setCdUser(Integer cdUser) {
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
