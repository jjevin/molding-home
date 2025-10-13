package molding.assignment.repository;

// import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import molding.assignment.model.Assignment;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment,Long>  {
    // public List<Assignment> findByOrganizationId(String organizationId);
    // public Assignment findByOrganizationIdAndLicenseId(String organizationId,String licenseId);
}

