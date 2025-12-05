package molding.assignment.model;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="assignments")
// @Getter @Setter
public class Assignment extends RepresentationModel<Assignment> {

    @Id
    @Column(name = "assignment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;
    @Column(name = "client_id", nullable = false)
    private Long clientId;
    @Column(name = "frame_id", nullable = false)
    private Long frameId;
    @Column(name = "assignment_time", nullable = false)
    private LocalDateTime assignmentTime;

	public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getFrameId() {
		return frameId;
	}
	public void setFrameId(Long frameId) {
		this.frameId = frameId;
	}
	public LocalDateTime getAssignmentTime() {
		return assignmentTime;
	}
	public void setAssignmentTime(LocalDateTime assignmentTime) {
		this.assignmentTime = assignmentTime;
	}

}
