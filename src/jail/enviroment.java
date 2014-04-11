package jail;

public class enviroment {

	private boolean lightSwitch;

	enviroment() {
		lightSwitch = false;
	}
	
	public boolean turnOff(){
		this.lightSwitch = false;
		return true;
	}
	
	public boolean turnOn(){
		this.lightSwitch = true;
		return true;
	}

	public boolean isLightSwitchOn() {
		return lightSwitch;
	}


	
	
}
