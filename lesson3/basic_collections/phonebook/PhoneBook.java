package lesson3.basic_collections.phonebook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<Person>> phonebook = new HashMap<>();

    void setPerson (String surname, Person person) {
        if (phonebook.containsKey(surname)) {
            phonebook.get(surname).add(person);
        } else {
            ArrayList<Person> data = new ArrayList<Person>();
            data.add(person);
            phonebook.put(surname, data);
        }
    }

    public ArrayList<String> getPersonPhone (String surname) {
        ArrayList<Person> person = phonebook.get(surname);
        if (person == null) {
            return null;
        } else {
            ArrayList<String> personPhones = new ArrayList<>();
            for (int i = 0; i < person.size(); i++) {
                personPhones.add(person.get(i).getPhone());
            }
            return personPhones;
        }
    }

    public ArrayList<String> getPersonEmail (String surname) {
        ArrayList<Person> person = phonebook.get(surname);
        if (person == null) {
            return null;
        } else {
            ArrayList<String> personEmails = new ArrayList<>();
            for (int i = 0; i < person.size(); i++) {
                personEmails.add(person.get(i).getEmail());
            }
            return personEmails;
        }
    }
}
