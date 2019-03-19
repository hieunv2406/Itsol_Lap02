package carManager;

public class ModernCar extends Car {
	private boolean havePositioningDevice;
	private int numberModernCar;

	public ModernCar(boolean havePositioningDevice, int numberModernCar) {
		super();
		this.havePositioningDevice = havePositioningDevice;
		this.numberModernCar = numberModernCar;
	}

	public ModernCar() {
		super();
	}

	public boolean isHavePositioningDevice() {
		return havePositioningDevice;
	}

	public void setHavePositioningDevice(boolean havePositioningDevice) {
		this.havePositioningDevice = havePositioningDevice;
	}

	public int getNumberModernCar() {
		return numberModernCar;
	}

	public void setNumberModernCar(int numberModernCar) {
		this.numberModernCar = numberModernCar;
	}

}
