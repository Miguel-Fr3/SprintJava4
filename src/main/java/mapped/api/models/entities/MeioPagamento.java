package mapped.api.models.entities;

public class MeioPagamento {

	private Integer cdMeioPgto;
    private String dsMeioPagamento;
    private boolean fgAtivo;

    public MeioPagamento() {
    }

    public MeioPagamento(Integer cdMeioPgto, String dsMeioPagamento, boolean fgAtivo) {
        this.cdMeioPgto = cdMeioPgto;
        this.dsMeioPagamento = dsMeioPagamento;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdMeioPgto() {
        return cdMeioPgto;
    }

    public void setCdMeioPgto(Integer cdMeioPgto) {
        this.cdMeioPgto = cdMeioPgto;
    }

    public String getDsMeioPagamento() {
        return dsMeioPagamento;
    }

    public void setDsMeioPagamento(String dsMeioPagamento) {
        this.dsMeioPagamento = dsMeioPagamento;
    }

    public boolean isFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
