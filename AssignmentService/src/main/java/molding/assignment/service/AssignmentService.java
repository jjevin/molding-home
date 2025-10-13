package molding.assignment.service;

import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import molding.assignment.config.ServiceConfig;
import molding.assignment.model.Assignment;
import molding.assignment.repository.AssignmentRepository;
 
@Service
public class AssignmentService {

    @Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	ServiceConfig config;

    public Assignment getAssignment(Long assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        return assignment.get(); // Throws NoSuchElementException if invalid id
    }
   
    public Assignment createAssignment(Assignment assignment) {
        assignment.setAssignmentTime(LocalDateTime.now());
        assignmentRepository.save(assignment);
        return assignment;
    }
    
    public Assignment updateAssignment(Assignment assignment) {
        Assignment assignmentDTO = assignmentRepository.findById(assignment.getAssignmentId()).get();
        assignmentDTO.setClientId(assignment.getClientId());
        assignmentDTO.setFrameId(assignment.getFrameId());
        assignmentDTO.setAssignmentTime(LocalDateTime.now());
        assignmentRepository.save(assignmentDTO);
        return assignmentDTO;
    }

    public String deleteAssignment(Long assignmentId) {
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(assignmentId);
        assignmentRepository.delete(assignment);
        return "Assignment ID " + assignmentId + " successfully deleted";
    }

}
