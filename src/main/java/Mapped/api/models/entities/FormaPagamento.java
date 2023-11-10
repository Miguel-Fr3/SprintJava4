package Mapped.api.models.entities;

public class FormaPagamento {
    @Id
	private Integer cdFormaPgto;
    private String dsFormaPagamento;
    private boolean fgAtivo;

    public FormaPagamento() {
    }

    public FormaPagamento(String dsFormaPagamento, boolean fgAtivo, Integer cdFormaPgto) {
        this.dsFormaPagamento = dsFormaPagamento;
        this.fgAtivo = fgAtivo;
        this.cdFormaPgto = cdFormaPgto;
    }

    public String getDsFormaPagamento() {
        return dsFormaPagamento;
    }

    public void setDsFormaPagamento(String dsFormaPagamento) {
        this.dsFormaPagamento = dsFormaPagamento;
    }

    public boolean isFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
