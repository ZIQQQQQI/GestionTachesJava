package Donnee;

public abstract class ServiceClient {
    protected Integer IdServiceClient;
    protected String NomServiceClient;
    protected static Integer IdTotal=1;

    public ServiceClient(String nomServiceClient) {
        this.IdServiceClient=this.IdTotal;
        NomServiceClient = nomServiceClient;
        this.IdTotal++;
    }
}
