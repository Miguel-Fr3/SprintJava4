package Mapped.api.models.entities;

public class MeioPagamento {
    @Id
	private Integer cdMeioPgto;
    private String dsMeioPagamento;
    private boolean fgAtivo;

    public MeioPagamento() {
    }

    public MeioPagamento(String dsMeioPagamento, boolean fgAtivo,Integer cdMeioPgto) {
        this.dsMeioPagamento = dsMeioPagamento;
        this.fgAtivo = fgAtivo;
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
