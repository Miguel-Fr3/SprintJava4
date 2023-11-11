package Mapped.api.models.entities;

import java.util.Date;

public class Checklist {
    @Id
	private Integer cdChecklis;
    private Date dtCadastroChecklist;
    private String dsChecklist;

    public Checklist() {
    }

    public Checklist(Integer cdChecklis, Date dtCadastroChecklist, String dsChecklist) {
        this.cdChecklis = cdChecklis;
        this.dtCadastroChecklist = dtCadastroChecklist;
        this.dsChecklist = dsChecklist;
    }

    public Integer getCdChecklis() {
        return cdChecklis;
    }

    public void setCdChecklis(Integer cdChecklis) {
        this.cdChecklis = cdChecklis;
    }

    public Date getDtCadastroChecklist() {
        return dtCadastroChecklist;
    }

    public void setDtCadastroChecklist(Date dtCadastroChecklist) {
        this.dtCadastroChecklist = dtCadastroChecklist;
    }

    public String getDsChecklist() {
        return dsChecklist;
    }

    public void setDsChecklist(String dsChecklist) {
        this.dsChecklist = dsChecklist;
    }
}
