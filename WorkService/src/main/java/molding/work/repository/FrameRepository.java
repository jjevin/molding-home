package molding.work.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import molding.work.model.Frame;

@Repository
public interface FrameRepository extends CrudRepository<Frame,Long>  {
}

