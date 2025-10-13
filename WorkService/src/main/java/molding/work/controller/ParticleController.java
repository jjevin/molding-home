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

import molding.work.model.Particle;
import molding.work.dto.ParticleDTO;
import molding.work.service.ParticleService;

@RestController
@RequestMapping(value="/particle")
public class ParticleController {

    @Autowired
    private ParticleService particleService;

    @RequestMapping(value="/{particleId}",method = RequestMethod.GET)
    public ResponseEntity<Particle> getParticle(@PathVariable("particleId") long particleId) {
        return ResponseEntity.ok(particleService.getParticle(particleId));
    }

    @PutMapping
    public ResponseEntity<Particle> updateParticle(@RequestBody ParticleDTO request) {
        return ResponseEntity.ok(particleService.updateParticle(request));
    }

    @PostMapping
    public ResponseEntity<Particle> createParticle(@RequestBody ParticleDTO request) {
        return ResponseEntity.ok(particleService.createParticle(request));
    }

    @DeleteMapping(value="/{particleId}")
    public ResponseEntity<String> deleteParticle(@PathVariable("particleId") Long particleId) {
        return ResponseEntity.ok(particleService.deleteParticle(particleId));
    }

}


