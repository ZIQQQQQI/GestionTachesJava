package Donnee;

public abstract class Competence {
    protected  static Integer IdCTotal=1;
    protected String NomComp;
    protected Integer IdC;

    public Competence(String nomComp) {
        this.IdC=this.IdCTotal;
        this.NomComp = nomComp;
        this.IdCTotal++;
    }
}
