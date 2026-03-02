package services;

import entities.Client;
import impl.ClientRepositoryImpl;
import javax.swing.*;
import java.util.Map;

public class ClientService {

ClientRepositoryImpl repository = new ClientRepositoryImpl();

//Iniciar o banco de dados
public void initRepository(){
    repository.initDatas();
}

//Definir qual será o próximo ID para a nova conta cadastrada.
private int definedID(Map<Integer, Client> clients){
        int id = 0;
        for(Client c : clients.values()){
            if(c.getId() == id){
                id++;
            }
        }
        return id;
}

//Criar um novo cliente
public void createClient(Client client){
    for(Client c : repository.getClients().values()){
        if(c.getCpf().equals(client.getCpf())){
            JOptionPane.showMessageDialog(null,"USER ALREADY EXIST");
            return;
        }
    }
    client.setId(definedID(repository.getClients()));
    repository.createClient(client);
}

//Alterar minhas próprias credenciais
public void setMyCredentials(Client client){
    repository.setMyClient(client);
}

//Deletar a conta do usuário - cliente.
public void deleteClient(Client client){
    repository.deleteClient(client);
}

}
