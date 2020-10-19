package Donnee;

public abstract class  DomaineCompetence {
    protected static Integer IdTotal=1;
    protected Integer IdDom;
    protected String NomDom;

    public DomaineCompetence(String nomDom) {
        this.NomDom = nomDom;
        this.IdDom=this.IdTotal;
        this.IdTotal++;
    }
}
