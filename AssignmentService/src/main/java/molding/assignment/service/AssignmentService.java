package molding.assignment.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import molding.assignment.config.ServiceConfig;
import molding.assignment.model.Assignment;
import molding.assignment.repository.AssignmentRepository;
import molding.assignment.utils.UserContextHolder;
import molding.assignment.events.source.SimpleSourceBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;
 
@Service
public class AssignmentService {

    @Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	ServiceConfig config;
        
    @Autowired
    SimpleSourceBean simpleSourceBean;

	private static final Logger logger = LoggerFactory.getLogger(AssignmentService.class);

    public Assignment getAssignment(Long assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        simpleSourceBean.publishAssignmentChange("GET", Long.toString(assignmentId));
        return assignment.get(); // Throws NoSuchElementException if invalid id
    }
   
    public Assignment createAssignment(Assignment assignment) {
        assignment.setAssignmentTime(LocalDateTime.now());
        assignmentRepository.save(assignment);
        simpleSourceBean.publishAssignmentChange("SAVE", Long.toString(assignment.getAssignmentId()));
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
        simpleSourceBean.publishAssignmentChange("DELETE", Long.toString(assignmentId));
        return "Assignment ID " + assignmentId + " successfully deleted";
    }

    @CircuitBreaker(name = "assignmentService", fallbackMethod = "buildFallbackAssignmentList")
    @RateLimiter(name = "assignmentService", fallbackMethod = "buildFallbackAssignmentList")
    @Retry(name = "retryAssignmentService", fallbackMethod = "buildFallbackAssignmentList")
    @Bulkhead(name = "bulkheadAssignmentService", type= Type.THREADPOOL, fallbackMethod = "buildFallbackAssignmentList")
    public List<Assignment> getAssignmentsByClient(Long clientId) throws TimeoutException {
		logger.debug("getAssignmentsByClient Correlation id: {}",
				UserContextHolder.getContext().getCorrelationId());
		return assignmentRepository.findByClientId(clientId);
    }

    @SuppressWarnings("unused")
    private List<Assignment> buildFallbackAssignmentList(Long clientId, Throwable t){
        List<Assignment> fallbackList = new ArrayList<>();
        Assignment assignment = new Assignment();
        assignment.setClientId(clientId);
        assignment.setFrameId(1L);
        assignment.setAssignmentTime(LocalDateTime.now());
        fallbackList.add(assignment);
        return fallbackList;
    }

    @SuppressWarnings("unused")
    private void randomlyRunLong() throws TimeoutException {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep() throws TimeoutException {
        try {
            System.out.println("Sleep");
            Thread.sleep(5000);
            throw new java.util.concurrent.TimeoutException();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

}
