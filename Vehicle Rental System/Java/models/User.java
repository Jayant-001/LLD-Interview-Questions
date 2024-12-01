package models;

public class User {
    int id;
    String name;
    String drivingLicence;

    public User(String name) {
        this.id = (int)(Math.random() * 101); // 0 to 100
        this.name = name;
    }
}
