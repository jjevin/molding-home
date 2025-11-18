package molding.assignment.controller;

import java.util.List;
import java.util.concurrent.TimeoutException;

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

import molding.assignment.model.Assignment;
import molding.assignment.service.AssignmentService;

@RestController
@RequestMapping(value="/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value="/{assignmentId}",method = RequestMethod.GET)
    public ResponseEntity<Assignment> getAssignment(@PathVariable("assignmentId") long assignmentId) {
        return ResponseEntity.ok(assignmentService.getAssignment(assignmentId));
    }

    @RequestMapping(value="/client/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<List<Assignment>> getAssignmentsByClient(@PathVariable("clientId") long clientId) throws TimeoutException {
       
        return ResponseEntity.ok(assignmentService.getAssignmentsByClient(clientId));

    }

    @PutMapping
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment request) {
        return ResponseEntity.ok(assignmentService.updateAssignment(request));
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment request) {
        return ResponseEntity.ok(assignmentService.createAssignment(request));
    }

    @DeleteMapping(value="/{assignmentId}")
    public ResponseEntity<String> deleteAssignment(@PathVariable("assignmentId") Long assignmentId) {
        return ResponseEntity.ok(assignmentService.deleteAssignment(assignmentId));
    }

}
