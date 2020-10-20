package Donnee;

public abstract class AbstractCompetence {
        protected String NomComp;
        protected Integer IdC;

        public AbstractCompetence(String nomComp,Integer id) {
            this.IdC=id;
            this.NomComp = nomComp;
        }

}
