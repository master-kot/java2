package lesson3.basic_collections.phonebook;

public class Person {
    final private String name;
    final private int phone;
    final private String email;

    Person (String name, int phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    int getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }

    String getName() {
        return name;
    }
}
