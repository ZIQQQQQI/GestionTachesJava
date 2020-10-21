package Compte;

public abstract class AbstractIntervenant implements AbstractEntreprise{
    Integer idI;
    String adresseI;
    String mailI;
    Integer ibanI;
    Integer bicI;
    String mdpI;
    String disponibleDebut;
    String disponibleFin;
    public AbstractIntervenant(Integer id,String adresse, String mail, Integer iban, Integer bic, String mdp,String debut
        ,String fin) {
        this.idI=id;
        this.adresseI = adresse;
        this.mailI = mail;
        this.ibanI = iban;
        this.bicI = bic;
        this.mdpI = mdp;
        this.disponibleDebut=debut;
        this.disponibleFin=fin;

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
}
