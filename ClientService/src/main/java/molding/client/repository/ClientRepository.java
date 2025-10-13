package molding.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import molding.client.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long>  {
}


