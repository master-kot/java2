package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

//Я много думал как сделать правильнее, в итоге решил загонять внутрь ArrayList<Person> каждый элемент HashMap,
//в зависимости есть ли уже такой Key в HashMap, мы получаем Value в виде ArrayList соответствующего размера
class PhoneBook {
    private HashMap<String, ArrayList<Person>> phonebook = new HashMap<>();

    void setPhoneBook(String name, Person person) {
        if (phonebook.containsKey(name)) {
            ArrayList<Person> data = phonebook.get(name);
            data.add(person);
            phonebook.replace(name, data);
        } else {
            ArrayList<Person> data = new ArrayList<Person>();
            data.add(person);
            phonebook.put(name, data);
        }
    }

    void getPhone(String name) {
        if (phonebook.get(name) == null) {
            System.out.println("The phone book does not contain any phone number data for the person " + name);
        } else {
            ArrayList<Person> data = phonebook.get(name);
            for (int i = 0; i < data.size(); i++) {
                System.out.println("The person " + name + " has phone number " + data.get(i).getPhone());
            }
        }
    }

    void getEmail(String name) {
        if (phonebook.get(name) == null) {
            System.out.println("The phone book does not contain any email data for the person " + name);
        } else {
            ArrayList<Person> data = phonebook.get(name);
            for (int i = 0; i < data.size(); i++) {
                System.out.println("The person " + name + " has email " + data.get(i).getEmail());
            }
        }
    }
}

class Person {
    private int phone;
    private String email;

    Person (int phone, String email){
        this.phone = phone;
        this.email = email;
    }

    int getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook myBook = new PhoneBook();
        myBook.setPhoneBook("Ivanov", new Person(111111, "111111@ya.ru"));
        myBook.setPhoneBook("Petrov", new Person( 222222, "222222@ya.ru"));
        myBook.setPhoneBook("Sidorov", new Person( 333333, "333333@ya.ru"));
        myBook.setPhoneBook("Kozlov", new Person( 444444, "444444@ya.ru"));
        myBook.setPhoneBook("Zaytsev", new Person( 555555, "555555@ya.ru"));
        myBook.setPhoneBook("Ivanov", new Person( 666666, "666666@ya.ru"));

        myBook.getPhone("Ivanov");
        myBook.getEmail("Ivanov");
        myBook.getPhone("Petrov");
        myBook.getEmail("Petrov");
        myBook.getPhone("Bobrov");
        myBook.getEmail("Bobrov");
    }
}