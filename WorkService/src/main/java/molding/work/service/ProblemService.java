package molding.work.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import molding.work.config.ServiceConfig;
import molding.work.model.Problem;
import molding.work.repository.ProblemRepository;
 
@Service
public class ProblemService {

    @Autowired
	private ProblemRepository problemRepository;

	@Autowired
	ServiceConfig config;

    public Problem getProblem(Long problemId) {
        Optional<Problem> problem = problemRepository.findById(problemId);
        return problem.get(); // Throws NoSuchElementException if invalid id
    }
   
    public Problem createProblem(Problem problem) {
        problemRepository.save(problem);
        return problem;
    }
    
    public Problem updateProblem(Problem problem) {
        // Problem problemDTO = problemRepository.findById(problem.getProblemId()).get();
        // problemDTO.setClientId(problem.getClientId());
        // problemDTO.setWorkunitId(problem.getWorkunitId());
        // problemDTO.setProblemTime(LocalDateTime.now());
        problemRepository.save(problem);
        return problem;
    }

    public String deleteProblem(Long problemId) {
        Problem problem = new Problem();
        problem.setProblemId(problemId);
        problemRepository.delete(problem);
        return "Problem ID " + problemId + " successfully deleted";
    }

}

