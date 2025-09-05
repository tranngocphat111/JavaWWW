package fit.se.bai1;

import java.util.Date;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String mobilePhong;
    private String gender;
    private String address;
    private String city;
    private String pinCode;

    private String state;
    private String country;
    private List<String> hobbies;

    private String course;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhong() {
        return mobilePhong;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public String getCourse() {
        return course;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobilePhong(String mobilePhong) {
        this.mobilePhong = mobilePhong;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, Date dateOfBirth, String email, String mobilePhong, String gender, String address, String city, String pinCode, String state, String country, List<String> hobbies, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobilePhong = mobilePhong;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.course = course;
    }
}
