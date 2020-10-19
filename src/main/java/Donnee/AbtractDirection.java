package Donnee;

public abstract class AbtractDirection {
    protected  Integer idD;
    protected static Integer idTotal=1;
    protected String nomD;

    public AbtractDirection(String nomD) {
        this.nomD = nomD;
        this.idD=this.idTotal;
        this.idTotal++;
    }
}
