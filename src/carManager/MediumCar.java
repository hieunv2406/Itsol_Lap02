package carManager;

public class MediumCar extends Car {

	private boolean havePowerSteering;
	private int numberMediumCar;

	public MediumCar() {
		super();
	}

	public MediumCar(boolean havePowerSteering, int numberMediumCar) {
		super();
		this.havePowerSteering = havePowerSteering;
		this.numberMediumCar = numberMediumCar;
	}

	public boolean isHavePowerSteering() {
		return havePowerSteering;
	}

	public void setHavePowerSteering(boolean havePowerSteering) {
		this.havePowerSteering = havePowerSteering;
	}

	public int getNumberMediumCar() {
		return numberMediumCar;
	}

	public void setNumberMediumCar(int numberMediumCar) {
		this.numberMediumCar = numberMediumCar;
	}

}
