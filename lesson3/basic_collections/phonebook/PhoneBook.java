package lesson3.basic_collections.phonebook;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, Person> phonebook = new HashMap<>();

    void setPhoneBook (Person[] person) {
        for (Person value : person) {
            phonebook.put(value.getName(), value);
        }
    }

    void setPhoneBook (Person person) {
        phonebook.put(person.getName(), person);
    }

    void getPhone (String name) {
        if (phonebook.get(name) == null) {
            System.out.println("The phone book does not contain any phone number data for the person " + name);
        } else {
            System.out.println("The person " + name + " has phone number " + (phonebook.get(name)).getPhone() );
        }
    }

    void getEmail (String name) {
        if (phonebook.get(name) == null) {
            System.out.println("The phone book does not contain any email data for the person " + name);
        } else {
            System.out.println("The person " + name + " has email " + (phonebook.get(name)).getEmail() );
        }
    }
}
