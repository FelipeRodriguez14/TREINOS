package impl;

import entities.Client;
import repository.ClientRepository;
import java.util.HashMap;
import java.util.Map;

public class ClientRepositoryImpl implements ClientRepository {

    private static Map<Integer, Client> clients = new HashMap<>();

    //Getters and Setters
    public Map<Integer, Client> getClients() {
        return clients;
    }
    public void setClients(Map<Integer, Client> clients) {
        clients = clients;
    }

    //Construtor
    public  ClientRepositoryImpl() {}

    //Métodos da classe

    //Método para iniciar o banco de dados.
    @Override
    public void initDatas() {
        int id = 1;
        clients.put(id, new Client(id, 19, "felipe", "71052741150"));
        id++;
        clients.put(id, new Client(id, 25, "davi", "12345678901"));
        id++;
        clients.put(id, new Client(id, 32, "Carlos Lima", "23456789012"));
        id++;
        clients.put(id, new Client(id, 28, "Beatriz Silva", "34567890123"));
        id++;
        clients.put(id, new Client(id, 45, "Ricardo Alves", "45678901234"));
        id++;
        clients.put(id, new Client(id, 21, "Julia Costa", "56789012345"));
        id++;
    }

    //Método para criar um usuário - cliente.
    @Override
    public void createClient(Client client) {
        clients.put(client.getId(), client);
    }

    //Método para alterar as credenciais
    @Override
    public void setMyClient(Client client) {
        clients.put(client.getId(), client);
    }

    //Método para deletar o usuário - cliente
    @Override
    public void deleteClient(Client client){
        clients.remove(client.getId());
    }
}
