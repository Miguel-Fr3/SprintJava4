package mapped.api.models.entities;

import java.util.Date;

public class ParceiroVeiculo {

	private Integer cdParceiro;
    private Date dtInicio;
    private Date dtFim;

    public ParceiroVeiculo() {
    }

    public ParceiroVeiculo(Integer cdParceiro, Date dtInicio, Date dtFim) {
        this.cdParceiro = cdParceiro;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public Integer getCdParceiro() {
        return cdParceiro;
    }

    public void setCdParceiro(Integer cdParceiro) {
        this.cdParceiro = cdParceiro;
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
}
