package Donnee;

public class AbstractDomaineCompetence {
    protected String NomDc;

    protected Integer IdC;

    public AbstractDomaineCompetence(String nomDc,Integer id) {
        NomDc = nomDc;
        this.IdC=id;
    }
}
