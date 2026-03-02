package repository;

import entities.Client;

public interface ClientRepository {
    //Método para criar um cliente
    void createClient(Client client);

    //Método para alterar o próprio cliente.
    void setMyClient(Client client);

    //Método para deletar o cliente
    void deleteClient(Client client);

    //Método para iniciar o banco de dados;
    void initDatas();
}
