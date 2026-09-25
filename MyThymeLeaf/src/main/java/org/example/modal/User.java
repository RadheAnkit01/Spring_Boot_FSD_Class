package org.example.modal;


public class User {
    private int Id;
    private String name;
    private String city;
    private long phone;

    public User() {
    }

    public User(int id, String name, String city, long phone) {
        Id = id;
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
