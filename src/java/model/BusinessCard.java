package model;

public class BusinessCard {

    private int id;
    private String name, email, tel, address;

    public BusinessCard(int id, String name, String tel, String email, String address) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "BusinessCard{" + "id=" + id + ", name=" + name+ ", email=" + email + ", address=" + address + ", tel=" + tel + '}';
    }

}
