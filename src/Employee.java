
public class Employee {
	
	@Override
	public String toString() {
		return "Employee [departmentId=" + departmentId + ", name=" + name + "]";
	}
	public Employee(Integer departmentId, String name) {
		super();
		this.departmentId = departmentId;
		this.name = name;
	}
	private Integer departmentId;
	private String name;
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
