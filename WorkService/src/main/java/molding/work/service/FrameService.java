package molding.work.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import molding.work.config.ServiceConfig;
import molding.work.dto.FrameDTO;
import molding.work.model.Frame;
import molding.work.model.Problem;
import molding.work.repository.FrameRepository;
import molding.work.repository.ProblemRepository;
 
@Service
public class FrameService {

    @Autowired
	private FrameRepository frameRepository;

    @Autowired
	private ProblemRepository problemRepository;

	@Autowired
	ServiceConfig config;

    public Frame getFrame(Long frameId) {
        Optional<Frame> frame = frameRepository.findById(frameId);
        return frame.get(); // Throws NoSuchElementException if invalid id
    }
   
    public Frame createFrame(FrameDTO frameDTO) {
        Problem problem = problemRepository.findById(frameDTO.getProblemId())
            .orElseThrow(() -> new RuntimeException("Problem not found with id " + frameDTO.getProblemId()));

        Frame frame = new Frame();
        frame.setProblem(problem);
        frame.setCurrentFrame(frameDTO.getCurrentFrame());

        return frameRepository.save(frame);
    }
    
    public Frame updateFrame(FrameDTO frameDTO) {
        Problem problem = problemRepository.findById(frameDTO.getProblemId())
            .orElseThrow(() -> new RuntimeException("Problem not found with id " + frameDTO.getProblemId()));
        Frame frame = frameRepository.findById(frameDTO.getFrameId())
            .orElseThrow(() -> new RuntimeException("Frame not found with id " + frameDTO.getFrameId()));
        frame.setFrameId(frameDTO.getFrameId());
        frame.setProblem(problem);
        frame.setCurrentFrame(frameDTO.getCurrentFrame());

        return frameRepository.save(frame);
    }

    public String deleteFrame(Long frameId) {
        Frame frame = new Frame();
        frame.setFrameId(frameId);
        frameRepository.delete(frame);
        return "Frame ID " + frameId + " successfully deleted";
    }

}


