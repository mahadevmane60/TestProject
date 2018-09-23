package model;
public class User {

	private String name=null, email=null, dob=null, phno=null, address=null, city=null, state=null, pass=null,status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

    public String getPass() {
		return pass;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getPhno() {
		return phno;
	}
	
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dob=" + dob + ", phno=" + phno + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", pass=" + pass + "status=  "+status+ "]";
	}
	
	
}
