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

import molding.work.dto.FrameDTO;
import molding.work.model.Frame;
import molding.work.service.FrameService;

@RestController
@RequestMapping(value="/frame")
public class FrameController {

    @Autowired
    private FrameService frameService;

    @RequestMapping(value="/{frameId}",method = RequestMethod.GET)
    public ResponseEntity<Frame> getFrame(@PathVariable("frameId") long frameId) {
        return ResponseEntity.ok(frameService.getFrame(frameId));
    }

    @PutMapping
    public ResponseEntity<Frame> updateFrame(@RequestBody FrameDTO request) {
        return ResponseEntity.ok(frameService.updateFrame(request));
    }

    @PostMapping
    public ResponseEntity<Frame> createFrame(@RequestBody FrameDTO request) {
        return ResponseEntity.ok(frameService.createFrame(request));
    }

    @DeleteMapping(value="/{frameId}")
    public ResponseEntity<String> deleteFrame(@PathVariable("frameId") Long frameId) {
        return ResponseEntity.ok(frameService.deleteFrame(frameId));
    }

}


