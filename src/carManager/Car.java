package carManager;

import java.io.Serializable;
import java.util.Random;

public class Car implements Serializable {

	private String carName;
	private String numberPlate;
	private int yearOfManufacture;
	private String brand;
	private boolean haveInsurance;
	private String carType;
	private int totalCar;

	public Car() {
		super();
	}

	public Car(String carName, String numberPlate, int yearOfManufacture, String brand,
			boolean haveInsurance, String carType, int totalCar) {
		super();
		this.carName = carName;
		this.numberPlate = numberPlate;
		this.yearOfManufacture = yearOfManufacture;
		this.brand = brand;
		this.haveInsurance = haveInsurance;
		this.carType = carType;
		this.totalCar = totalCar;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}



	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isHaveInsurance() {
		return haveInsurance;
	}

	public void setHaveInsurance(boolean haveInsurance) {
		this.haveInsurance = haveInsurance;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getTotalCar() {
		return totalCar;
	}

	public void setTotalCar(int totalCar) {
		this.totalCar = totalCar;
	}

	public void insertData() {
		String a = null;

		String[] myarr = new String[] { "toyota", "bmw", "huyndai" };

//		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
//		System.out.println("ins namecar");
//		this.carName = sc.nextLine();
//		System.out.println("ins numb");
//		this.numberPlate = sc.nextLine();

		for (int i = 0; i < 4; i++) {
			int j = rd.nextInt(10);
			a = a + j;
		}
		this.numberPlate = a.substring(3);

//		System.out.println("ins year");
//		this.yearOfManufacture = sc.nextLine();
		for (int i = 0; i < 32; i++) {
			this.yearOfManufacture = 1980 + rd.nextInt(33);
		}
//		System.out.println("ins brand");
//		this.brand = sc.nextLine();

		int index = rd.nextInt(myarr.length);
		this.brand = myarr[index];

//		System.out.println("ins insur");
//		this.haveInsurance = sc.nextBoolean();

		this.haveInsurance = rd.nextBoolean();

	}

	public void viewData() {
		System.out.println("nameCar: " + this.carName + "\t" + "numb:	" + this.numberPlate + "\t" + "year:	"
				+ this.yearOfManufacture + "\t" + "brand:	" + this.brand + "\t" + "insur:	" + this.haveInsurance
				+ "\t" + "carType:  " + this.carType);

	}


}
