package Mapped.api.models.entities;

import java.util.Date;

public class ParceiroVeiculo {
    @Id
	private Integer cdParceiro;
    private Date dtInicio;
    private Date dtFim;

    public ParceiroVeiculo() {
    }

    public ParceiroVeiculo(Date dtInicio, Date dtFim, Integer cdParceiro) {
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
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

    @Override
    public String toString() {
        return "ParceiroVeiculo{" +
                "dtInicio=" + dtInicio +
                ", dtFim=" + dtFim +
                '}';
    }
}
