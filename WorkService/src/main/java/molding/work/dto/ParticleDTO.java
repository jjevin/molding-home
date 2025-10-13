package molding.work.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParticleDTO {
    private Long particleId;
    private Long frameId;
    private float posX;
    private float posY;
    private float posZ;
    private float velX;
    private float velY;
    private float velZ;
}

