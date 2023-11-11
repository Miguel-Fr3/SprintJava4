package Mapped.api.models.entities;

public class ItemChecklist {
    @Id
	private Integer cdIchecklist;
    private String dsItemChecklist;
    private boolean nrNotaMaxima;

    public ItemChecklist() {
    }

    public ItemChecklist(Integer cdIchecklist, String dsItemChecklist, boolean nrNotaMaxima) {
        this.cdIchecklist = cdIchecklist;
        this.dsItemChecklist = dsItemChecklist;
        this.nrNotaMaxima = nrNotaMaxima;
    }

    public Integer getCdIchecklist() {
        return cdIchecklist;
    }

    public void setCdIchecklist(Integer cdIchecklist) {
        this.cdIchecklist = cdIchecklist;
    }

    public String getDsItemChecklist() {
        return dsItemChecklist;
    }

    public void setDsItemChecklist(String dsItemChecklist) {
        this.dsItemChecklist = dsItemChecklist;
    }

    public boolean isNrNotaMaxima() {
        return nrNotaMaxima;
    }

    public void setNrNotaMaxima(boolean nrNotaMaxima) {
        this.nrNotaMaxima = nrNotaMaxima;
    }
}
