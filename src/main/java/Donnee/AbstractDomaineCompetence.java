package Donnee;

public class AbstractDomaineCompetence {
    protected String NomDc;

    protected Integer IdC;

    public AbstractDomaineCompetence() {
    }

    public AbstractDomaineCompetence(String nomDc, Integer id) {
        NomDc = nomDc;
        this.IdC=id;
    }

    public String getNomDc() {
        return NomDc;
    }

    public void setNomDc(String nomDc) {
        NomDc = nomDc;
    }

    public Integer getIdC() {
        return IdC;
    }

    public void setIdC(Integer idC) {
        IdC = idC;
    }
}
