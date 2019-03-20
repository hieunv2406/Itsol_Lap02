package carManager;

public class InsurancePackage {

	private String IpName;
	private String packageType;
	private boolean status;

	public InsurancePackage(String ipName, String packageType, boolean status) {
		super();
		IpName = ipName;
		this.packageType = packageType;
		this.status = status;
	}

	public InsurancePackage() {
		super();
	}

	public String getIpName() {
		return IpName;
	}

	public void setIpName(String ipName) {
		IpName = ipName;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void viewPackage() {
		System.out.println("InsurancePackage Name: " + this.IpName + "\t" + "Package Type: " + this.packageType + "\t"
				+ "status: " + this.status);
	}
}
