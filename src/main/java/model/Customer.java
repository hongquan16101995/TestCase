package model;

public class Customer {
    private int ID;
    private String name;
    private int age;
    private String render;
    private String email;
    private String address;
    private String phone;

    public Customer(int ID, String name, int age, String render, String email, String address, String phone) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.render = render;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Customer(String name, int age, String render, String email, String address, String phone) {
        this.name = name;
        this.age = age;
        this.render = render;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
