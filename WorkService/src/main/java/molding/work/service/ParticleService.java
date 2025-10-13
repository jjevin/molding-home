package molding.work.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import molding.work.config.ServiceConfig;
import molding.work.model.Particle;
import molding.work.model.Frame;
import molding.work.dto.ParticleDTO;
import molding.work.repository.ParticleRepository;
import molding.work.repository.FrameRepository;
 
@Service
public class ParticleService {

    @Autowired
	private ParticleRepository particleRepository;

    @Autowired
	private FrameRepository frameRepository;

	@Autowired
	ServiceConfig config;

    public Particle getParticle(Long particleId) {
        Optional<Particle> particle = particleRepository.findById(particleId);
        return particle.get(); // Throws NoSuchElementException if invalid id
    }
   
    public Particle createParticle(ParticleDTO particleDTO) {
        Frame frame = frameRepository.findById(particleDTO.getFrameId())
            .orElseThrow(() -> new RuntimeException("Frame not found with id " + particleDTO.getFrameId()));

        Particle particle = new Particle();
        particle.setFrame(frame);
        particle.setPosX(particleDTO.getPosX());;
        particle.setPosY(particleDTO.getPosY());;
        particle.setPosZ(particleDTO.getPosZ());;
        particle.setVelX(particleDTO.getVelX());;
        particle.setVelY(particleDTO.getVelY());;
        particle.setVelZ(particleDTO.getVelZ());;

        return particleRepository.save(particle);
    }
    
    public Particle updateParticle(ParticleDTO particleDTO) {
        Frame frame = frameRepository.findById(particleDTO.getFrameId())
            .orElseThrow(() -> new RuntimeException("Frame not found with id " + particleDTO.getFrameId()));

        Particle particle = particleRepository.findById(particleDTO.getParticleId())
            .orElseThrow(() -> new RuntimeException("Particle not found with id " + particleDTO.getParticleId()));
        particle.setFrame(frame);
        particle.setPosX(particleDTO.getPosX());;
        particle.setPosY(particleDTO.getPosY());;
        particle.setPosZ(particleDTO.getPosZ());;
        particle.setVelX(particleDTO.getVelX());;
        particle.setVelY(particleDTO.getVelY());;
        particle.setVelZ(particleDTO.getVelZ());;

        return particleRepository.save(particle);
    }

    public String deleteParticle(Long particleId) {
        Particle particle = new Particle();
        particle.setParticleId(particleId);
        particleRepository.delete(particle);
        return "Particle ID " + particleId + " successfully deleted";
    }

}


