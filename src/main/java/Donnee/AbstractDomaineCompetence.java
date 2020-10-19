package Donnee;

public class AbstractDomaineCompetence {
    protected String NomDc;
    protected static Integer IdTotal;
    protected Integer IdC;

    public AbstractDomaineCompetence(String nomDc) {
        NomDc = nomDc;
        this.IdC=this.IdTotal;
        this.IdTotal++;
    }
}
