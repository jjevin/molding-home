package molding.work.events.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import molding.work.events.CustomChannels;
import molding.work.events.model.AssignmentChangeModel;

@EnableBinding(CustomChannels.class)
public class AssignmentChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(AssignmentChangeHandler.class);

    @StreamListener("inboundOrgChanges")
    public void loggerSink(AssignmentChangeModel assignment) {
    	
        logger.debug("Received a message of type " + assignment.getType());
        
        switch(assignment.getAction()){
            case "GET":
                logger.debug("Received a GET event from the assignment service for assignment id {}", assignment.getAssignmentId());
                break;
            case "SAVE":
                logger.debug("Received a SAVE event from the assignment service for assignment id {}", assignment.getAssignmentId());
                break;
            case "UPDATE":
                logger.debug("Received a UPDATE event from the assignment service for assignment id {}", assignment.getAssignmentId());
                break;
            case "DELETE":
                logger.debug("Received a DELETE event from the assignment service for assignment id {}", assignment.getAssignmentId());
                break;
            default:
                logger.error("Received an UNKNOWN event from the assignment service of type {}", assignment.getType());
                break;
        }
    }


}
