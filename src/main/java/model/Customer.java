package model;

import java.util.Date;

public class Customer {
    private String name;
    private int age;
    private String render;
    private String email;
    private String address;
    private String phone;
    private String account;
    private String password;
    private Date dateCreate;

    public Customer(String name, int age, String render, String email, String address,
                    String phone, String account, String password, Date dateCreate) {
        this.name = name;
        this.age = age;
        this.render = render;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.account = account;
        this.password = password;
        this.dateCreate = dateCreate;
    }

    public Customer(String name, int age, String render, String email, String address, String phone, String account) {
        this.name = name;
        this.age = age;
        this.render = render;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.account = account;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
