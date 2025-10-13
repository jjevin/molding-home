package molding.work.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import molding.work.model.Problem;

@Repository
public interface ProblemRepository extends CrudRepository<Problem,Long>  {
}

