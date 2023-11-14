package mapped.api.models.entities;

import java.util.Date;

public class EspecificacaoChecklist {

	private Integer cdPCheck;
    private String dsObservacaoItemChecklist;
    private boolean nrNotaItemChecklist;
    private Date dtPreencherChecklist;

    public EspecificacaoChecklist() {
    }

    public EspecificacaoChecklist(Integer cdPCheck, String dsObservacaoItemChecklist, boolean nrNotaItemChecklist, Date dtPreencherChecklist) {
        this.cdPCheck = cdPCheck;
        this.dsObservacaoItemChecklist = dsObservacaoItemChecklist;
        this.nrNotaItemChecklist = nrNotaItemChecklist;
        this.dtPreencherChecklist = dtPreencherChecklist;
    }

    public Integer getCdPCheck() {
        return cdPCheck;
    }

    public void setCdPCheck(Integer cdPCheck) {
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
