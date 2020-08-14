package streamapi.intemediateoperations.sorted;

public class Product {
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", deptName=" + deptName + ", pcost=" + pcost + "]";
	}
	private int pid;
	private String pname;
	private String deptName;
	private int pcost;
	
	public Product(int pid, String pname, String deptName, int pcost) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.deptName = deptName;
		this.pcost = pcost;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

}
