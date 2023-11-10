package Mapped.api.models.entities;

public class Logradouro {
    @Id
	private Integer cdLogradouro;
    private String nmLogradouro;
    private double nrCep;

    public Logradouro() {
    }

    public Logradouro(String nmLogradouro, double nrCep, Integer cdLogradouro) {
        this.nmLogradouro = nmLogradouro;
        this.nrCep = nrCep;
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
