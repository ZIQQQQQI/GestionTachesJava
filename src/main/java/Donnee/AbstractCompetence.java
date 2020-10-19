package Donnee;

public abstract class AbstractCompetence {

        protected  static Integer IdCTotal=1;
        protected String NomComp;
        protected Integer IdC;

        public AbstractCompetence(String nomComp) {
            this.IdC=this.IdCTotal;
            this.NomComp = nomComp;
            this.IdCTotal++;
        }

}
