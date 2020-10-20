package Compte;

public abstract class AbstractIntervenant implements AbstractEntreprise{
    Integer idI;
    String adresseI;
    String mailI;
    String ibanI;
    String bicI;
    String mdpI;
    public AbstractIntervenant(Integer id,String adresse, String mail, String iban, String bic, String mdp) {
        this.idI=id;
        this.adresseI = adresse;
        this.mailI = mail;
        this.ibanI = iban;
        this.bicI = bic;
        this.mdpI = mdp;

    }
}
