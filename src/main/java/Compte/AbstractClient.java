package Compte;

public abstract class AbstractClient implements AbstractPersonne,AbstractEntreprise{

    Integer idE ;


    //chose dune personne
    public String prenomP ;
    public String nomP ;


    //chose une entreprise
    String nomE ;
    String dateDebut;
    String dateFin;
    String profession;

    //chose commune
    String adresse ;
    String mail ;
    String iban ;
    String bic ;
    String mdp ;

    public AbstractClient(){

    }

    public AbstractClient(Integer id,String adresse, String mail, String iban, String bic, String mdp) {
        this.idE = id;
        this.adresse = adresse;
        this.mail = mail;
        this.iban = iban;
        this.bic = bic;
        this.mdp = mdp;

    }

    //get et set
    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Integer getIdE(){
        return this.idE;
    }

    public void setIde(Integer i){
        this.idE=i;
    }
}
