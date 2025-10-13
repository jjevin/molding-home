package molding.work.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import molding.work.model.Particle;

@Repository
public interface ParticleRepository extends CrudRepository<Particle,Long>  {
}

