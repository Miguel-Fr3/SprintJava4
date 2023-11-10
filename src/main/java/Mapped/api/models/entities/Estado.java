package Mapped.api.models.entities;

public class Estado {
    @Id
	private Integer cdEstado;
    private String nmEstado;

    public Estado() {
    }

    public Estado(Integer cdEstado, String nmEstado) {
        this.cdEstado = cdEstado;
        this.nmEstado = nmEstado;
    }

    public Integer getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(Integer cdEstado) {
        this.cdEstado = cdEstado;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }
}
