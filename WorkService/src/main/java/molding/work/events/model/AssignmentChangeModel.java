package molding.work.events.model;


public class AssignmentChangeModel {
	private String type;
    private String action;
    private String assignmentId;
    private String correlationId;

    public AssignmentChangeModel(){
        super();
    }

    public AssignmentChangeModel(String type, String action, String assignmentId, String correlationId) {
        super();
        this.type   = type;
        this.action = action;
        this.assignmentId = assignmentId;
        this.correlationId = correlationId;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
}
