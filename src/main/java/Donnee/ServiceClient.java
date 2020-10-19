package Donnee;

public abstract class ServiceClient {
    protected Integer idServiceClient;
    protected static Integer idTotal=1;
    protected String nomServiceClient;

    public ServiceClient(String nomServiceClient) {
        this.nomServiceClient = nomServiceClient;
        this.idServiceClient=this.idTotal;
        this.idTotal++;
    }
}
