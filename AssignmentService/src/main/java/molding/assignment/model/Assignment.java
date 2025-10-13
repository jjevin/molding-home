package molding.assignment.model;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="assignments")
@Getter @Setter
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

}
