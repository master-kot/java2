package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

class PhoneBook {
    private HashMap<String, DataPerson> phonebook = new HashMap<>();

    private class DataPerson {
        private ArrayList<Integer> phone = new ArrayList<>();
        private String email;

        DataPerson (int phone, String email) {
            this.phone.add(phone);
            this.email = email;
        }

        void setPhone(int phone) {
            this.phone.add(phone);
        }

        void setEmail(String email) {
            this.email = email;
        }

        ArrayList<Integer> getPhone() {
            return phone;
        }

        String getEmail() {
            return email;
        }

    }

/*    void setPhoneBook (Person[] person) {
        for (Person value : person) {
            phonebook.put(value.getName(), value);
        }
    }*/

/*    void setPhoneBook (Person[] person) {
        for (lesson3.simple.Person value : person) {
            if (phonebook.containsKey(value.getName()) ) {
                int j = mapArrayParts.get(s);
                mapArrayParts.replace(s, ++j);
            } else {
                phonebook.put(value.getName(), value);
            }

        }
    }
*/



    void setPhoneBook (Person person) {
        if ( phonebook.containsKey(person.getName()) ) {
            DataPerson data = phonebook.get(person.getName());
            data.setPhone(person.getPhone());
            phonebook.put(person.getName(), data);
        } else {
            phonebook.put(person.getName(), new DataPerson(person.getPhone(), person.getEmail()));
        }
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
        Person[] person = new Person[5];
        person[0] = new Person("Ivanov", 111111, "111111@ya.ru");
        person[1] = new Person("Petrov", 222222, "222222@ya.ru");
        person[2] = new Person("Sidorov", 333333, "333333@ya.ru");
        person[3] = new Person("Kozlov", 444444, "444444@ya.ru");
        person[4] = new Person("Zaytsev", 555555, "555555@ya.ru");
        Person p5 = new Person("Ivanov", 666666, "666666@ya.ru");
        Person p6 = new Person("Ivanov", 777777, "666666@ya.ru");

        PhoneBook myBook = new PhoneBook();
//        myBook.setPhoneBook(person);
        myBook.setPhoneBook(p5);
        myBook.setPhoneBook(p6);
        myBook.getPhone("Ivanov");
        myBook.getEmail("Ivanov");
        myBook.getPhone("Bobrov");
        myBook.getEmail("Bobrov");
    }
}