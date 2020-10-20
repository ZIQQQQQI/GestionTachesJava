package Donnee;

public class AbstractServiceClient {
    protected Integer idServiceClient;
    protected String nomServiceClient;

    public AbstractServiceClient(String nomServiceClient,Integer id) {
        this.nomServiceClient = nomServiceClient;
        this.idServiceClient=id;
    }


}
