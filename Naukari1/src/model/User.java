package model;

public class User { public User() {}
  private String centerName = null; private String status = null; private String pass = null; private String state = null; private String city = null; private String address = null; private String phno = null; private String dob = null; private String email = null; private String name = null;
  
  public String getCenterName() {
    return centerName;
  }
  
  public void setCenterName(String centerName) {
    if (centerName != null) {
      this.centerName = centerName;
    }
    this.centerName = centerName;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    if (name != null) {
      name.trim();
    }
    
    this.name = name;
  }
  
  public void setEmail(String email) {
    if (email != null) {
      email.trim();
    }
    this.email = email;
  }
  
  public void setDob(String dob)
  {
    if (dob != null) {
      dob.trim();
    }
    this.dob = dob;
  }
  
  public void setPhno(String phno) {
    if (phno != null) {
      phno.trim();
    }
    this.phno = phno;
  }
  
  public void setAddress(String address) {
    if (address != null) {
      address.trim();
    }
    this.address = address;
  }
  
  public void setCity(String city) {
    if (city != null) {
      city.trim();
    }
    this.city = city;
  }
  
  public void setState(String state) {
    if (state != null) {
      state.trim();
    }
    this.state = state;
  }
  
  public void setPass(String pass) {
    if (pass != null) {
      pass.trim();
    }
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
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status) {
    if (status != null) {
      status.trim();
    }
    this.status = status;
  }
  
  public String toString()
  {
    return 
      "User [name=" + name + ", email=" + email + ", dob=" + dob + ", phno=" + phno + ", address=" + address + ", city=" + city + ", state=" + state + ", pass=" + pass + "status=  " + status + "centerName: " + centerName + "]";
  }
}