package molding.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import molding.work.events.model.AssignmentChangeModel;

import org.springframework.cloud.stream.messaging.Sink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@EnableDiscoveryClient
// TODO: Deprecation warning
@EnableBinding(Sink.class)
public class WorkApplication {

	private static final Logger logger = LoggerFactory.getLogger(WorkApplication.class);

    @StreamListener(Sink.INPUT)    
    public void loggerSink(AssignmentChangeModel assignmentChange) {
        logger.debug("Received an {} event for assignment id {}",
            assignmentChange.getAction(), assignmentChange.getAssignmentId());
    }

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}

}
