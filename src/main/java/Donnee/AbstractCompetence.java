package Donnee;

public abstract class AbstractCompetence {
        protected String NomComp;
        protected Integer IdC;

        public AbstractCompetence(String nomComp,Integer id) {
            this.IdC=id;
            this.NomComp = nomComp;
        }

    public String getNomComp() {
        return NomComp;
    }

    public Integer getIdC() {
        return IdC;
    }
}
