package molding.work.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

