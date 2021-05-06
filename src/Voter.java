
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
class Voter  implements Serializable {
    private String full_name,gender,station,wereda,address,user,  password;
     private int vot_no,state,age,phone;
    

    public void setUser(String user_name) {
        this.user = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
   

    public int getVot_no() {
        return vot_no;
    }

    public void setVot_no(int vot_no) {
        this.vot_no = vot_no;
    }

  

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setWereda(String wereda) {
        this.wereda = wereda;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getGender() {
        return gender;
    }

    public String getStation() {
        return station;
    }

    public String getWereda() {
        return wereda;
    }

    public String getAddress() {
        return address;
    }

    public int getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }
    
    
    
}

