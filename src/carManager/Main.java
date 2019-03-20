package carManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
			System.out.println("1: Them Moi Xe Oto");
			System.out.println("2: Them Moi Cac Goi Bao Hiem");
			System.out.println("3: Mua Goi Bao Hiem Cho Oto");
			System.out.println("4: Xem thong tin oto tam thoi");
			System.out.println("5: Xem thong tin goi bao hiem tam thoi");
			System.out.println("6: Xem thong tin chi tiet da dc luu trong file");
			System.out.println("Thoat!");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:

				main1.add(); // Them moi xe oto
				main1.pL(); // Phan loai xe


				break;
			case 2:
				main1.insertPackage(); // Them moi cac goi bao hiem

				break;
			case 3:
				main1.assignAssurance(); // Mua goi bao hiem cho cac xe
				main1.writeFile(); // Ghi lai thong tin cac loai xe
				main1.writeFileIP(); // Ghi lai thong tin cac goi bao hiem

				break;
			case 4:
				main1.show(); // xem tat ca cac xe trong tien trinh
				main1.viewCar(); // xem tat ca cac xe theo tung hang
				break;
			case 5:
				main1.showIPackage(); // xem tat ca cac goi bao hiem trong tien trinh
				break;
			case 6:
				main1.readFileCar(); // doc file thong tin chi tiet tung xe tu file
				break;
			case 7:
				System.exit(0);
			}
		} while (chon != 8);
	}

	public void add() {

		System.out.println("Nhap so xe: ");
		Scanner sc = new Scanner(System.in);
		int numCar = Integer.parseInt(sc.nextLine());
		if (listCar.isEmpty()) {
		for (int i = 0; i < numCar; i++) {
			Car car = new Car();
			car.insertData();
			car.setCarName("Car #" + (i + 1));
			listCar.add(car);


		}
		} else {
			int a = listCar.size();
			for (int i = 0; i < numCar; i++) {
				Car car = new Car();
				car.insertData();
				car.setCarName("Car #" + (a + i + 1));
				listCar.add(car);
			}
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
		List<Car> listWriteCar = new ArrayList<>();
		try {
			FileOutputStream fos = new FileOutputStream("Car.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Car car : listCar) {
				listWriteCar.add(car);
			}
			oos.writeObject(listWriteCar);
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
				ip.setIpName("Insurance Package#" + (i + 1));
				int index = rd.nextInt(iPackage.length);
				ip.setPackageType(iPackage[index]);
				listPackage.add(ip);
				ip.setStatus(true);
			}

		} else {
			int a = listPackage.size();
			for (int i = 0; i < numb; i++) {
				InsurancePackage ip = new InsurancePackage();
				ip.setIpName("Insurance Package#" + (a + i + 1));
				int index = rd.nextInt(iPackage.length);
				ip.setPackageType(iPackage[index]);
				ip.setStatus(true);
				listPackage.add(ip);
			}
		}

	}

	public void showIPackage() {
		for (InsurancePackage ins : listPackage) {
			ins.viewPackage();
		}
	}

	public void writeFileIP() {
		List<InsurancePackage> listWriteIP = new ArrayList<>();
		try {
			FileOutputStream fos = new FileOutputStream("InsurancePackage.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (InsurancePackage iP : listWriteIP) {
				listWriteIP.add(iP);
			}
			oos.writeObject(listWriteIP);
			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void assignAssurance() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Insert Name Car: ");
		String nCar = sc.nextLine();
		for (Car car : listCar) {
			if (nCar.equals(car.getCarName()) && car.isHaveInsurance() == false) {

				car.viewData();
				System.out.println("cac goi bao hiem ho tro");
				if (car.getCarType().equals("modernCar")) {
					for (InsurancePackage ins : listPackage) {
						if (ins.getPackageType().equals("A") && ins.isStatus() == true) {
							ins.viewPackage();
						}

					}
					System.out.println("Nhap ten goi bao hiem can mua:");
					String nIP = sc.nextLine();
					car.setInsuranceName(nIP);
					car.setHaveInsurance(true);
					System.out.println("Successful Buying!");
					for (InsurancePackage ins : listPackage) {
						if (nIP.equals(ins.getIpName())) {
							ins.setStatus(false);
						}
					}
				}

				if (car.getCarType().equals("mediumCar")) {
					for (InsurancePackage ins : listPackage) {
						if (ins.getPackageType().equals("B") && ins.isStatus() == true) {
							ins.viewPackage();
						}
					}
					System.out.println("Nhap ten goi bao hiem can mua:");
					String nIP = sc.nextLine();
					car.setInsuranceName(nIP);
					car.setHaveInsurance(true);
					System.out.println("Successful Buying!");
					for (InsurancePackage ins : listPackage) {
						if (nIP.equals(ins.getIpName())) {
							ins.setStatus(false);
						}
					}
				}

				if (car.getCarType().equals("oldCar")) {
					for (InsurancePackage ins : listPackage) {
						if (ins.getPackageType().equals("C") && ins.isStatus() == true) {
							ins.viewPackage();
						}
					}
					System.out.println("Nhap ten goi bao hiem can mua:");
					String nIP = sc.nextLine();
					car.setInsuranceName(nIP);
					car.setHaveInsurance(true);
					System.out.println("Successful Buying!");
					for (InsurancePackage ins : listPackage) {
						if (nIP.equals(ins.getIpName())) {
							ins.setStatus(false);
						}
					}
				}



			}else if(nCar.equals(car.getCarName()) && car.isHaveInsurance() == true) {

				System.out.println("Unavailable Buying!");
			}
		}



	}

	public void readFileCar() {
		List<Car> listReadCar = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("Car.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			listReadCar = (List<Car>) ois.readObject();
			ois.close();
			fis.close();
			for (Car car : listReadCar) {
				car.displayData();
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
