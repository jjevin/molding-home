package molding.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import molding.client.model.Client;
import molding.client.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value="/{clientId}",method = RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable("clientId") long clientId) {
        return ResponseEntity.ok(clientService.getClient(clientId));
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client request) {
        return ResponseEntity.ok(clientService.updateClient(request));
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }

    @DeleteMapping(value="/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok(clientService.deleteClient(clientId));
    }

}



