package molding.client.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import molding.client.config.ServiceConfig;
import molding.client.model.Client;
import molding.client.repository.ClientRepository;
 
@Service
public class ClientService {

    @Autowired
	private ClientRepository clientRepository;

	@Autowired
	ServiceConfig config;

    public Client getClient(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.get(); // Throws NoSuchElementException if invalid id
    }
   
    public Client createClient(Client client) {
        clientRepository.save(client);
        return client;
    }
    
    public Client updateClient(Client client) {
        Client clientDTO = clientRepository.findById(client.getClientId()).get();
        clientDTO.setClientName(client.getClientName());
        clientDTO.setScore(client.getScore());
        clientRepository.save(clientDTO);
        return clientDTO;
    }

    public String deleteClient(Long clientId) {
        Client client = new Client();
        client.setClientId(clientId);
        clientRepository.delete(client);
        return "Client ID " + clientId + " successfully deleted";
    }

}



