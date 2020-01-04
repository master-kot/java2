package lesson3.basic_collections.phonebook;

public class Main {
    public static void main(String[] args) {
        Person[] person = new Person[5];
        person[0] = new Person("Ivanov", 111111, "111111@ya.ru");
        person[1] = new Person("Petrov", 222222, "222222@ya.ru");
        person[2] = new Person("Sidorov", 333333, "333333@ya.ru");
        person[3] = new Person("Kozlov", 444444, "444444@ya.ru");
        person[4] = new Person("Zaytsev", 555555, "555555@ya.ru");
        Person p5 = new Person("Ivanov", 666666, "666666@ya.ru");

        PhoneBook myBook = new PhoneBook();
        myBook.setPhoneBook(person);
        myBook.setPhoneBook(p5);
        myBook.getPhone("Ivanov");
        myBook.getEmail("Ivanov");
        myBook.getPhone("Bobrov");
        myBook.getEmail("Bobrov");
    }
}
