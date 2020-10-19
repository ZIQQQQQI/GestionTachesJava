package Compte;

public class AbstractPersonne {
    protected static Integer idTotal=1;
    protected Integer idP;
    protected String nomP;
    protected String adresseP;
    protected String mailP;
    protected String ibanP;
    protected String bivP;
    protected String MdpP;

    public AbstractPersonne(String nomP, String adresseP, String mailP, String ibanP, String bivP, String mdpP) {
        this.nomP = nomP;
        this.adresseP = adresseP;
        this.mailP = mailP;
        this.ibanP = ibanP;
        this.bivP = bivP;
        MdpP = mdpP;
        this.idP=this.idTotal;
        this.idTotal++;

    }

}
