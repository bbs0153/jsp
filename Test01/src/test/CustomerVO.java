package test;

public class CustomerVO {

	private String id;
	private String name;
	private String addr;
	private String phone;
	public CustomerVO(String id, String name, String addr, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	public CustomerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
