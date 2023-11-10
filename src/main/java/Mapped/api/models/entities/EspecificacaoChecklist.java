package Mapped.api.models.entities;

import java.util.Date;

public class EspecificacaoChecklist {
    @Id
	private Integer cdPCheck;
    private String dsObservacaoItemChecklist;
    private boolean nrNotaItemChecklist;
    private Date dtPreencherChecklist;

    public EspecificacaoChecklist() {
    }

    public EspecificacaoChecklist(String dsObservacaoItemChecklist, boolean nrNotaItemChecklist, Date dtPreencherChecklist, Integer cdPCheck) {
        this.dsObservacaoItemChecklist = dsObservacaoItemChecklist;
        this.nrNotaItemChecklist = nrNotaItemChecklist;
        this.dtPreencherChecklist = dtPreencherChecklist;
        this.cdPCheck = cdPCheck;
    }

    public String getDsObservacaoItemChecklist() {
        return dsObservacaoItemChecklist;
    }

    public void setDsObservacaoItemChecklist(String dsObservacaoItemChecklist) {
        this.dsObservacaoItemChecklist = dsObservacaoItemChecklist;
    }

    public boolean isNrNotaItemChecklist() {
        return nrNotaItemChecklist;
    }

    public void setNrNotaItemChecklist(boolean nrNotaItemChecklist) {
        this.nrNotaItemChecklist = nrNotaItemChecklist;
    }

    public Date getDtPreencherChecklist() {
        return dtPreencherChecklist;
    }

    public void setDtPreencherChecklist(Date dtPreencherChecklist) {
        this.dtPreencherChecklist = dtPreencherChecklist;
    }
}
