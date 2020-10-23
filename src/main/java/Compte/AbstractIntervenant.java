package Compte;

public abstract class AbstractIntervenant implements AbstractEntreprise{
    Integer idI;
    String adresseI;
    String mailI;
    Integer ibanI;
    Integer bicI;
    String mdpI;
    String disponibleDebut;

    public Integer getNosiret() {
        return Nosiret;
    }

    public void setNosiret(Integer nosiret) {
        Nosiret = nosiret;
    }

    String disponibleFin;
    Integer Nosiret=0;

    public AbstractIntervenant() {
    }

    public AbstractIntervenant(Integer id, String adresse, String mail, Integer iban, Integer bic, String mdp, String debut
        , String fin) {
        this.idI=id;
        this.adresseI = adresse;
        this.mailI = mail;
        this.ibanI = iban;
        this.bicI = bic;
        this.mdpI = mdp;
        this.disponibleDebut=debut;
        this.disponibleFin=fin;

    }

    @Override
    public void entrepreise(String nom, String dateDebut, String dateFin, String profession) {

    }

    public Integer getIdI() {
        return idI;
    }

    public String getAdresseI() {
        return adresseI;
    }

    public String getMailI() {
        return mailI;
    }

    public Integer getIbanI() {
        return ibanI;
    }

    public Integer getBicI() {
        return bicI;
    }

    public String getMdpI() {
        return mdpI;
    }

    public String getDisponibleDebut() {
        return disponibleDebut;
    }

    public String getDisponibleFin() {
        return disponibleFin;
    }

    public void setIdI(Integer idI) {
        this.idI = idI;
    }

    public void setAdresseI(String adresseI) {
        this.adresseI = adresseI;
    }

    public void setMailI(String mailI) {
        this.mailI = mailI;
    }

    public void setIbanI(Integer ibanI) {
        this.ibanI = ibanI;
    }

    public void setBicI(Integer bicI) {
        this.bicI = bicI;
    }

    public void setMdpI(String mdpI) {
        this.mdpI = mdpI;
    }

    public void setDisponibleDebut(String disponibleDebut) {
        this.disponibleDebut = disponibleDebut;
    }

    public void setDisponibleFin(String disponibleFin) {
        this.disponibleFin = disponibleFin;
    }
}
