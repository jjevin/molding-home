package molding.work.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "particles")
@Getter @Setter
public class Particle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "particle_id")
    private Long particleId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frame_id", nullable = false)
    private Frame frame;

    @Column(name = "pos_x")
    private float posX;

    @Column(name = "pos_y")
    private float posY;

    @Column(name = "pos_z")
    private float posZ;

    @Column(name = "vel_x")
    private float velX;

    @Column(name = "vel_y")
    private float velY;

    @Column(name = "vel_z")
    private float velZ;
}

