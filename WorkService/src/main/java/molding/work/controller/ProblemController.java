package molding.work.controller;

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

import molding.work.model.Problem;
import molding.work.service.ProblemService;

@RestController
@RequestMapping(value="/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value="/{problemId}",method = RequestMethod.GET)
    public ResponseEntity<Problem> getProblem(@PathVariable("problemId") long problemId) {
        return ResponseEntity.ok(problemService.getProblem(problemId));
    }

    @PutMapping
    public ResponseEntity<Problem> updateProblem(@RequestBody Problem request) {
        return ResponseEntity.ok(problemService.updateProblem(request));
    }

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem request) {
        return ResponseEntity.ok(problemService.createProblem(request));
    }

    @DeleteMapping(value="/{problemId}")
    public ResponseEntity<String> deleteProblem(@PathVariable("problemId") Long problemId) {
        return ResponseEntity.ok(problemService.deleteProblem(problemId));
    }

}

