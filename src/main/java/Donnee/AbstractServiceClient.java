package Donnee;

public class AbstractServiceClient {
    protected Integer idServiceClient;
    protected static Integer idTotal=1;
    protected String nomServiceClient;

    public AbstractServiceClient(String nomServiceClient) {
        this.nomServiceClient = nomServiceClient;
        this.idServiceClient=this.idTotal;
        this.idTotal++;
    }


}
