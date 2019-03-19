package carManager;

public class OldCar extends Car {

	private String actionDuration;
	private int numberOldCar;

	public OldCar() {
		super();
	}

	public OldCar(String actionDuration, int numberOldCar) {
		super();
		this.actionDuration = actionDuration;
		this.numberOldCar = numberOldCar;
	}

	public String getActionDuration() {
		return actionDuration;
	}

	public void setActionDuration(String actionDuration) {
		this.actionDuration = actionDuration;
	}

	public int getNumberOldCar() {
		return numberOldCar;
	}

	public void setNumberOldCar(int numberOldCar) {
		this.numberOldCar = numberOldCar;
	}

}
