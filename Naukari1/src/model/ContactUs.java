
package model;

public class ContactUs {
    String name,city,subject,phnumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }
     @Override
    public String toString() {
        return "ContactUs{" + "name=" + name + ", city=" + city + ", subject=" + subject + ", phnumber=" + phnumber + '}';
    }
}
