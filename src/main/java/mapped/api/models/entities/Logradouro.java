package mapped.api.models.entities;

public class Logradouro {

	private Integer cdLogradouro;
    private String nmLogradouro;
    private double nrCep;

    public Logradouro() {
    }

    public Logradouro(Integer cdLogradouro, String nmLogradouro, double nrCep) {
        this.cdLogradouro = cdLogradouro;
        this.nmLogradouro = nmLogradouro;
        this.nrCep = nrCep;
    }

    public Integer getCdLogradouro() {
        return cdLogradouro;
    }

    public void setCdLogradouro(Integer cdLogradouro) {
        this.cdLogradouro = cdLogradouro;
    }

    public String getNmLogradouro() {
        return nmLogradouro;
    }

    public void setNmLogradouro(String nmLogradouro) {
        this.nmLogradouro = nmLogradouro;
    }

    public double getNrCep() {
        return nrCep;
    }

    public void setNrCep(double nrCep) {
        this.nrCep = nrCep;
    }
}
