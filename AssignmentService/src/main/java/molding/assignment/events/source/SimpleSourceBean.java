package molding.assignment.events.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import molding.assignment.events.model.AssignmentChangeModel;
import molding.assignment.utils.UserContext;

@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishAssignmentChange(String action, String assignmentId){
       logger.debug("Sending Kafka message {} for Assignment Id: {}", action, assignmentId);
        AssignmentChangeModel change =  new AssignmentChangeModel(
                AssignmentChangeModel.class.getTypeName(),
                action,
                assignmentId,
                UserContext.getCorrelationId());

        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
