package carManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	List<Car> listCar = new ArrayList<>();
	List<InsurancePackage> listPackage = new ArrayList<>();

	public static void main(String[] args) {
		Main main1 = new Main();
		Car car1 = new Car();
		int chon;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu: ");
			System.out.println("1: Insert");
			System.out.println("2: View");
			System.out.println("3: xe tung loai ");
			System.out.println("4: insert Insurance package");
			System.out.println("5: show IP ");
			System.out.println("6: Exit");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:

				main1.add();
				main1.pL();
				main1.writeFile();

				break;
			case 2:
				main1.show();
				break;
			case 3:
				main1.viewCar();
				break;
			case 4:
				main1.insertPackage();
				break;
			case 5:
				main1.showIPackage();
				break;
			case 6:
				System.exit(0);
			}
		} while (chon != 7);
	}

	public void add() {

		System.out.println("Numb Car ? ");
		Scanner sc = new Scanner(System.in);
		int numCar = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numCar; i++) {
			Car car = new Car();
			car.insertData();
			car.setCarName("Car #" + numCar + (i + 1));
			listCar.add(car);


		}


	}

	public void pL() {

		for (Car car : listCar) {
			if (car.getYearOfManufacture() >= 2005) {
				ModernCar md = new ModernCar();
				car.setCarType("modernCar");
				int i = 0;
				md.setNumberModernCar(i + 1);

			} else if (car.getYearOfManufacture() <= 1995) {
				OldCar oc = new OldCar();
				car.setCarType("oldCar");
				int i = 0;
				oc.setNumberOldCar(i + 1);
			} else {
				MediumCar me = new MediumCar();
				car.setCarType("mediumCar");
				int i = 0;
				me.setNumberMediumCar(i + 1);
			}
		}

	}

	public void show() {
		for (Car car : listCar) {
			car.viewData();

		}
	}

	public void writeFile() {
		List<Car> listPrint = new ArrayList<>();
		try {
			FileOutputStream fos = new FileOutputStream("car.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Car car : listCar) {
				listPrint.add(car);
			}
			oos.writeObject(listPrint);
			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void viewCar() {
		System.out.println("All modernCar");
		for (Car car : listCar) {

			if (car.getCarType().equals("modernCar")) {
				car.viewData();
			}
				}
		System.out.println("All mediumCar");
		for (Car car : listCar) {
			if (car.getCarType().equals("mediumCar")) {
				car.viewData();
		}
			}
		System.out.println("All oldCar");
			for (Car car : listCar) {
			if (car.getCarType().equals("oldCar")) {
					car.viewData();
			}
		}
	}

	public void insertPackage() {

		String[] iPackage = new String[] { "A", "B", "C" };
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("number InsurancePackage ?");
		int numb = sc.nextInt();

		if (listPackage.isEmpty()) {
			for (int i = 0; i < numb; i++) {
				InsurancePackage ip = new InsurancePackage();
				ip.setIpName("Insurance Package#" + numb + (i + 1));
				int index = rd.nextInt(iPackage.length);
				ip.setPackageType(iPackage[index]);
				listPackage.add(ip);
			}

		} else {
			for (int i = 0; i < numb; i++) {
				InsurancePackage ip = new InsurancePackage();
				ip.setIpName("Insurance Package#" + (listPackage.size() + numb) + (i + 1));
				int index = rd.nextInt(iPackage.length);
				ip.setPackageType(iPackage[index]);
				listPackage.add(ip);
			}
		}

	}

	public void showIPackage() {
		for (InsurancePackage ins : listPackage) {
			ins.viewPackage();
		}
	}
}
