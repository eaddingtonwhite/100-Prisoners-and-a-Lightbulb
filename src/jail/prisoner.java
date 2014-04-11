package jail;

public class prisoner {
	
	private int ID;
	private boolean turnedLightOnBefore;
	private boolean leader;
	
	prisoner(int ID){
		this.ID = ID;
		this.turnedLightOnBefore = false;
	}

	public int getID() {
		return ID;
	}

	public boolean isTurnedLightOnBefore() {
		return turnedLightOnBefore;
	}

	public void setTurnedLightOnBefore(boolean turnedLightOnBefore) {
		this.turnedLightOnBefore = turnedLightOnBefore;
	}

	public boolean isLeader() {
		return leader;
	}

	public void setLeader(boolean leader) {
		this.leader = leader;
	}
	
	

}
