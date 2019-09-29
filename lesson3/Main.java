package lesson3;

import java.util.HashMap;

class PhoneBook {
    private HashMap<String, Person> phonebook = new HashMap<>();

    void setPhoneBook (Person[] person) {
        for (Person value : person) {
            phonebook.put(value.getName(), value);
        }
    }

    void setPhoneBook (String name, Person person) {
            phonebook.put(name, person);
    }

    void getPhone (String name) {
        if (phonebook.get(name) == null) {
            System.out.println("Data did not find!");
        } else {
            System.out.println("For name " + name + " phone is " +  (phonebook.get(name)).getPhone() );
        }
    }

    void getEmail (String name) {
        if (phonebook.get(name) == null) {
            System.out.println("Data did not find!");
        } else {
            System.out.println("For name " + name + " email is " + (phonebook.get(name)).getEmail() );
        }
    }


}

class Person {
    private String name;
    private int phone;
    private String email;

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

public class Main {
    public static void main(String[] args) {
/*        Person[] person = new Person[6];
        person[0] = new Person("Ivanov", 111111, "111111@ya.ru");
        person[1] = new Person("Petrov", 222222, "222222@ya.ru");
        person[3] = new Person("Sidorov", 333333, "333333@ya.ru");
        person[4] = new Person("Kozlov", 444444, "444444@ya.ru");
        person[5] = new Person("Zaytsev", 555555, "555555@ya.ru");
*/
        Person p1 = new Person("Ivanov", 111111, "111111@ya.ru");
        Person p2 = new Person("Petrov", 222222, "222222@ya.ru");
        Person p3 = new Person("Sidorov", 333333, "333333@ya.ru");
        Person p4 = new Person("Kozlov", 444444, "444444@ya.ru");
        Person p5 = new Person("Zaytsev", 555555, "555555@ya.ru");


        PhoneBook myBook = new PhoneBook();
        myBook.setPhoneBook("Ivanov", p1);
        myBook.getPhone("Ivanov");
        myBook.getEmail("Ivanov");
    }
}