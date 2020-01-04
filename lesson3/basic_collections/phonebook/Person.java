package lesson3.basic_collections.phonebook;

public class Person {
    /**
     *  каждой записи всего два поля: phone, e-mail
     */
    final private String phone;
    final private String email;

    Person (String phone, String email){
        this.phone = phone;
        this.email = email;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }
}
